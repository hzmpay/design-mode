package com.hzm.leetcode.二叉树;

/**
 * https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/
 *
 * @author Hezeming
 * @version 1.0
 * @date 2020年09月30日
 */
public class 二叉树的最近公共祖先 {

    public static void main(String[] args) {

    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == p || root == q || root == null) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left == null) {
            // 左边找不到p，q，说明两个都在右边
            return right;
        }
        if (right == null) {
            // 右边找不到p，q，说明两个都在左边
            return left;
        }
        return root;
    }
}
