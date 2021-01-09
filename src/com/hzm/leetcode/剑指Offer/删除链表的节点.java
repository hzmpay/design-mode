package com.hzm.leetcode.剑指Offer;

import com.hzm.leetcode.链表.ListNode;

/**
 * https://leetcode-cn.com/problems/shan-chu-lian-biao-de-jie-dian-lcof/
 *
 * @author Hezeming
 * @version 1.0
 * @date 2021年01月09日
 */
public class 删除链表的节点 {

    public ListNode deleteNode(ListNode head, int val) {
        // 定义当前节点
        ListNode cur = head;
        // 定义上一个节点
        ListNode pre = null;
        while (cur != null) {
            if (cur.val == val) {
                if (cur == head) {
                    // 刚好是头结点
                    head = head.next;
                } else {
                    // 是中间节点
                    pre.next = cur.next;
                }
                // 找到跳出循环
                break;
            }
            pre = cur;
            cur = cur.next;
        }
        return head;
    }
}
