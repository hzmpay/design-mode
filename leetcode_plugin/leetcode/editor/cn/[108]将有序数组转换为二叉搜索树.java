//将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。 
//
// 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。 
//
// 示例: 
//
// 给定有序数组: [-10,-3,0,5,9],
//
//一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：
//
//      0
//     / \
//   -3   9
//   /   /
// -10  5
// 
// Related Topics 树 深度优先搜索 
// 👍 661 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null) {
            return null;
        }
        return createNode(nums, 0, nums.length - 1);
    }

    public TreeNode createNode(int[] nums, int left, int right) {
        if (left > right) {
            // 说明上一轮剩余一个节点了，无需平衡
            return null;
        }
        // 选取中间位置左边的数字作为根节点
        int middle = (left + right) / 2;
        // 右边为根节点
//        int middle = (left + right + 1) / 2;

        // 根节点
        TreeNode treeNode = new TreeNode(nums[middle]);

        treeNode.left = createNode(nums, left, middle - 1);
        treeNode.right = createNode(nums, middle + 1, right);
        return treeNode;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
