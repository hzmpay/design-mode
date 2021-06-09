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

}
//leetcode submit region end(Prohibit modification and deletion)
