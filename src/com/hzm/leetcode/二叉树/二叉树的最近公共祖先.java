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

    public static TreeNode lowestCommonAncestor3(TreeNode root, TreeNode p, TreeNode q) {
        // 阻断条件，p和q同时在root下面找，找到一个就返回
        if (root == null || root == p || root == q) {
            return root;
        }
        //
        TreeNode left = lowestCommonAncestor3(root.left, p, q);
        TreeNode right = lowestCommonAncestor3(root.right, p, q);
        // 左边一个都没找到，说明p，q都在右边
        if (left == null) {
            return right;
        }
        // 右边一个都没找到，说明p，q都在左边
        if (right == null) {
            return left;
        }
        // 两边各有一个，说明root是根节点
        return root;
    }

    public static TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        // 都在右边
        if (left == null) {
            return right;
        }
        // 都在左边
        if (right == null) {
            return left;
        }
        return root;
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
