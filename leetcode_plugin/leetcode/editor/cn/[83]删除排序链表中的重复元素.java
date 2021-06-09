//给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。 
//
// 示例 1: 
//
// 输入: 1->1->2
//输出: 1->2
// 
//
// 示例 2: 
//
// 输入: 1->1->2->3->3
//输出: 1->2->3 
// Related Topics 链表 
// 👍 474 👎 0


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
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode cur = head;
        while (cur.next != null) {
            // 当前元素和下一个元素重复
            if (cur.val == cur.next.val) {
                // 删除下一个元素，不改变当前元素，因为下一个元素改变了，所有需要重新比较
                cur.next = cur.next.next;
            } else {
                // 不重复则调到下一个元素
                cur = cur.next;
            }
        }
        return head;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
