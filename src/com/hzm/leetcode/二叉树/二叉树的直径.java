package com.hzm.leetcode.二叉树;

import sun.misc.LRUCache;

/**
 * https://leetcode-cn.com/problems/diameter-of-binary-tree/
 *
 * @author Hezeming
 * @version 1.0
 * @date 2020年11月23日
 */
public class 二叉树的直径 {

    static int maxValue = 0;

    public static void main(String[] args) {

    }

    public static int diameterOfBinaryTree(TreeNode root) {
        getMaxValue(root);
        return maxValue - 1;
    }

    public static int getMaxValue(TreeNode root) {
        if (root == null) {
            // 空节点，返回0
            return 0;
        }
        // 计算左子树的最大深度
        int left = getMaxValue(root.left);
        // 计算右子树的最大深度
        int right = getMaxValue(root.right);
        // 每次比较并记录当前节点的任意两节点最长长度
        int curMaxValue = left + right + 1;
        maxValue = Math.max(maxValue, curMaxValue);
        return Math.max(left, right) + 1;
    }
}
