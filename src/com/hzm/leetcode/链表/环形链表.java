package com.hzm.leetcode.链表;

import java.awt.event.MouseWheelListener;

/**
 * https://leetcode-cn.com/problems/linked-list-cycle/
 *
 * @author Hezeming
 * @version 1.0
 * @date 2021年01月10日
 */
public class 环形链表 {

    public boolean hasCycle2(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head;
        do {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        } while (fast != null && fast.next != null);
        return false;
    }

    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        // 直到快慢指针相遇退出
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                // 快指针已经最后一个节点但是还没相遇，退出
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }
}
