package com.hzm.leetcode.二叉树;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/binary-tree-preorder-traversal/
 *
 * @author Hezeming
 * @version 1.0
 * @date 2020年12月29日
 */
public class 二叉树的前序遍历 {

    public static void main(String[] args) {

    }

    /**
     * 递归
     *
     * @param root
     * @return java.util.List<java.lang.Integer>
     * @author Hezeming
     */
    public static List<Integer> preOrderTraversal1(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        preOrderTraversal(root, list);
        return list;
    }

    public static void preOrderTraversal(TreeNode root, List<Integer> list) {
        if (root != null) {
            list.add(root.val);
            preOrderTraversal(root.left, list);
            preOrderTraversal(root.right, list);
        }
    }

    /**
     * 栈的形式
     *
     * @param root
     * @return java.util.List<java.lang.Integer>
     * @author Hezeming
     */
    public static List<Integer> preOrderTraversal2Demo(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        while (!stack.isEmpty() || root != null) {
            // 从中 -》 左
            while (root != null) {
                result.add(root.val);
                stack.push(root);
                root = root.left;
                // 左节点为空退出
            }
            // 中间节点
            root = stack.pop();
            root = root.right;
        }
        return result;
    }

    /**
     * 栈的形式
     *
     * @param root
     * @return java.util.List<java.lang.Integer>
     * @author Hezeming
     */
    public static List<Integer> preOrderTraversal2(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Deque<TreeNode> stack = new LinkedList<>();
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                list.add(root.val);
                stack.push(root);
                root = root.left;
            }
            TreeNode treeNode = stack.pop();
            root = treeNode.right;
        }
        return list;
    }
}
