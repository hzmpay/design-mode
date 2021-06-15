package com.hzm.leetcode.链表;


/**
 * https://leetcode-cn.com/problems/palindrome-linked-list/
 *
 * @author Hezeming
 * @version 1.0
 * @date 2021年01月25日
 */
public class 回文链表 {

    public static void main(String[] args) throws Exception {
//        ListNode listNode = ListNode.toNode("[1,2,3,2,1]");
        ListNode listNode = ListNode.toNode("[1,2]");
//        reverse2(listNode).out();
        System.out.println(isPalindrome1(listNode));
    }

    public static boolean isPalindrome2(ListNode head) {
        // 找到中间节点（偶数位中间前置节点）
        ListNode slow = head;
        ListNode quick = head;
        // 边遍历边翻转前半部分
        while (quick != null && quick.next != null) {
            slow = slow.next;
            quick = quick.next.next;
        }
        //
        ListNode next = slow.next;
        // 开始翻转
        return false;
    }

    public static boolean isPalindrome1(ListNode head) {
        // 找到中间节点（偶数位中间前置节点）
        ListNode slow = head;
        ListNode quick = head;
        // 边遍历边翻转前半部分
        while (quick != null && quick.next != null) {
            slow = slow.next;
            quick = quick.next.next;
        }
        // 开始翻转
        ListNode newNode = reverse2(slow);
        // 比较前半部分和后半部分是否相等
        ListNode node1 = head;
        ListNode node2 = newNode;
        while (node2 != null) {
            if (node1.val != node2.val) {
                return false;
            }
            node1 = node1.next;
            node2 = node2.next;
        }
        // 恢复链表
        slow.next = reverse2(newNode).next;
        System.out.println(head);
        return true;
    }

    public static ListNode reverse2(ListNode node) {
        ListNode pre = null;
        while (node != null) {
            ListNode next = node.next;
            node.next = pre;
            pre = node;
            node = next;
        }
        return pre;
    }


    public static boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }
        // TODO
        // 1.快慢指针找到中间元素
        // 2.迭代时顺便将前半部分链表进行翻转
        // 3.将反转后的前半部分链表和后半部分的链表进行比较
        // 4.恢复前半部分反转的链表

        // 1.快慢指针找到中间元素
        // 2.将后半部分链表进行翻转
        // 3.将前半部分链表和反转后的后半部分的链表进行比较
        // 4.恢复后半部分反转的链表

        ListNode centerNode = getCenter(head);
        ListNode reverseNode = reverse(centerNode);

        ListNode p1 = head;
        ListNode p2 = reverseNode;

        boolean result = true;
        while (result && p2 != null) {
            if (p1.val != p2.val) {
                result = false;
                break;
            }
            p1 = p1.next;
            p2 = p2.next;
        }
        centerNode.next = reverse(reverseNode);
        return result;
    }

    public static ListNode getCenter(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static ListNode reverse(ListNode head) {
        ListNode pre = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

}
