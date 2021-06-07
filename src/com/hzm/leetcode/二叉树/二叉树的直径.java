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

    /**
     * 从1开始，因为空数组返回是0（结果-1）
     */
    static int maxValue = 1;

    public static void main(String[] args) {
        TreeNode.createTree(new Integer[]{4, -7, -3, null, null, -9, -3, 9, -7, -4, null, 6, null, -6, -6, null, null, 0, 6, 5, null, 9, null, null, -1, -4, null, null, null, -2}).out();
    }

    public static int diameterOfBinaryTree2(TreeNode root) {
        help(root);
        return maxValue - 1;
    }

    public static int help(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int l = help(root.left);
        int r = help(root.right);
        // 最大长度 = 左节点的最大树高 + 右节点的最大树高 + 1
        // 每轮计算当前节点的最长路线
        maxValue = Math.max(l + r + 1, maxValue);
        return 1 + Math.max(l, r);
    }

    public int diameterOfBinaryTree(TreeNode root) {
        getMaxValue(root);
        // 最终长度 = 节点数 - 1
        return maxValue - 1;
    }

    public int getMaxValue(TreeNode root) {
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
