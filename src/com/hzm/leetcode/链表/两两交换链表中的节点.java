package com.hzm.leetcode.链表;

/**
 * https://leetcode-cn.com/problems/swap-nodes-in-pairs/
 *
 * @author Hezeming
 * @version 1.0
 * @date 2021年01月08日
 */
public class 两两交换链表中的节点 {

    public static void main(String[] args) {
        ListNode listNode = ListNode.toNode("[1,2,3,4]");
        System.out.println(swapPairs4(listNode));
    }

    public static ListNode swapPairs4(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = head.next;
        head.next = swapPairs4(newHead.next);
        newHead.next = head;
        return newHead;
    }

    public static ListNode swapPairs3(ListNode head) {
        ListNode vHead = new ListNode(-1, head);
        ListNode temp = vHead;
        while (temp.next != null && temp.next.next != null) {
            ListNode node1 = temp.next;
            ListNode node2 = temp.next.next;
            temp.next = node2;
            node1.next = node2.next;
            node2.next = node1;
            temp = node1;
        }
        return vHead.next;
    }




    public static ListNode swapPairs2(ListNode head) {
        // 1 2 3 4 5 6
        /*
         * 1.1-2交换，此时head由1变成了2，所以返回之前2的地址
         * 1-2-3-4-5-6 -> 2-1-3-4-5-6
         * 2.递归传入1的下一个节点，也就是3
         */
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = head.next;
        head.next = swapPairs2(newHead.next);
        newHead.next = head;
        return newHead;
    }

    public static ListNode swapPairs1(ListNode head) {
        // 1 2 3 4
        // 2 1 4 3
        /*
         * 1.迭代，碰到偶数位开始交换当前节点和上一个节点
         * 2.每次保存上一个节点和上上个节点
         * 3.迭代直到下一个节点为null退出
         */

        // 是否是偶数位
        boolean isOu = false;
        // 上上个节点
        ListNode prePre = null;
        // 上一个节点
        ListNode pre = null;
        // 当前节点
        ListNode cur = head;
        boolean isFirstChange = true;
        while (cur != null) {
            if (isOu) {
                swap(cur, pre, prePre);
                if (isFirstChange) {
                    head = cur;
                    isFirstChange = false;
                }
                ListNode temp = cur;
                cur = pre;
                pre = temp;
            }
            prePre = pre;
            pre = cur;
            cur = cur.next;
            isOu = !isOu;
        }
        return head;
    }

    /**
     * 节点交换
     *
     * @param cur
     * @param pre
     * @param prePre
     * @return com.hzm.leetcode.链表.ListNode
     * @author Hezeming
     */
    public static void swap(ListNode cur, ListNode pre, ListNode prePre) {
        pre.next = cur.next;
        cur.next = pre;
        if (prePre != null) {
            prePre.next = cur;
        }
    }
}
