package com.hzm.leetcode.二叉树;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/validate-binary-search-tree/
 *
 * @author Hezeming
 * @version 1.0
 * @date 2020年11月24日
 */
public class 验证二叉搜索树 {

    static int rootValue;

    public static void main(String[] args) {
        Integer[] arr = {3, null, 30, 10, null, null, 15, null, 45};
        TreeNode root = TreeNode.createTree(arr);
        System.out.println(isValidBST(root));
    }

    public static boolean isValidBST(TreeNode root) {
        return help(root, null, null);
    }

    /**
     * 中序遍历，左中右，肯定是从小到大，只要当前节点值小于前一个节点，肯定不是二叉搜索树
     *
     * @param root
     * @return boolean
     * @author Hezeming
     */
    public static boolean help2(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<>();
        int preVal = -1;
        // 按出栈中序
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (root.val < preVal) {
                return false;
            }
            preVal = root.val;
            root = root.right;
        }
        return true;
    }

    public static List<Integer> center(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        // 按出栈中序
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            list.add(root.val);
            root = root.right;
        }
        return list;
    }

    /**
     * 递归
     *
     * @param node  当前节点
     * @param lower 必须小于
     * @param upper 必须大于
     * @return boolean
     * @author Hezeming
     */
    public static boolean help(TreeNode node, Integer lower, Integer upper) {
        if (node == null) {
            return true;
        }
        int val = node.val;
        if (lower != null && lower >= val) {
            return false;
        }
        if (upper != null && val >= upper) {
            return false;
        }
        return help(node.left, lower, val) && help(node.right, val, upper);
    }

}
