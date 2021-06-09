//给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。 
//
// 进阶：你能尝试使用一趟扫描实现吗？ 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,3,4,5], n = 2
//输出：[1,2,3,5]
// 
//
// 示例 2： 
//
// 
//输入：head = [1], n = 1
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：head = [1,2], n = 1
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 链表中结点的数目为 sz 
// 1 <= sz <= 30 
// 0 <= Node.val <= 100 
// 1 <= n <= sz 
// 
// Related Topics 链表 双指针 
// 👍 1401 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
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
    public ListNode removeNthFromEnd(ListNode head, int n) {
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
}
//leetcode submit region end(Prohibit modification and deletion)
