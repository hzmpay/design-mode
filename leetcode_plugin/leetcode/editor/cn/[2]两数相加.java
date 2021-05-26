//给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。 
//
// 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。 
//
// 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。 
//
// 示例： 
//
// 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
//输出：7 -> 0 -> 8
//原因：342 + 465 = 807
// 
// Related Topics 链表 数学 
// 👍 5227 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.List;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
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
//leetcode submit region end(Prohibit modification and deletion)
