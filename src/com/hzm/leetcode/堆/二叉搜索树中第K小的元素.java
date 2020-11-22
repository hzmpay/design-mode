package com.hzm.leetcode.堆;

import com.hzm.leetcode.二叉树.TreeNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/kth-smallest-element-in-a-bst/solution/er-cha-sou-suo-shu-zhong-di-kxiao-de-yuan-su-by-le/
 *
 * @author Hezeming
 * @version 1.0
 * @date 2020年11月22日
 */
public class 二叉搜索树中第K小的元素 {

    public static void main(String[] args) {

    }

    public static int kthSmallest(TreeNode root, int k) {
        // 用栈记录节点
        Deque<TreeNode> stack = new LinkedList<>();
        int i = 0;
        while (root != null || !stack.isEmpty()) {
            // 一直往左节点遍历，直到左节点为空退出
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            // 左节点为空，root回到上一个节点（栈顶）
            TreeNode pop = stack.pop();
            // 当前节点是最小的
            if (++i == k) {
            	return pop.val;
            }
            // 外部判断配合开始遍历右节点
            root = pop.right;
        }
        return -1;
    }

}
