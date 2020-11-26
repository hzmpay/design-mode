package com.hzm.leetcode.二叉树;

/**
 * https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/solution/cong-qian-xu-yu-zhong-xu-bian-li-xu-lie-gou-zao-9/
 *
 * @author Hezeming
 * @version 1.0
 * @date 2020年11月25日
 */
public class 从前序与中序遍历序列构造二叉树 {

    public static void main(String[] args) {

    }

    public static TreeNode buildTree(int[] preorder, int[] inorder) {

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
