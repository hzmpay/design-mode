package com.hzm.leetcode.链表;

/**
 * 链表
 *
 * @author Hezeming
 * @version 1.0
 * @date 2020年09月29日
 */
public class ListNode {

    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int x, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(val + " ");
        if (next != null) {
            builder.append(next.toString());
        }
        return builder.toString();
    }

    /**
     * 字符串转链表
     *
     * @param arrStr
     * @return com.hzm.leetcode.链表.ListNode
     * @author Hezeming
     */
    public static ListNode toNode(String arrStr) {
        String[] values = arrStr.replace("[", "").replace("]", "").split(",");
        if (values.length == 0 || values[0].equals("")) {
            return null;
        }
        ListNode listNode = new ListNode(Integer.parseInt(values[0]));
        ListNode pre = listNode;
        for (int j = 1; j < values.length; j++) {
            pre.next = new ListNode(Integer.parseInt(values[j]));
            pre = pre.next;
        }
        return listNode;
    }

    /**
     * 字符串转链表数组
     *
     * @param arrStr
     * @return com.hzm.leetcode.链表.ListNode[]
     * @author Hezeming
     */
    public static ListNode[] toListNode(String arrStr) {
        String[] arrStrArr = arrStr.replace("[[", "")
                .replace("]]", "")
                .split("],\\[");
        ListNode[] listNodes = new ListNode[arrStrArr.length];
        for (int i = 0; i < arrStrArr.length; i++) {
            listNodes[i] = toNode(arrStrArr[i]);
        }
        return listNodes;
    }

    public static void main(String[] args) {
        ListNode[] listNodes = ListNode.toListNode("[[],[-1,5,11],[],[6,10]]");
        for (ListNode listNode : listNodes) {
            System.out.println(listNode);
        }
    }
}
