package com.hzm.leetcode.设计;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

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
//        lRUCache.put(1, 1);
//        lRUCache.put(2, 2);
//        int i = lRUCache.get(1);
//        lRUCache.put(3, 3);
//        int i1 = lRUCache.get(2);
//        lRUCache.put(4, 4);
//        int i2 = lRUCache.get(1);
//        int i3 = lRUCache.get(3);
//        int i4 = lRUCache.get(4);

        int i = lRUCache.get(2);
        lRUCache.put(2, 6);
        int i2 = lRUCache.get(1);
        lRUCache.put(1, 5);
        lRUCache.put(1, 2);
        int i3 = lRUCache.get(1);
        int i4 = lRUCache.get(2);
    }


    static class LRUCache {

        class Node {
            int key;
            int value;
            /** 前驱节点 */
            Node prev;
            /** 后驱节点 */
            Node next;

            public Node() {
            }

            public Node(int key, int value) {
                this.key = key;
                this.value = value;
            }
        }

        /** <key, Node> */
        private Map<Integer, Node> map;
        /** 容量 */
        private int capacity;
        /** 已使用容量 */
        private int size;
        /** 虚拟头部节点 */
        Node head;
        /** 虚拟尾部节点 */
        Node tail;

        public LRUCache(int capacity) {
            map = new HashMap<>(capacity * 4 / 3 + 1);
            this.capacity = capacity;
            this.size = 0;
            // 采用虚拟头尾节点，避免前后节点的空判断
            head = new Node();
            tail = new Node();
            head.next = tail;
            tail.prev = head;
        }

        /**
         * get操作依赖用HashMap保持O(1)复杂度
         *
         * @param key
         * @return int
         * @author Hezeming
         */
        public int get(int key) {
            // 1.从map获取
            // 2.将该key对应的Node移到队列头部
            Node node = map.get(key);
            if (node == null) {
                // 不存在返回-1
                return -1;
            }
            moveHead(node);
            return node.value;
        }

        public void put(int key, int value) {
            // 1.判断是否存在
            Node node = map.get(key);
            // 不存在
            if (node == null) {
                // 2.判断容量是否足够
                //  1.足够：放到队列头部，存入map
                //  2.不够：移除队列尾部元素，size++，放到队列头部，存入map
                node = new Node(key, value);
                if (size >= capacity) {
                    // 删除尾部元素
                    removeNode(tail.prev);
                } else {
                    size++;
                }
                addHead(node);
            } else {
                // 存在则替换value，移到头部
                node.value = value;
                moveHead(node);
            }
        }

        /**
         * 添加新节点到head
         *
         * @param node
         * @return void
         * @author Hezeming
         */
        private void addHead(Node node) {
            // 处理node
            node.next = head.next;
            node.prev = head;
            // node插到head后面
            head.next.prev = node;
            head.next = node;
            map.put(node.key, node);
        }

        /**
         * 将已存在的节点移到头结点
         *
         * @param node
         * @return void
         * @author Hezeming
         */
        private void moveHead(Node node) {
            // 删除这个node，处理node前后节点
            removeNode(node);
            addHead(node);
        }

        /**
         * 删除元素
         *
         * @param node
         * @return void
         * @author Hezeming
         */
        private void removeNode(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
            map.remove(node.key);
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
