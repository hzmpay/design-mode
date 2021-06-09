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
        ListNode listNode = mergeTwoLists3(listNodes[0], listNodes[1]);
        System.out.println(listNode);
    }

    /**
     * 迭代
     *
     * @param l1
     * @param l2
     * @return com.hzm.leetcode.链表.ListNode
     * @author Hezeming
     */
    public static ListNode mergeTwoLists4(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else {
            ListNode dummy = new ListNode();
            ListNode cur = dummy;
            while (l1 != null && l2 != null) {
                if (l1.val <= l2.val) {
                    cur.next = l1;
                    l1 = l1.next;
                } else {
                    cur.next = l2;
                    l2 = l2.next;
                }
                cur = cur.next;
            }
            // 直到其中一个为null退出
            cur.next = l1 == null ? l2 : l1;
            return dummy.next;
        }
    }

    /**
     * 递归
     *
     * @param l1
     * @param l2
     * @return com.hzm.leetcode.链表.ListNode
     * @author Hezeming
     */
    public static ListNode mergeTwoLists3(ListNode l1, ListNode l2) {
        if (l1 != null && l2 != null) {
            // 返回较小链表
            if (l1.val <= l2.val) {
                l1.next = mergeTwoLists1(l1.next, l2);
                return l1;
            } else {
                l2.next = mergeTwoLists1(l1, l2.next);
                return l2;
            }
        } else if (l1 != null) {
            return l1;
        } else {
            return l2;
        }
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
