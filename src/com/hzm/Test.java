package com.hzm;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Hezeming
 * @version 1.0
 * @date 2021年01月07日
 */
public class Test {

    /**
     * 合并N个有序链表
     *
     * @param args
     * @return void
     * @author Hezeming
     */
    public static void main(String[] args) {

    }

    public static Node demo(List<Node> nodeList) {
        List<Node> list = new ArrayList<>();
        for (Node node : nodeList) {
            while (node != null) {
                list.add(node);
                node = node.next;
            }
        }
        return null;
    }

    public static Node meger3(Node node1, Node node2) {
        // 1 3 7
        // 2 4 6
        Node x = node1;
        Node y = node2;

        boolean isNode1 = x.value < y.value;
        while (x != null && y != null) {
            if (x.value > y.value) {
                Node temp = x;
                x = y;
                y = temp;
            }
            Node next = x.next;
            x.next = y;
            x = y;
            y = next;
        }
        return isNode1 ? node1 : node2;
    }



    public static Node meger2(Node node1, Node node2) {
        Node node = meger1(node1, node2);
        node.next = meger1(node1.next, node2.next);
        return node;
    }

    public static Node meger1(Node node1, Node node2) {
        if (node1 == null && node2 == null) {
            return null;
        } else if (node1 == null) {
            return node2;
        } else if (node2 == null) {
            return node1;
        }
        node1.value = node1.value + node2.value;
        return node1;
    }

    class Node {

        private int value;

        private Node next;

        public Node() {
        }

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }
}
