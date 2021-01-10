package com.hzm.leetcode.二叉树;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/path-sum-ii/
 *
 * @author Hezeming
 * @version 1.0
 * @date 2021年01月11日
 */
public class 路径总和II {

    private final List<List<Integer>> allList = new ArrayList<>();
    private final Deque<Integer> childList = new LinkedList<>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        dfs(root, sum);
        return allList;
    }

    public void dfs(TreeNode root, int sum) {
        if (root == null) {
            return;
        }
        // 先入栈
        childList.offerLast(root.val);
        // 两边同时等于null再判断sum是否符合，符合则入list
        if (root.left == null && root.right == null && root.val == sum) {
            // 入结果集
            allList.add(new ArrayList<>(childList));
        }
        sum = sum - root.val;
        dfs(root.left, sum);
        dfs(root.right, sum);
        // 子节点用完之后出栈
        childList.pollLast();
    }
}
