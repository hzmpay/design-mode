package com.hzm.leetcode.链表;

/**
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list-ii/
 *
 * @author Hezeming
 * @version 1.0
 * @date 2021年02月24日
 */
public class 删除排序链表中的重复元素II {

    public static void main(String[] args) {
//        ListNode[] listNodes = ListNode.toListNode("[1,2,3,3,4,4,5]");
        ListNode[] listNodes = ListNode.toListNode("[1,1]");
        ListNode listNode = deleteDuplicates2(listNodes[0]);
        System.out.println(listNode);
    }

    public static ListNode deleteDuplicates2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummyNode = new ListNode(-1, head);
        ListNode cur = dummyNode;
        while (cur.next != null && cur.next.next != null) {
            if (cur.next.val == cur.next.next.val) {
                // 记录重复值
                int val = cur.next.val;
                // 迭代比较重复值
                while (cur.next != null && cur.next.val == val) {
                    // 赋值下一个cur.next.next用作判断
                    cur.next = cur.next.next;
                }
            } else {
                cur = cur.next;
            }
        }
        return dummyNode.next;
    }

    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        // 相等需做去重处理
        if (head.val == head.next.val) {
            while (head != null && head.next != null && head.val == head.next.val) {
                // 去重处理
                head = head.next;
            }
            // 处理完之后此时的head是重复元素，所以递归用下一个节点
            return deleteDuplicates(head.next);
        } else {
            // 不相等则递归拿下一个节点
            head.next = deleteDuplicates(head.next);
            return head;
        }
    }
}
