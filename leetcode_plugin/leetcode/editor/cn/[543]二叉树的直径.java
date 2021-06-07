//给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过也可能不穿过根结点。 
//
// 
//
// 示例 : 
//给定二叉树 
//
//           1
//         / \
//        2   3
//       / \     
//      4   5    
// 
//
// 返回 3, 它的长度是路径 [4,2,1,3] 或者 [5,2,1,3]。 
//
// 
//
// 注意：两结点之间的路径长度是以它们之间边的数目表示。 
// Related Topics 树 
// 👍 711 👎 0


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

    /**
     * 从1开始，因为空数组返回是0（结果-1）
     */
    int maxValue = 1;

    public int diameterOfBinaryTree(TreeNode root) {
        help(root);
        return maxValue - 1;
    }

    public int help(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int l = help(root.left);
        int r = help(root.right);
        // 最大长度 = 左节点的最大树高 + 右节点的最大树高 + 1
        // 每轮计算当前节点的最长路线
        maxValue = Math.max(l + r + 1, maxValue);
        return 1 + Math.max(l, r);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
