package com.hzm.leetcode.二叉树;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/solution/cong-qian-xu-yu-zhong-xu-bian-li-xu-lie-gou-zao-9/
 *
 * @author Hezeming
 * @version 1.0
 * @date 2020年11月25日
 */
public class 从前序与中序遍历序列构造二叉树 {

    public static void main(String[] args) {
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9,3,15,20,7};
        TreeNode treeNode = buildTree(preorder, inorder);
        treeNode.out();
    }

    static Map<Integer, Integer> map;

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        // 前：中  左  右
        // 中：左  中  右
        map = new HashMap<>(inorder.length * 4 / 3 + 1);
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return buildTree(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }

    public static TreeNode buildTree(int[] preorder, int[] inorder, int preOrderLeft, int preOrderRight, int inOrderLeft, int inOrderRight) {
        // 退出条件
        if (preOrderLeft > preOrderRight) {
            return null;
        }
        // 前：中  左  右
        // 中：左  中  右
        // 前序遍历第一个为root
        int preOrderRoot = preOrderLeft;
        int rootVal = preorder[preOrderRoot];
        TreeNode root = new TreeNode(rootVal);
        // 中序遍历中根节点坐标
        Integer inOrderRootIndex = map.get(rootVal);
        // 构建左子树
        int preOrderLeftLen = inOrderRootIndex - inOrderLeft;
        root.left = buildTree(preorder, inorder, preOrderRoot + 1, preOrderRoot + preOrderLeftLen, inOrderLeft, inOrderRootIndex - 1);
        // 构建右子树
        root.right = buildTree(preorder, inorder, preOrderRoot + preOrderLeftLen + 1, preOrderRight, inOrderRootIndex + 1, inOrderRight);
        return root;
    }



    public static TreeNode buildTree1(int[] preorder, int[] inorder) {
        // 前序遍历的第一个一定是主节点
        int rootVal = preorder[0];
        TreeNode root = new TreeNode(rootVal);

        int rootIdx = 0;
        for (int i = 0; i < inorder.length; i++) {
            if (rootVal == inorder[i]) {
                rootIdx = i;
                break;
            }
        }



        while (true) {

        }
    }
}
