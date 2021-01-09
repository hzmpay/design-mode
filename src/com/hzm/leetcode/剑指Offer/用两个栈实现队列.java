package com.hzm.leetcode.剑指Offer;

import java.util.Deque;
import java.util.LinkedList;

/**
 * https://leetcode-cn.com/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof/
 *
 * @author Hezeming
 * @version 1.0
 * @date 2021年01月09日
 */
public class 用两个栈实现队列 {

    public static void main(String[] args) {

    }

    class CQueue {

        /** 存储新增的元素 */
        private final Deque<Integer> stack1;
        /** 存储删除的元素 */
        private final Deque<Integer> stack2;

        public CQueue() {
            stack1 = new LinkedList<>();
            stack2 = new LinkedList<>();
        }

        public void appendTail(int value) {
            stack1.push(value);
        }

        public int deleteHead() {
            if (stack2.peek() == null) {
                // stack2头结点为空需要从stack1补充
                while (stack1.peek() != null) {
                    stack2.push(stack1.poll());
                }
            }
            if (stack2.peek() != null) {
                return stack2.poll();
            } else {
                return -1;
            }
        }
    }
}
