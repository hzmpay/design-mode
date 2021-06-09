package com.hzm.leetcode.链表;


/**
 * https://leetcode-cn.com/problems/add-two-numbers/
 *
 * @author Hezeming
 * @version 1.0
 * @date 2021年03月04日
 */
public class 两数相加 {

    public static void main(String[] args) {
        ListNode l1 = ListNode.toNode("[9,9,9,9,9,9,9]");
        ListNode l2 = ListNode.toNode("[9,9,9,9]");
//        ListNode listNode = addTwoNumbers(l2, l1);
        ListNode listNode = addTwoNumbers2(l2, l1);
//        ListNode listNode = addTwoNumbers3(l2, l1);
        System.out.println(listNode.toString());
    }

    public static ListNode addTwoNumbers3(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        } else if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else {
            // 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
            //输出：7 -> 0 -> 8
            //原因：342 + 465 = 807
            boolean isAdd = false;
            ListNode head = l1;
            ListNode cur = l1;
            while (l1 != null && l2 != null) {
                l1.val = l1.val + l2.val;
                if (isAdd) {
                    l1.val++;
                }
                isAdd = l1.val >= 10;
                if (isAdd) {
                    l1.val = l1.val - 10;
                }
                cur = l1;
                l1 = l1.next;
                l2 = l2.next;
            }
            cur.next = l1 == null ? l2 : l1;
            ListNode pre = cur;
            cur = cur.next;
            // 根据进位可能出现新的节点
            while (isAdd) {
                if (cur == null) {
                    pre.next = new ListNode(1);
                    break;
                }
                cur.val++;
                isAdd = cur.val >= 10;
                if (isAdd) {
                    cur.val = cur.val - 10;
                }
                pre = cur;
                cur = cur.next;
            }
            return head;
        }
    }

    public static ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        } else if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else { // 两个都不为空开始计算
            // 设置l1为头结点
            ListNode head = l1;
            // 是否进位
            boolean isAdd = false;
            // 记录上一个节点
            ListNode pre = null;
            // 两个都不为空时才进行计算
            while (l1 != null && l2 != null) {
                int val = l1.val + l2.val;
                if (isAdd) {
                    val++;
                }
                // 判断下次是否进位
                isAdd = val >= 10;
                if (isAdd) {
                    val = val - 10;
                }
                l1.val = val;
                pre = l1;
                l1 = l1.next;
                l2 = l2.next;
            }
            // 判断下一个是l1还是l2
            ListNode cur = l1 == null ? l2 : l1;
            pre.next = cur;
            while (cur != null && isAdd) {
                cur.val++;
                isAdd = cur.val >= 10;
                if (isAdd) {
                    cur.val = cur.val - 10;
                }
                pre = cur;
                cur = cur.next;
            }
            if (isAdd) {
                // 补充进位
                pre.next = new ListNode(1);
            }
            return head;
        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        boolean isL1Null = l1 == null;
        boolean isL2Null = l2 == null;
        if (isL1Null && isL2Null) {
            return null;
        } else if (isL1Null) {
            // l2不为空
            return l2;
        } else if (isL2Null) {
            // l1不为空
            return l1;
        } else {
            // 两个都不为空
            ListNode result = l1;
            // 进位
            int calc = 0;
            // 记录上一个节点
            ListNode pre = null;
            // 直到有一方为空退出
            while (l1 != null && l2 != null) {
                l1.val = l1.val + l2.val;
                // 上一个进位处理
                if (calc == 1) {
                    l1.val = l1.val + 1;
                }
                // 当前进位处理
                if (l1.val >= 10) {
                    calc = 1;
                    l1.val = l1.val - 10;
                } else {
                    calc = 0;
                }
                pre = l1;
                l1 = l1.next;
                l2 = l2.next;
            }
            // 将不为空的那一段接到当前节点后面
            ListNode cur = l1 == null ? l2 : l1;
            pre.next = cur;
            // 有进位则处理cur
            while (calc == 1 && cur != null) {
                cur.val = cur.val + 1;
                if (cur.val >= 10) {
                    cur.val = cur.val - 10;
                } else {
                    calc = 0;
                }
                pre = cur;
                cur = cur.next;
            }
            // 还存在进位则需要
            if (calc == 1) {
                pre.next = new ListNode(1);
            }
            return result;
        }
    }
}
