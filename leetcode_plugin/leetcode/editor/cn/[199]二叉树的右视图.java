//给定一棵二叉树，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。 
//
// 示例: 
//
// 输入: [1,2,3,null,5,null,4]
//输出: [1, 3, 4]
//解释:
//
//   1            <---
// /   \
//2     3         <---
// \     \
//  5     4       <---
// 
// Related Topics 树 深度优先搜索 广度优先搜索 
// 👍 396 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
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
    public List<Integer> rightSideView(TreeNode root) {
        // 层次遍历
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        // 存储上一级的TreeNode
        List<TreeNode> list = Arrays.asList(root);
        while (!list.isEmpty()) {
            // 存储当前级的TreeNode
            List<TreeNode> curList = new ArrayList<>();
            for (TreeNode treeNode : list) {
                if (treeNode.left != null) {
                    curList.add(treeNode.left);
                }
                if (treeNode.right != null) {
                    curList.add(treeNode.right);
                }
            }
            result.add(list.get(list.size() - 1).val);
            list = curList;
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
