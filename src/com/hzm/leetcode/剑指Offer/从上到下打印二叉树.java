package com.hzm.leetcode.剑指Offer;

import com.hzm.leetcode.二叉树.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Function;

/**
 * https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-lcof/
 *
 * @author Hezeming
 * @version 1.0
 * @date 2021年06月29日
 */
public class 从上到下打印二叉树 {

    public static void main(String[] args) {

    }

    public int[] levelOrder(TreeNode root) {
        if (root == null) {
            return new int[0];
        }
        Deque<TreeNode> stack = new LinkedList<>();
        stack.offer(root);
        List<Integer> list = new ArrayList<>();
        while (!stack.isEmpty()) {
            int size = stack.size();
            while (size-- > 0) {
                TreeNode cur = stack.pop();
                list.add(cur.val);
                if (cur.left != null) {
                    stack.offer(cur.left);
                }
                if (cur.right != null) {
                    stack.offer(cur.right);
                }
            }
        }
        return list.stream().mapToInt(e -> e).toArray();
    }
}
