package com.hzm.leetcode.剑指Offer;

import com.hzm.leetcode.链表.ListNode;

/**
 * https://leetcode-cn.com/problems/he-bing-liang-ge-pai-xu-de-lian-biao-lcof/
 *
 * @author Hezeming
 * @version 1.0
 * @date 2021年01月09日
 */
public class 合并两个排序的链表 {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // 1 3 5 6
        // 2 4 6 7
        ListNode result = new ListNode(-1);
        ListNode cur = result;
        while (l1 != null && l2 != null) {
            // 小的节点后移一位
            // 大的节点不变
            if (l1.val < l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        cur.next = l1 == null ? l2 : l1;
        return result.next;
    }
}
