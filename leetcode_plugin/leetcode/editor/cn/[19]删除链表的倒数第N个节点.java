//给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。 
//
// 示例： 
//
// 给定一个链表: 1->2->3->4->5, 和 n = 2.
//
//当删除了倒数第二个节点后，链表变为 1->2->3->5.
// 
//
// 说明： 
//
// 给定的 n 保证是有效的。 
//
// 进阶： 
//
// 你能尝试使用一趟扫描实现吗？ 
// Related Topics 链表 双指针 
// 👍 1166 👎 0


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
        // 快慢指针
//        1  1 + n = 3
        ListNode slowNode = head;
        ListNode quickNode = head;
        while (n > 1) {
            quickNode = quickNode.next;
            n--;
        }
        if (quickNode == null) {
            // 不足n个节点
            return null;
        }
        quickNode = quickNode.next;
        if (quickNode == null) {
            // 刚好是n个节点
            return slowNode.next;
        }

        quickNode = quickNode.next;
        // 开始遍历
        while (quickNode != null) {
            quickNode = quickNode.next;
            slowNode = slowNode.next;
        }

        // 此时slowNode是倒数第n个节点的前一个节点
        slowNode.next = slowNode.next.next;
        return head;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
