package com.hzm.leetcode.链表;

/**
 * https://leetcode-cn.com/problems/reverse-linked-list/solution/dong-hua-yan-shi-206-fan-zhuan-lian-biao-by-user74/
 *
 * @author Hezeming
 * @version 1.0
 * @date 2020年09月23日
 */
public class 反转链表 {

    public static void main(String[] args) {

        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        out(listNode1);

        System.out.println("===================");
        ListNode listNode = reverseList2(listNode1);

        out(listNode);
    }

    public static void out(ListNode head) {
        if (head != null) {
            System.out.println(head.val);
            out(head.next);
        }
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

