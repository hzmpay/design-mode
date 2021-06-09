package com.hzm.leetcode.链表;

import java.awt.event.MouseWheelListener;

/**
 * https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/
 *
 * @author Hezeming
 * @version 1.0
 * @date 2021年01月05日
 */
public class 删除链表的倒数第N个节点 {

    public static void main(String[] args) {
        removeNthFromEnd2(ListNode.toNode("[1,2,3,4,5]"), 2).out();
        removeNthFromEnd2(ListNode.toNode("[1,2]"), 1).out();
        System.out.println(removeNthFromEnd2(ListNode.toNode("[1]"), 1));
    }

    public static ListNode removeNthFromEnd2(ListNode head, int n) {
        // 输入：head = [1,2,3,4,5], n = 2
        // 输出：[1,2,3,5]
        ListNode dummy = new ListNode(-1, head);
        ListNode slow = dummy;
        ListNode quick = dummy.next;
        while (quick != null && n-- > 0) {
            quick = quick.next;
        }
        // 说明不到n个数
        if (n > 0) {
            return dummy.next;
        }
        while (quick != null) {
            slow = slow.next;
            quick = quick.next;
        }
        // 此时退出quick为null，所以slow在倒数第n+1位，刚好可以处理第n位
        slow.next = slow.next.next;
        return dummy.next;
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        // 快慢指针
//        1  1 + n = 3
        ListNode slowNode = head;
        ListNode quickNode = head;
        while (n > 1) {
            quickNode = quickNode.next;
            n--;
        }
        if (quickNode == null) {
            // 不足n个节点
            return null;
        }
        quickNode = quickNode.next;
        if (quickNode == null) {
            // 刚好是n个节点
            return slowNode.next;
        }

        quickNode = quickNode.next;
        // 开始遍历
        while (quickNode != null) {
            quickNode = quickNode.next;
            slowNode = slowNode.next;
        }

        // 此时slowNode是倒数第n个节点的前一个节点
        slowNode.next = slowNode.next.next;
        return head;
    }
}
