package com.hzm.leetcode.二叉树;

import sun.security.provider.MD2;

/**
 * https://leetcode-cn.com/problems/convert-sorted-array-to-binary-search-tree/
 *
 * @author Hezeming
 * @version 1.0
 * @date 2020年12月22日
 */
public class 将有序数组转换成二叉搜索树 {

    public static void main(String[] args) {
        TreeNode treeNode = sortedArrayToBST2(new int[]{-10, -3, 0, 5, 9});
        System.out.println(treeNode);
    }

    public static TreeNode sortedArrayToBST2(int[] nums) {
        if (nums == null) {
            return null;
        }
        return createNode2(nums, 0, nums.length - 1);
    }

    public static TreeNode createNode2(int[] nums, int left, int right) {
        // 相遇
        if (left > right) {
            return null;
        }
        int middle = (left + right) / 2;
        TreeNode treeNode = new TreeNode(nums[middle]);
        treeNode.left = createNode2(nums, left, middle - 1);
        treeNode.right = createNode2(nums, middle + 1, right);
        return treeNode;
    }


    public static TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null) {
            return null;
        }
        return createNode(nums, 0, nums.length - 1);
    }

    public static TreeNode createNode(int[] nums, int left, int right) {
        if (left > right) {
            // 说明上一轮剩余一个节点了，无需平衡
            return null;
        }
        // 选取中间位置左边的数字作为根节点
        int middle = (left + right + 1) / 2;

        TreeNode treeNode = new TreeNode(nums[middle]);

        treeNode.left = createNode(nums, left, middle - 1);
        treeNode.right = createNode(nums, middle + 1, right);
        return treeNode;
    }
}
