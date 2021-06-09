package com.hzm.leetcode.链表;

import java.util.concurrent.CyclicBarrier;

/**
 * https://leetcode-cn.com/problems/reverse-linked-list/solution/dong-hua-yan-shi-206-fan-zhuan-lian-biao-by-user74/
 *
 * @author Hezeming
 * @version 1.0
 * @date 2020年09月23日
 */
public class 反转链表 {

    public static void main(String[] args) {
        reverseList4(ListNode.toNode("[1,2,3,4,5]")).out();
    }

    /**
     * 递归方式
     *
     * @param head
     * @return com.hzm.leetcode.ListNode
     * @author Hezeming
     */
    public static ListNode reverseList4(ListNode head) {
        // 1 2 3 4 5
        if (head == null || head.next == null) {
            return head;
        }
        // 1->2->3->4->5
        // 最后一层head是4，返回的cur = head.next = 5
        ListNode cur = reverseList4(head.next);
        // 5->4
        head.next.next = head;
        // 切断4->5
        head.next = null;
        return cur;
    }

    /**
     * 迭代方式
     *
     * @param head
     * @return com.hzm.leetcode.ListNode
     * @author Hezeming
     */
    public static ListNode reverseList3(ListNode head) {
        // 1 2 3 4 5
        ListNode cur = head;
        ListNode pre = null;
        while (cur != null) {
            // 取出当前节点的下一个节点
            ListNode next = cur.next;
            // 将当前节点的下一个节点指向pre
            cur.next = pre;
            // 重置cur，pre
            pre = cur;
            cur = next;
        }
        return pre;
    }

    /**
     * 迭代方式
     *
     * @param head
     * @return com.hzm.leetcode.ListNode
     * @author Hezeming
     */
    public static ListNode reverseList1(ListNode head) {
        // 当前节点
        ListNode curr = head;
        // 当前节点的前驱节点
        ListNode prev = null;

        do {
            // 拿到当前节点的下一个节点
            ListNode nextTemp = curr.next;
            // 把当前节点前驱节点置为下一个节点
            curr.next = prev;

            // 把当前节点置为下一个节点的前驱节点
            prev = curr;
            // 把原来当前节点的下一节点置为当前节点
            curr = nextTemp;
        } while (curr != null);

        return prev;
    }


    /**
     * 递归方式
     *
     * @param head
     * @return com.hzm.leetcode.ListNode
     * @author Hezeming
     */
    public static ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null) {
            // 递归到最后一个元素终止
            return head;
        }
        // 这里返回最后一个
        ListNode cur = reverseList2(head.next);
        // 如果链表是 1->2->3->4->5，那么此时的cur就是5
        // 而head是4，head的下一个是5，下下一个是空
        // 所以head.next.next 就是5->4
        head.next.next = head;
        head.next = null;
        return cur;
    }
}

