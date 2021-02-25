package com.hzm.leetcode.链表;

/**
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list/
 *
 * @author Hezeming
 * @version 1.0
 * @date 2021年02月24日
 */
public class 删除排序链表中的重复元素 {

    public ListNode deleteDuplicates(ListNode head) {
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
