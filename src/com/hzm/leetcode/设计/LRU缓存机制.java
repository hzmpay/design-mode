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
        lRUCache.put(1, 1);
        lRUCache.put(2, 2);
        lRUCache.get(1);
        lRUCache.put(3, 3);
        lRUCache.get(2);
        lRUCache.put(4, 4);
        lRUCache.get(1);
        lRUCache.get(3);
        lRUCache.get(4);
        // TODO 有问题

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

        /**
         * 总容量
         */
        private int capacity;
        /**
         * 当前容量
         */
        private int size;
        /**
         * <值，Node>
         */
        private Map<Integer, Node> map;
        /**
         * 头节点
         */
        private Node firstNode;
        /**
         * 尾节点
         */
        private Node lastNode;

        public LRUCache(int capacity) {
            this.capacity = capacity;
            map = new HashMap<>(capacity * 4 / 3);
        }

        public int get(int key) {
            Node node = map.get(key);
            if (node != null) {
                // 升级这个节点为尾结点
                moveEnd(node);
                return node.value;
            }
            return -1;
        }

        public void put(int key, int value) {
            if (capacity == 0) {
                return;
            }
            Node oldNode = map.get(key);
            // 存在直接替换原本节点的值，并把该节点移到末尾节点
            if (oldNode != null) {
                oldNode.value = value;
                if (oldNode != lastNode) {
                    // 刚好是尾节点则不用移动
                    moveEnd(oldNode);
                }
                return;
            }
            Node newNode = new Node(key, value);
            if (size == 0) {
                // 说明之前没有节点或者头节点和尾节点相同
                firstNode = newNode;
                lastNode = newNode;
            } else if (size == 1) {
                firstNode.next = newNode;
                newNode.prev = firstNode;
                lastNode = newNode;
            } else {
                // 新的节点添加到尾节点
                addEnd(newNode);
                // 将原本头节点的下一个节点升级为头节点
                firstNode.next.prev = null;
                firstNode = firstNode.next;
            }
            // 不存在则需要判断长度是否先删除再插入
            if (size == capacity) {
                // 已到达阀值则需要先删除头结点再插入
                map.remove(firstNode.key);
            } else {
                // 未到达阀值则长度+1
                size++;
            }
            // map添加节点
            map.put(key, newNode);

        }

        public void moveEnd(Node node) {
            // 只有1个值则不用移动
            if (size > 1 && node != lastNode) {
                // 先处理尾节点
                lastNode.next = node;

                // 当前节点是否是头节点
                boolean isFirst = node == firstNode;

                // 处理node的前后节点
                if (!isFirst) {
                    // 头节点不需要处理前置节点
                    node.prev.next = node.next;
                }
                node.next.prev = node.prev;

                if (isFirst) {
                    // 头节点该需要改变头结点定义
                    firstNode = node.next;
                }

                // 处理node本身
                node.next = null;
                node.prev = lastNode;
                lastNode = node;
            }
        }

        public void addEnd(Node node) {
            if (lastNode != node) {
                lastNode.next = node;
                node.prev = lastNode;
            }
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
