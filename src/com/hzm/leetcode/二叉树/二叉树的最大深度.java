package com.hzm.leetcode.二叉树;

/**
 * https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/
 *
 * @author Hezeming
 * @version 1.0
 * @date 2020年10月13日
 */
public class 二叉树的最大深度 {

    public static void main(String[] args) {

    }

    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Integer.max(maxDepth(root.left), maxDepth(root.right));
    }
}
