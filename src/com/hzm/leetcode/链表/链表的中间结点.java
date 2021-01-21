package com.hzm.leetcode.链表;

/**
 * https://leetcode-cn.com/problems/middle-of-the-linked-list/
 *
 * @author Hezeming
 * @version 1.0
 * @date 2021年01月15日
 */
public class 链表的中间结点 {

    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
