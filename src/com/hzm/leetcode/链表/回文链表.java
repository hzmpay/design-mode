package com.hzm.leetcode.链表;

/**
 * https://leetcode-cn.com/problems/palindrome-linked-list/
 *
 * @author Hezeming
 * @version 1.0
 * @date 2021年01月25日
 */
public class 回文链表 {

    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }
        // TODO
        // 1.快慢指针找到中间元素
        // 2.迭代时顺便将前半部分链表进行翻转
        // 3.将反转后的前半部分链表和后半部分的链表进行比较
        // 4.恢复前半部分反转的链表

        // 1.快慢指针找到中间元素
        // 2.将后半部分链表进行翻转
        // 3.将前半部分链表和反转后的后半部分的链表进行比较
        // 4.恢复后半部分反转的链表

        ListNode centerNode = getCenter(head);
        ListNode reverseNode = reverse(centerNode);

        ListNode p1 = head;
        ListNode p2 = reverseNode;

        boolean result = true;
        while (result && p2 != null) {
            if (p1.val != p2.val) {
                result = false;
                break;
            }
            p1 = p1.next;
            p2 = p2.next;
        }
        centerNode.next = reverse(reverseNode);
        return result;
    }

    public ListNode getCenter(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public ListNode reverse(ListNode head) {
        ListNode pre = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

}
