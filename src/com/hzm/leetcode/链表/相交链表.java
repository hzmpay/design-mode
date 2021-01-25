package com.hzm.leetcode.链表;

import java.util.Deque;
import java.util.LinkedList;

/**
 * https://leetcode-cn.com/problems/intersection-of-two-linked-lists/
 *
 * @author Hezeming
 * @version 1.0
 * @date 2021年01月25日
 */
public class 相交链表 {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        // (a, b, c, d),(c, d)
        // a + b + c + d + null + c + d
        // c + d + null + a + b + c + d
        ListNode p1 = headA;
        ListNode p2 = headB;
        while (p1 != p2) {
            p1 = p1 == null ? headB : p1.next;
            p2 = p2 == null ? headA : p2.next;
        }
        return p1;
    }
}
