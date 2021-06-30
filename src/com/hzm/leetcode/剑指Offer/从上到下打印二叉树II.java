package com.hzm.leetcode.剑指Offer;

import com.hzm.leetcode.二叉树.TreeNode;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-ii-lcof/
 *
 * @author Hezeming
 * @version 1.0
 * @date 2021年06月30日
 */
public class 从上到下打印二叉树II {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> stack = new LinkedList<>();
        stack.offer(root);
        while (!stack.isEmpty()) {
            int size = stack.size();
            List<Integer> curList = new ArrayList<Integer>();
            while (size-- > 0) {
                TreeNode cur = stack.poll();
                curList.add(cur.val);
                if (cur.left != null) {
                    stack.offer(cur.left);
                }
                if (cur.right != null) {
                    stack.offer(cur.right);
                }
            }
            result.add(curList);
        }
        return result;
    }
}
