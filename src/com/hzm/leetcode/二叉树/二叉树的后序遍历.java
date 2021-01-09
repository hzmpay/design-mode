package com.hzm.leetcode.二叉树;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/binary-tree-postorder-traversal/
 *
 * @author Hezeming
 * @version 1.0
 * @date 2020年12月29日
 */
public class 二叉树的后序遍历 {

    public static void main(String[] args) {

    }

    /**
     * 栈的方式
     *
     * @param root
     * @return java.util.List<java.lang.Integer>
     * @author Hezeming
     */
    public static List<Integer> postorderTraversal2(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root != null) {
            return list;
        }
        Deque<TreeNode> stack = new LinkedList<>();
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            TreeNode treeNode = stack.pop();
            int centerVal = treeNode.val;
            root = treeNode.right;
            list.add(root.val);
            list.add(centerVal);
        }
        return list;
    }

    /**
     * 递归
     *
     * @param root
     * @return java.util.List<java.lang.Integer>
     * @author Hezeming
     */
    public static List<Integer> postorderTraversal1(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root != null) {
            postorderTraversal(root, list);
        }
        return list;
    }

    public static void postorderTraversal(TreeNode root, List<Integer> list) {
        if (root != null) {
            postorderTraversal(root.left, list);
            postorderTraversal(root.right, list);
            list.add(root.val);
        }
    }
}
