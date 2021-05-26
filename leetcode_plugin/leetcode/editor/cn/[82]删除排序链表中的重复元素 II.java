//给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。 
//
// 示例 1: 
//
// 输入: 1->2->3->3->4->4->5
//输出: 1->2->5
// 
//
// 示例 2: 
//
// 输入: 1->1->1->2->3
//输出: 2->3 
// Related Topics 链表 
// 👍 459 👎 0


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
        if (head == null || head.next == null) {
            return head;
        }
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
//leetcode submit region end(Prohibit modification and deletion)
