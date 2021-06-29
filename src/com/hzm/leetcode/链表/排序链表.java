package com.hzm.leetcode.链表;


/**
 * https://leetcode-cn.com/problems/sort-list/
 *
 * @author Hezeming
 * @version 1.0
 * @date 2021年01月25日
 */
public class 排序链表 {

    public static void main(String[] args) {
//        ListNode listNode = new 排序链表().sortList2(ListNode.toNode("[2,1,6,4,5,3]"));
        ListNode listNode = new 排序链表().sortList2(ListNode.toNode("[2,1,6]"));
        listNode.out();
//        new 排序链表().merge2(ListNode.toNode("[1,3,4]"), ListNode.toNode("[1,3,4]")).out();
//        ListNode node = ListNode.toNode("[2,1,6,7]");
//        new 排序链表().center(node).out();
    }

    public ListNode sortList2(ListNode head) {
        // 分成两个链表进行合并
        if (head == null || head.next == null) {
            return head;
        }
        ListNode middle = center(head);
        ListNode next = middle.next;
        middle.next = null;
        ListNode l = sortList2(head);
        ListNode r = sortList2(next);
        // 迭代再分，直到最后剩一个或者两个再比较，归并
        return merge2(l, r);
    }

    public ListNode merge2(ListNode node1, ListNode node2) {
        if (node1 == null) {
            return node2;
        } else if (node2 == null) {
            return node1;
        } else {
            if (node1.val <= node2.val) {
                node1.next = merge2(node1.next, node2);
                return node1;
            } else {
                node2.next = merge2(node1, node2.next);
                return node2;
            }
        }
    }

    public ListNode center(ListNode head) {
        ListNode slow = head;
        // 这里的.next主要是在双数情况下，slow节点是两个中间节点中左边那个
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public ListNode sortList(ListNode head) {
        return sortList(head, null);
    }

    public ListNode sortList(ListNode head, ListNode tail) {
        if (head == null) {
            return null;
        }
        if (head.next == tail) {
            head.next = null;
            return head;
        }

        ListNode slow = head;
        ListNode fast = head;
        while (fast != tail && fast.next != tail) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode mid = slow;
        ListNode listNode1 = sortList(head, mid);
        ListNode listNode2 = sortList(mid, tail);
        return merge(listNode1, listNode2);
    }

    public ListNode merge(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else if (l1.val < l2.val) {
            l1.next = merge(l1.next, l2);
            return l1;
        } else {
            l2.next = merge(l2.next, l1);
            return l2;
        }
    }
}
