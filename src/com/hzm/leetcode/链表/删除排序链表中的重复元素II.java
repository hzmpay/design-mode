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
        ListNode[] listNodes = ListNode.toListNode("[1,1,4,4,5,5,5,6]");
        ListNode listNode = deleteDuplicates(listNodes[0]);
        System.out.println(listNode);
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
//        // 是否出现重复情况
//        boolean isRe = false;
//        // 处理重复节点
//        while (head.next != null && head.val == head.next.val) {
//            isRe = true;
//            head = head.next;
//        }
//        // 退出循环时，head != head.next，head可能是出现过重复
//        if (head.next != null) {
//            head.next = deleteDuplicates(head.next);
//        }
//        // head出现过重复则返回下一个元素
//        return isRe ? head.next : head;
    }
}
