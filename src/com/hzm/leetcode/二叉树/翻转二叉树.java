package com.hzm.leetcode.二叉树;

/**
 * https://leetcode-cn.com/problems/invert-binary-tree/
 *
 * @author Hezeming
 * @version 1.0
 * @date 2020年09月29日
 */
public class 翻转二叉树 {

    public static void main(String[] args) {

    }



    public static TreeNode invertTree2(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode right = invertTree2(root.left);
        TreeNode left = invertTree2(root.right);
        root.left = left;
        root.right = right;
        return root;
    }





    public static TreeNode invertTree(TreeNode root) {
        if (root != null) {
            TreeNode left = invertTree(root.left);
            TreeNode right = invertTree(root.right);
            root.right = left;
            root.left  = right;
        }
        return root;
    }
}


