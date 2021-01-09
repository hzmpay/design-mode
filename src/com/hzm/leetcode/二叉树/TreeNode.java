package com.hzm.leetcode.二叉树;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Set;
import java.util.TreeSet;

/**
 * 二叉树节点
 *
 * @author Hezeming
 * @version 1.0
 * @date 2020年09月29日
 */
public class TreeNode {

    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int x) {
        val = x;
    }

    /**
     * 二叉树输出
     *
     * @param
     * @return void
     * @author Hezeming
     */
    public void out() {
        System.out.println(val);
        Set<Integer> set = new TreeSet<>();
        childNodeOut(left, right, set, 0);
    }

    public void childNodeOut(TreeNode left, TreeNode right, Set<Integer> set, int level) {
        final boolean isLeft = left != null;
        final boolean isRight = right != null;
        if (!isLeft && !isRight) {
            return;
        }

        Integer leftVal = null;
        if (isLeft) {
            leftVal = left.val;
        }
        Integer rightVal = null;
        if (isRight) {
            rightVal = right.val;
        }
        if (set.contains(level)) {
            System.out.print(leftVal + " " + rightVal + " ");
        } else {
            System.out.println(leftVal + " " + rightVal + " ");
            set.add(level++);
        }
        if (isLeft) {
            childNodeOut(left.left, left.right, set, level);
        }
        if (isRight) {
            childNodeOut(right.left, right.right, set, level);
        }
    }

    /**
     * 根据数组创建二叉树
     *
     * @param arr
     * @return com.hzm.leetcode.二叉树.TreeNode
     * @author Hezeming
     */
    public static TreeNode createTree(Integer[] arr) {
        if (arr.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(arr[0]);
        Deque<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean isLeft = true;
        for (int i = 1; i < arr.length; i++) {
            TreeNode node = queue.peek();
            if (isLeft) {
                if (arr[i] != null) {
                    node.left = new TreeNode(arr[i]);
                    queue.offer(node.left);
                }
                isLeft = false;
            } else {
                if (arr[i] != null) {
                    node.right = new TreeNode(arr[i]);
                    queue.offer(node.right);
                }
                queue.poll();
                isLeft = true;
            }
        }
        return root;
    }

    public static void main(String[] args) {
        Integer[] arr = {1, 2, 5, 3, 4, null, 6};
        TreeNode tree = createTree(arr);
        tree.out();
    }
}
