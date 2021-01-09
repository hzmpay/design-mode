package com.hzm.leetcode.剑指Offer;

import com.hzm.leetcode.二叉树.TreeNode;

/**
 * https://leetcode-cn.com/problems/er-cha-shu-de-jing-xiang-lcof/
 *
 * @author Hezeming
 * @version 1.0
 * @date 2021年01月09日
 */
public class 二叉树的镜像 {

    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode left = mirrorTree(root.right);
        TreeNode right = mirrorTree(root.left);
        root.left = left;
        root.right = right;
        return root;
    }
}
