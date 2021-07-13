//给定一个二叉树，判断其是否是一个有效的二叉搜索树。 
//
// 假设一个二叉搜索树具有如下特征： 
//
// 
// 节点的左子树只包含小于当前节点的数。 
// 节点的右子树只包含大于当前节点的数。 
// 所有左子树和右子树自身必须也是二叉搜索树。 
// 
//
// 示例 1: 
//
// 输入:
//    2
//   / \
//  1   3
//输出: true
// 
//
// 示例 2: 
//
// 输入:
//    5
//   / \
//  1   4
//     / \
//    3   6
//输出: false
//解释: 输入为: [5,1,4,null,null,3,6]。
//     根节点的值为 5 ，但是其右子节点值为 4 。
// 
// Related Topics 树 深度优先搜索 递归 
// 👍 878 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.Deque;
import java.util.LinkedList;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isValidBST(TreeNode root) {
        // 1.通过中序遍历
//        return isValidBST1(root);
        // 2.通过递归
        return isValidBST2(root, null, null);

    }

    /**
     * 递归
     *
     * @param root
     * @return boolean
     * @author Hezeming
     */
    public boolean isValidBST2(TreeNode root, Integer minVal, Integer maxVal) {
        if (root == null) {
            return true;
        }
        if (minVal != null && root.val <= minVal) {
            return false;
        }
        if (maxVal != null && root.val >= maxVal) {
            return false;
        }
        return isValidBST2(root.left, minVal, root.val) && isValidBST2(root.right, root.val, maxVal);
    }

    /**
     * 中序遍历
     *
     * @param root
     * @return boolean
     * @author Hezeming
     */
    public boolean isValidBST1(TreeNode root) {
        if (root == null) {
            return true;
        }
        Deque<TreeNode> stack = new LinkedList<>();
        double preVal = -Double.MAX_VALUE;
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (preVal >= root.val) {
                return false;
            }
            preVal = root.val;
            root = root.right;
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
