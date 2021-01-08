package com.hzm.leetcode.链表;

/**
 * https://leetcode-cn.com/problems/merge-k-sorted-lists/
 *
 * @author Hezeming
 * @version 1.0
 * @date 2021年01月08日
 */
public class 合并K个升序链表 {

    public static void main(String[] args) {
        ListNode[] listNodes = ListNode.toListNode("[[1,4,5],[1,3,4],[2,6]]");
        ListNode listNode = mergeKLists3(listNodes);
//        ListNode listNode = mergeTAwoListNode(listNodes[0], listNodes[1]);
        System.out.println(listNode);
    }

    /**
     * 迭代合并
     *
     * @param lists
     * @param l
     * @param r
     * @return com.hzm.leetcode.链表.ListNode
     * @author Hezeming
     */
    public static ListNode merge(ListNode[] lists, int l, int r) {
        if (l > r) {
            return null;
        }
        if (l == r) {
            // 指针相遇
            return lists[l];
        }
        final int middle = (l + r) / 2;
        return mergeTAwoListNode(merge(lists, l, middle), merge(lists, middle + 1, r));
    }

    public static ListNode mergeKLists3(ListNode[] lists) {
        return merge(lists, 0, lists.length - 1);
    }

    public static ListNode mergeKLists2(ListNode[] lists) {
        ListNode preNode = lists[0];
        for (int i = 1; i < lists.length; i++) {
            preNode = mergeTAwoListNode(preNode, lists[i]);
        }
        return preNode;
    }

    /**
     * TODO 有问题
     *
     * @param lists
     * @return com.hzm.leetcode.链表.ListNode
     * @author Hezeming
     */
    public static ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        if (lists.length == 1) {
            return lists[0];
        }
        // 是否是偶数位
        final boolean isOu = lists.length % 2 == 0;
        int length = isOu ? lists.length : lists.length - 1;
        // 分治算法：直到两两合并成一个为止
        // 可能有额外的一个，记录
        ListNode lastListNode = null;
        while (true) {
            int j = 0;
            for (int i = 0; i < length; i += 2, j++) {
                if (length % 2 == 1 && i == length - 1) {
                    // 第一个合并之后是奇数位，最后一位留到最后处理
                    lastListNode = lists[i];
                    j--;
                } else {
                    // 每次两两合并赋值到原来的数组上，比如：0,1 -》0，2,3 -》1，4,5 -》2
                    lists[j] = mergeTAwoListNode(lists[i], lists[i + 1]);
                }
            }
            if (j == 1) {
                break;
            }
            length = j;
        }
        if (lastListNode != null) {
            lists[0] = mergeTAwoListNode(lists[0], lastListNode);
        }
        if (isOu) {
            // 偶数刚好合并完成，返回第一个元素
            return lists[0];
        } else {
            // 最后一位不为null说明是奇数位
            return mergeTAwoListNode(lists[0], lists[lists.length - 1]);
        }
    }

    /**
     * 两个合并
     *
     * @param node1
     * @param node2
     * @return ListNode
     * @author Hezeming
     */
    public static ListNode mergeTAwoListNode(ListNode node1, ListNode node2) {
        ListNode preHeadNode = new ListNode(-1);
        ListNode preNode = preHeadNode;
        while (node1 != null && node2 != null) {
            if (node1.val < node2.val) {
                preNode.next = node1;
                node1 = node1.next;
            } else {
                preNode.next = node2;
                node2 = node2.next;
            }
            preNode = preNode.next;
        }
        // 此时存在一个未合并到preNode
        preNode.next = node1 == null ? node2 : node1;
        return preHeadNode.next;
    }
}
