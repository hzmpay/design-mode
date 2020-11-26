package com.hzm.leetcode.二叉树;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/binary-tree-level-order-traversal/
 *
 * @author Hezeming
 * @version 1.0
 * @date 2020年11月25日
 */
public class 二叉树的层次遍历 {

    public static void main(String[] args) {

    }
    /** 定义每层遍历要用到节点list */
    static List<TreeNode> list = new ArrayList<>();

    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> allList = new ArrayList<>();
        if (root != null) {
            list.add(root);
            // 直到没有节点的那一层跳出循环
            while (!list.isEmpty()) {
                List<Integer> valueList = help();
                allList.add(valueList);
            }
        }
        return allList;
    }

    /**
     * 根据上一层拿到的节点list获取值集合
     *
     * @param
     * @return java.util.List<java.lang.Integer>
     * @author Hezeming
     */
    public static List<Integer> help() {
        List<Integer> result = new ArrayList<>();
        List<TreeNode> newList = new ArrayList<>();
        if (!list.isEmpty()) {
            for (TreeNode treeNode : list) {
                result.add(treeNode.val);
                // 加入到下一次遍历
                if (treeNode.left != null) {
                    newList.add(treeNode.left);
                }
                // 加入到下一次遍历
                if (treeNode.right != null) {
                    newList.add(treeNode.right);
                }
            }
        }
        list = newList;
        return result;
    }

}
