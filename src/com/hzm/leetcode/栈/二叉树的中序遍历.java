package com.hzm.leetcode.栈;

import com.hzm.leetcode.二叉树.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/binary-tree-inorder-traversal/
 *
 * @author Hezeming
 * @version 1.0
 * @date 2020年11月19日
 */
public class 二叉树的中序遍历 {

    public static void main(String[] args) {

    }

    public static List<Integer> inorderTraversal(TreeNode root) {
        return calc(root, new ArrayList<>());
    }

    /**
     * 递归
     *
     * @param root
     * @param list
     * @return java.util.List<java.lang.Integer>
     * @author Hezeming
     */
    public static List<Integer> calc(TreeNode root, List<Integer> list) {
        if (root == null) {
            return list;
        }
        calc(root.left, list);
        list.add(root.val);
        calc(root.right, list);
        return list;
    }

    public static List<Integer> stack(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();

        while (root != null && !stack.isEmpty()) {
            while (root != null) {
                // 一直往左节点遍历，直到左节点为空退出
                stack.push(root);
                root = root.left;
            }
            // 左节点为空，root回到上一个节点（栈顶）
            root = stack.pop();
            // 存值
            list.add(root.val);
            // 外部判断配合开始遍历右节点
            root = root.right;
        }

        return list;
    }
}
