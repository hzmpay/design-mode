package com.hzm.leetcode.剑指Offer;

import com.hzm.leetcode.二叉树.TreeNode;

/**
 * https://leetcode-cn.com/problems/er-cha-shu-de-zui-jin-gong-gong-zu-xian-lcof/
 *
 * @author Hezeming
 * @version 1.0
 * @date 2021年01月09日
 */
public class 二叉树的最近公共祖先 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 1.root刚好是其中一个说明，当前root就是最近公共祖先节点
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        // 2.右边找不到,两个都在左边
        if (right == null) {
            return left;
        }
        // 3.左边找不到,两个都在右边
        if (left == null) {
            return right;
        }
        // 4.一左一右
        return root;
    }

}
