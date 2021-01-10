package com.hzm.leetcode.链表;

/**
 * https://leetcode-cn.com/problems/linked-list-cycle-ii/
 *
 * @author Hezeming
 * @version 1.0
 * @date 2021年01月10日
 */
public class 环形链表II {

    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        // 不是环形链表直接退出
        do {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                // 快慢指针相遇
                ListNode result = head;
                // 根据公式推导，快慢指针相遇之后，重新从头指针开始走
                // 新的指针和快指针的相遇点刚好是第一个节点
                while (result != fast) {
                    result = result.next;
                    fast = fast.next;
                }
                return result;
            }
        } while (fast != null && fast.next != null);
        return null;
    }
}
