package com.hzm.leetcode.栈;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/valid-parentheses/
 *
 * @author Hezeming
 * @version 1.0
 * @date 2020年11月19日
 */
public class 有效的括号 {

    public static void main(String[] args) {

    }

    public static boolean isValid(String s) {
        // 长度一定为偶数，奇数直接返回false
        int length = s.length();
        if (length % 2 == 1) {
            return false;
        }
        Map<Character, Character> map = new HashMap<Character, Character>(){{
            put(')', '(');
            put(']', '[');
            put('}', '{');
        }};
        // 左括号入栈，右括号进行匹配出栈
        Deque<Character> stack = new LinkedList<>();
        char[] charArr = s.toCharArray();
        for (int i = 0; i < charArr.length; i++) {
            char c = charArr[i];
            Character value = map.get(c);
            if (value == null) {
                // map的key没有说明是左括号，入栈
                stack.push(c);
            } else {
                // 出栈匹配
                Character poll = stack.poll();
                // 说明不匹配
                if (poll != value) {
                    return false;
                }
            }
        }
        // 栈为空说明全部匹配
        return stack.isEmpty();
    }
}
