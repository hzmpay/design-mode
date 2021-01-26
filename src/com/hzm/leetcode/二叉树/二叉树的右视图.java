package com.hzm.leetcode.二叉树;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/binary-tree-right-side-view/
 *
 * @author Hezeming
 * @version 1.0
 * @date 2021年01月25日
 */
public class 二叉树的右视图 {

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        List<TreeNode> list = new ArrayList<>();
        list.add(root);
        while (!list.isEmpty()) {
            List<TreeNode> newList = new ArrayList<>();
            for (TreeNode treeNode : list) {
                if (treeNode.left != null) {
                    newList.add(treeNode.left);
                }
                if (treeNode.right != null) {
                    newList.add(treeNode.right);
                }
            }
            result.add(list.get(list.size() - 1).val);
            list = newList;
        }
        return result;
    }
}
