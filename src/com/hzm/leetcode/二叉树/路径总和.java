package com.hzm.leetcode.二叉树;

/**
 * https://leetcode-cn.com/problems/path-sum/
 *
 * @author Hezeming
 * @version 1.0
 * @date 2021年01月11日
 */
public class 路径总和 {

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            // 左右节点都为null
            return root.val == sum;
        }
        sum = sum - root.val;
        return hasPathSum(root.left, sum) || hasPathSum(root.right, sum);
    }
}
