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
        List<Integer> list = preorderTraversal4(TreeNode.createTree(new Integer[]{1, null, 2, 3}));
        System.out.println(list);
    }

    /**
     * 迭代
     *
     * @param root
     * @return java.util.List<java.lang.Integer>
     * @author Hezeming
     */
    public static List<Integer> preorderTraversal4(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        while (root != null || !stack.isEmpty()) {
            // 一直往左节点迭代，直到左节点不存在
            while (root != null) {
                list.add(root.val);
                stack.push(root);
                root = root.left;
            }
            // 拿到的是上一个左节点
            root = stack.pop();
            root = root.right;
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
    public static List<Integer> preorderTraversal3(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        preorderTraversal3(root, list);
        return list;
    }

    public static void preorderTraversal3(TreeNode root, List<Integer> list) {
        if (root != null) {
            list.add(root.val);
            preorderTraversal3(root.left, list);
            preorderTraversal3(root.right, list);
        }
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
