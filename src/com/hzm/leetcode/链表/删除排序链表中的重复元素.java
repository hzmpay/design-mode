package com.hzm.leetcode.链表;

/**
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list/
 *
 * @author Hezeming
 * @version 1.0
 * @date 2021年02月24日
 */
public class 删除排序链表中的重复元素 {

    public static void main(String[] args) {

    }

    public static ListNode deleteDuplicates3(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode cur = head;
        while (cur.next != null) {
            // 当前元素和下一个元素重复
            if (cur.val == cur.next.val) {
                // 删除下一个元素，不改变当前元素，因为下一个元素改变了，所有需要重新比较
                cur.next = cur.next.next;
            } else {
                // 不重复则调到下一个元素
                cur = cur.next;
            }
        }
        return head;
    }

    public static ListNode deleteDuplicates2(ListNode head) {
        ListNode vHead = new ListNode(-1, head);
        ListNode temp = vHead;
        while (temp.next != null && temp.next.next != null) {
            ListNode node1 = temp.next;
            ListNode node2 = temp.next.next;
            // 重复元素
            if (node1.val == node2.val) {
                // 删除node2
                node1.next = node2.next;
            } else {
                // 没有重复元素则调到下一个temp
                temp = temp.next;
            }
        }
        return vHead.next;
    }

    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        // 定义双指针
        ListNode pre = head;
        ListNode cur = head.next;
        while (cur != null) {
            // 当前元素与前一个节点相等，将当前节点删除
            if (pre.val == cur.val) {
                pre.next = cur.next;
                cur = cur.next;
            } else {
                pre = cur;
                cur = cur.next;
            }
        }
        return head;
    }
}
