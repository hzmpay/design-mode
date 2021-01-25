package com.hzm.leetcode.二叉树;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/flatten-binary-tree-to-linked-list/
 *
 * @author Hezeming
 * @version 1.0
 * @date 2020年11月23日
 */
public class 二叉树展开为链表 {

    public static void main(String[] args) {

    }

    public static void flatten2(TreeNode root) {

    }
    public static TreeNode preOrderTraversal2(TreeNode root, TreeNode curNode) {
        if (root != null) {
            curNode.right = root;
            curNode = curNode.right;
            preOrderTraversal2(root.left, curNode);
            preOrderTraversal2(root.right, curNode);
        }
        return curNode;
    }

    public static void flatten(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        preOrderTraversal(root, list);
        // 第一个肯定是root
        TreeNode pre = root;
        for (int i = 1; i < list.size(); i++) {
            pre.left = null;
            TreeNode cur = list.get(i);
            pre.right = cur;
            pre = cur;
        }
        if (pre != null) {
            pre.left = null;
        }
    }

    public static void preOrderTraversal(TreeNode root, List<TreeNode> list) {
        if (root != null) {
            list.add(root);
            preOrderTraversal(root.left, list);
            preOrderTraversal(root.right, list);
        }
    }
}
