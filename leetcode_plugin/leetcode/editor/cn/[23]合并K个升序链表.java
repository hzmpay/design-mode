//给你一个链表数组，每个链表都已经按升序排列。 
//
// 请你将所有链表合并到一个升序链表中，返回合并后的链表。 
//
// 
//
// 示例 1： 
//
// 输入：lists = [[1,4,5],[1,3,4],[2,6]]
//输出：[1,1,2,3,4,4,5,6]
//解释：链表数组如下：
//[
//  1->4->5,
//  1->3->4,
//  2->6
//]
//将它们合并到一个有序链表中得到。
//1->1->2->3->4->4->5->6
// 
//
// 示例 2： 
//
// 输入：lists = []
//输出：[]
// 
//
// 示例 3： 
//
// 输入：lists = [[]]
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// k == lists.length 
// 0 <= k <= 10^4 
// 0 <= lists[i].length <= 500 
// -10^4 <= lists[i][j] <= 10^4 
// lists[i] 按 升序 排列 
// lists[i].length 的总和不超过 10^4 
// 
// Related Topics 堆 链表 分治算法 
// 👍 1077 👎 0


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
    public ListNode mergeKLists(ListNode[] lists) {
        return merge(lists, 0, lists.length - 1);
    }

    public ListNode merge(ListNode[] lists, int l, int r) {
        if (l > r) {
            return null;
        }
        if (l == r) {
            // 指针相遇
            return lists[l];
        }
        final int middle = (l + r) / 2;
        return mergeTAwoListNode(merge(lists, l, middle), merge(lists, middle + 1, r));
    }

    /**
     * 两个合并
     *
     * @param node1
     * @param node2
     * @return ListNode
     * @author Hezeming
     */
    public ListNode mergeTAwoListNode(ListNode node1, ListNode node2) {
        ListNode preHeadNode = new ListNode(-1);
        ListNode preNode = preHeadNode;
        while (node1 != null && node2 != null) {
            if (node1.val < node2.val) {
                preNode.next = node1;
                node1 = node1.next;
            } else {
                preNode.next = node2;
                node2 = node2.next;
            }
            preNode = preNode.next;
        }
        // 此时存在一个未合并到preNode
        preNode.next = node1 == null ? node2 : node1;
        return preHeadNode.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
