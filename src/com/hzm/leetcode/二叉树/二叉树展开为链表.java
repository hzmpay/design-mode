package com.hzm.leetcode.二叉树;

import sun.rmi.log.LogInputStream;

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
        TreeNode treeNode = TreeNode.createTree(new Integer[]{1, 2, 5, 3, 4, null, 6});
        flatten2(treeNode);
        treeNode.out();
    }

    public static void flatten2(TreeNode root) {
        if (root == null) {
            return;
        }
        List<TreeNode> list = new ArrayList<>();
        // 前序遍历
        preOrderTraversal2(root, list);
        TreeNode pre = list.get(0);
        pre.left = null;
        for (int i = 1; i < list.size(); i++) {
            // 将当前节点作为前驱节点的右子树
            TreeNode treeNode = list.get(i);
            pre.right = treeNode;
            pre = pre.right;
            // 将当前节点的左子树置为空
            treeNode.left = null;
        }
    }

    public static void preOrderTraversal2(TreeNode root, List<TreeNode> list) {
        if (root != null) {
            list.add(root);
            preOrderTraversal2(root.left, list);
            preOrderTraversal2(root.right, list);
        }
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
