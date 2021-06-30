package com.hzm.leetcode.剑指Offer;

import com.hzm.leetcode.二叉树.TreeNode;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-iii-lcof/
 *
 * @author Hezeming
 * @version 1.0
 * @date 2021年06月30日
 */
public class 从上到下打印二叉树III {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean isLeft = false;
        while (!queue.isEmpty()) {
            int size = queue.size();
            LinkedList<Integer> curList = new LinkedList<>();
            while (size-- > 0) {
                TreeNode cur = queue.poll();
                if (isLeft) {
                    curList.addFirst(cur.val);
                } else {
                    curList.addLast(cur.val);
                }
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }
            isLeft = !isLeft;
            result.add(curList);
        }
        return result;
    }
}
