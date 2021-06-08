package com.hzm.leetcode.二叉树;

/**
 * https://leetcode-cn.com/problems/merge-two-binary-trees/
 *
 * @author Hezeming
 * @version 1.0
 * @date 2020年09月29日
 */
public class 合并二叉树 {

    public static void main(String[] args) {
        TreeNode treeNode = mergeTrees2(TreeNode.createTree(new Integer[]{1, 3, 2, 5}), TreeNode.createTree(new Integer[]{2, 1, 3, null, 4, null, 7}));
        treeNode.out();
    }

    public static TreeNode mergeTrees2(TreeNode t1, TreeNode t2) {
        if (t1 == null) {
            return t2;
        } else if (t2 == null) {
            return t1;
        } else {
            t1.val = t1.val + t2.val;
            t1.left = mergeTrees2(t1.left, t2.left);
            t1.right = mergeTrees2(t1.right, t2.right);
            return t1;
        }
    }

    /**
     * 深度优先遍历：三种递归形式，前序，中序，后序
     *
     * @param t1
     * @param t2
     * @return com.hzm.leetcode.TreeNode
     * @author Hezeming
     */
    public static TreeNode mergeTrees1(TreeNode t1, TreeNode t2) {
        // 采用前序遍历
        if (t1 == null) {
            return t2;
        } else if (t2 == null) {
            return t1;
        } else {
            // t1和t2同时不为null说明值等于两个相加
            TreeNode treeNode = new TreeNode(t1.val + t2.val);
            treeNode.left = mergeTrees1(t1.left, t2.left);
            treeNode.right = mergeTrees1(t1.right, t2.right);
            return treeNode;
        }

    }
}
