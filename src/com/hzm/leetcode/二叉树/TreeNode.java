package com.hzm.leetcode.二叉树;

import java.util.Deque;
import java.util.LinkedList;

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

    TreeNode(int x) {
        val = x;
    }

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
        System.out.println(tree);
    }
}
