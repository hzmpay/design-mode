//给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。 
//
// 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,3,4]
//输出：[2,1,4,3]
// 
//
// 示例 2： 
//
// 
//输入：head = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：head = [1]
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目在范围 [0, 100] 内 
// 0 <= Node.val <= 100 
// 
// Related Topics 递归 链表 
// 👍 777 👎 0


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
    public ListNode swapPairs(ListNode head) {
        // 1 2 3 4 5 6
        /*
         * 1.1-2交换，此时head由1变成了2，所以返回之前2的地址
         * 1-2-3-4-5-6 -> 2-1-3-4-5-6
         * 2.递归传入1的下一个节点，也就是3
         */
        if (head == null || head.next == null) {
            return null;
        }
        ListNode next = head.next;
        head.next = next.next;
        next.next = head;
        swapPairs(head.next);
        return next;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
