//请判断一个链表是否为回文链表。 
//
// 示例 1: 
//
// 输入: 1->2
//输出: false 
//
// 示例 2: 
//
// 输入: 1->2->2->1
//输出: true
// 
//
// 进阶： 
//你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？ 
// Related Topics 链表 双指针 
// 👍 1010 👎 0


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
    public boolean isPalindrome(ListNode head) {
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
        return true;
    }

    public ListNode reverse2(ListNode node) {
        ListNode pre = null;
        while (node != null) {
            ListNode next = node.next;
            node.next = pre;
            pre = node;
            node = next;
        }
        return pre;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
