package com.hzm.leetcode.剑指Offer;

import com.hzm.leetcode.二叉树.TreeNode;
import com.hzm.leetcode.数组.ArrayUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Hezeming
 * @version 1.0
 * @date 2021年01月09日
 */
public class 重建二叉树 {

    public static void main(String[] args) {
        int[] arr1 = ArrayUtil.toArrayInt("[3,9,20,15,7]");
        int[] arr2 = ArrayUtil.toArrayInt("[9,3,15,20,7]");
        TreeNode treeNode = buildTree(arr1, arr2);
        System.out.println(treeNode);
    }

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0) {
            return null;
        }

        // 前序：中 左 右（定位根节点）
        // 中序：左 中 右（定位最左边节点）
        // 1.在中序遍历中找到根节点
        // 2.计算左子树和右子树的数量，在前序数组中可定位出左右子树的坐标

        // 中序遍历数组中<值，坐标>
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return buildRootTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, map);
    }

    public static TreeNode buildRootTree(int[] preorder, int preorderStart, int preorderEnd, int[] inorder, int inorderStart, int inorderEnd, Map<Integer, Integer> map) {
        if (preorderStart > preorderEnd) {
            return null;
        }
        // 拿到根节点的值
        int rootVal = preorder[preorderStart];
        TreeNode rootNode = new TreeNode(rootVal);
        if (preorderEnd == preorderStart) {
            return rootNode;
        } else {
            // 拿到中序遍历中根节点的坐标
            Integer rootIndex = map.get(rootVal);
            /*
             * 根据前序遍历构建树：
             * 1.前序中 中左右 节点的分割坐标
             * 2.将左右子树根据递归构建到root的左右
             */
            // 根据中序遍历中的根节点坐标计算出左右子树的节点数
            int leftLen = rootIndex - inorderStart;
            int rightLen = inorderEnd - rootIndex;
            // 前序：中 左 右（定位根节点）
            // 中序：左 中 右（定位最左边节点）
            rootNode.left = buildRootTree(
                    preorder, preorderStart + 1, preorderStart + leftLen
                    , inorder, inorderStart, rootIndex - 1
                    , map);
            rootNode.right = buildRootTree(
                    preorder, preorderEnd - rightLen + 1, preorderEnd
                    , inorder, rootIndex + 1, inorderEnd
                    , map);
            return rootNode;
        }
    }
}
