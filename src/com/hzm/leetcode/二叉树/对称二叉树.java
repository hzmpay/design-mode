package com.hzm.leetcode.二叉树;

/**
 * https://leetcode-cn.com/problems/symmetric-tree/
 *
 * @author Hezeming
 * @version 1.0
 * @date 2020年11月23日
 */
public class 对称二叉树 {

    public static void main(String[] args) {

    }

    public boolean isSymmetric2(TreeNode root) {
        if (root == null) {
            return false;
        }
        return isSymmetric2(root.left, root.right);
    }

    public static boolean isSymmetric2(TreeNode left, TreeNode right) {
        if (left != null && right != null) {
            return left.val == right.val && isSymmetric2(left.left, right.right) && isSymmetric2(left.right, right.left);
        } else if (left == null && right == null) {
            return true;
        } else {
            // 一个为空一个不为空肯定不对称
            return false;
        }
    }

    public static boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isSym(root.left, root.right);
    }

    public static boolean isSym(TreeNode left, TreeNode right) {
        // 左右为null对称
        if (left == null && right == null) {
            return true;
        } else if (left == null || right == null) {
            // 存在一边为null，一边不为null直接返回false
            return false;
        } else {
            if (left.val == right.val) {
                return isSym(left.left, right.right) && isSym(left.right, right.left);
            }
            return false;
        }
    }
}
