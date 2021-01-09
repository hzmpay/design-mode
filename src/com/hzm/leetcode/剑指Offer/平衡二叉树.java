package com.hzm.leetcode.剑指Offer;

import com.hzm.leetcode.二叉树.TreeNode;

/**
 * https://leetcode-cn.com/problems/ping-heng-er-cha-shu-lcof/
 *
 * @author Hezeming
 * @version 1.0
 * @date 2021年01月09日
 */
public class 平衡二叉树 {

    public boolean isBalanced(TreeNode root) {
        return getHigh(root) != -1;
    }

    public int getHigh(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // 左子树平衡
        int leftHigh = getHigh(root.left);
        if (leftHigh == -1) {
            return -1;
        }
        // 右子树平衡
        int rightHigh = getHigh(root.right);
        if (rightHigh == -1) {
            return -1;
        }
        // 左右高度之差大于1，不平衡
        if (Math.abs(leftHigh - rightHigh) > 1) {
            return -1;
        }
        return Math.max(leftHigh, rightHigh) + 1;
    }
}
