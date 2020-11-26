package com.hzm.leetcode.设计;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/lru-cache/
 *
 * @author Hezeming
 * @version 1.0
 * @date 2020年11月26日
 */
public class LRU缓存机制 {

    public static void main(String[] args) {

        LRUCache lRUCache = new LRUCache(2);
        lRUCache.put(1, 1); // 缓存是 {1=1}
        lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
        lRUCache.get(1);    // 返回 1
        lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
        lRUCache.get(2);    // 返回 -1 (未找到)
        lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
        lRUCache.get(1);    // 返回 -1 (未找到)
        lRUCache.get(3);    // 返回 3
        lRUCache.get(4);    // 返回 4

    }


    static class LRUCache {

        class Node {
            int key;
            int value;
            Node prev;
            Node next;

            public Node() {
            }

            public Node(int key, int value) {
                this.key = key;
                this.value = value;
            }
        }

        private int capacity;

        private int size;

        private Map<Integer, Node> map;

        private Node firstNode;

        private Node lastNode;

        public LRUCache(int capacity) {
            this.capacity = capacity;
            map = new HashMap<>(capacity * 4 / 3);
        }

        public int get(int key) {
            Node node = map.get(key);
            if (node != null) {
                // 升级这个节点为头结点
                moveFirst(node);
                return node.value;
            }
            return -1;
        }

        public void put(int key, int value) {
            if (capacity == 0) {
                return;
            }
            Node oldNode = map.get(key);
            // 存在直接替换原本节点的值
            if (oldNode != null) {
                oldNode.value = value;
                moveFirst(oldNode);
                return;
            }
            Node newNode = new Node(key, value);
            // 不存在则需要判断长度是否先删除再插入
            if (size == capacity) {
                // 已到达阀值则需要先删除头结点再插入
                map.remove(firstNode.key);
            } else {
                //
                size++;
            }
            map.put(key, newNode);
            if (size == 1) {
                // 头结点和尾节点相同
                firstNode = newNode;
                lastNode = newNode;
            } else {
                // 将原本头节点的下一个节点升级为头节点
                moveFirst(firstNode.next);
            }

            Node node = new Node(key, value);
            node.prev = lastNode;
            lastNode.next = node;


            size++;
        }

        public void moveFirst(Node node) {
            if (node == firstNode) {
                return;
            }
            if (node != lastNode) {
                node.prev.next = node.next;
            }
            node.next.prev = node.prev;
            firstNode.prev = node;
            node.prev = null;
            node.next = firstNode;
            firstNode = node;
        }
    }

    static class LRUCache1 extends LinkedHashMap<Integer, Integer> {

        private int capacity;

        public LRUCache1(int capacity) {
            super(capacity, 0.75F, true);
            this.capacity = capacity;
        }

        public int get(int key) {
            return super.getOrDefault(key, -1);
        }

        public void put(int key, int value) {
            super.put(key, value);
        }

        @Override
        protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
            return super.size() > capacity;
        }
    }
}
