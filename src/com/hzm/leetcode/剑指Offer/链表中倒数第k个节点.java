package com.hzm.leetcode.剑指Offer;

import com.hzm.leetcode.链表.ListNode;

/**
 * https://leetcode-cn.com/problems/lian-biao-zhong-dao-shu-di-kge-jie-dian-lcof/
 *
 * @author Hezeming
 * @version 1.0
 * @date 2021年01月11日
 */
public class 链表中倒数第k个节点 {

    public ListNode getKthFromEnd(ListNode head, int k) {
        // 快慢指针
        ListNode slow = head;
        ListNode fast = head;
        // 定位快指针起始位置
        while (k-- > 0) {
            if (fast == null) {
                return null;
            }
            fast = fast.next;
        }
        // 快指针到达最后，慢指针位置就是倒数第k个节点
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}
