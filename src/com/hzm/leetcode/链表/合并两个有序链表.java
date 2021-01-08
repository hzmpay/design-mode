package com.hzm.leetcode.链表;

/**
 * https://leetcode-cn.com/problems/merge-two-sorted-lists/solution/he-bing-liang-ge-you-xu-lian-biao-by-leetcode-solu/
 *
 * @author Hezeming
 * @version 1.0
 * @date 2021年01月08日
 */
public class 合并两个有序链表 {

    public static void main(String[] args) {
        ListNode[] listNodes = ListNode.toListNode("[[1,2,4],[1,3,4]]");
        ListNode listNode = mergeTwoLists2(listNodes[0], listNodes[1]);
        System.out.println(listNode);
    }

    public static ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        // 1 3 5
        // 2 4 6
        ListNode preHead = new ListNode(-1);
        ListNode pre = preHead;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                pre.next = l1;
                l1 = l1.next;
            } else {
                pre.next = l2;
                l2 = l2.next;
            }
            pre = pre.next;
        }
        // 合并完成之后最多还有一个未合并
        pre.next = l1 == null ? l2 : l1;
        return preHead.next;
    }

    public static ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
        // 1 3 5
        // 2 4 6
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else if (l1.val < l2.val) {
            l1.next = mergeTwoLists1(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists1(l1, l2.next);
            return l2;
        }
    }
}
