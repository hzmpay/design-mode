package com.hzm.leetcode.链表;

/**
 * https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/
 *
 * @author Hezeming
 * @version 1.0
 * @date 2021年01月05日
 */
public class 删除链表的倒数第N个节点 {

    public static void main(String[] args) {

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
