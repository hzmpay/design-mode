//根据一棵树的前序遍历与中序遍历构造二叉树。 
//
// 注意: 
//你可以假设树中没有重复的元素。 
//
// 例如，给出 
//
// 前序遍历 preorder = [3,9,20,15,7]
//中序遍历 inorder = [9,3,15,20,7] 
//
// 返回如下的二叉树： 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7 
// Related Topics 树 深度优先搜索 数组 
// 👍 1072 👎 0


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

    static Map<Integer, Integer> map;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // 前：中  左  右
        // 中：左  中  右
        map = new HashMap<>(inorder.length * 4 / 3 + 1);
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return buildTree(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }

    public TreeNode buildTree(int[] preorder, int[] inorder, int preOrderLeft, int preOrderRight, int inOrderLeft, int inOrderRight) {
        // 退出条件
        if (preOrderLeft > preOrderRight) {
            return null;
        }
        // 前：中  左  右
        // 中：左  中  右
        // 前序遍历第一个为root
        int preOrderRoot = preOrderLeft;
        int rootVal = preorder[preOrderRoot];
        TreeNode root = new TreeNode(rootVal);
        // 中序遍历中根节点坐标
        Integer inOrderRootIndex = map.get(rootVal);
        // 构建左子树
        int preOrderLeftLen = inOrderRootIndex - inOrderLeft;
        root.left = buildTree(preorder, inorder, preOrderRoot + 1, preOrderRoot + preOrderLeftLen, inOrderLeft, inOrderRootIndex - 1);
        // 构建右子树
        root.right = buildTree(preorder, inorder, preOrderRoot + preOrderLeftLen + 1, preOrderRight, inOrderRootIndex + 1, inOrderRight);
        return root;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
