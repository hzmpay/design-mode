package com.hzm.leetcode.二叉树;

import java.util.ArrayList;
import java.util.Collections;
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

    public List<List<Integer>> levelOrder2(TreeNode root) {
        if (root == null) {
            return Collections.EMPTY_LIST;
        }
        /*
         * 1.定义curList存储每层的list
         * 2.迭代遍历preList的左右子树
         * 3.每遍历完一层存一次allList
         */
        List<List<Integer>> allList = new ArrayList<>();
        List<TreeNode> curList = new ArrayList<>(1);
        curList.add(root);
        while (!curList.isEmpty()) {
            List<Integer> curValList = new ArrayList<>(curList.size());
            List<TreeNode> nextNodeList = new ArrayList<>(curList.size() * 2);
            for (TreeNode treeNode : curList) {
                // 存储本轮值
                curValList.add(treeNode.val);
                // 存储本轮的左右节点，即下一轮节点
                if (treeNode.left != null) {
                    nextNodeList.add(treeNode.left);
                }
                if (treeNode.right != null) {
                    nextNodeList.add(treeNode.right);
                }
            }
            // 存储本轮总值
            allList.add(curValList);
            // 存储下一轮节点
            curList = nextNodeList;
        }
        return allList;
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
