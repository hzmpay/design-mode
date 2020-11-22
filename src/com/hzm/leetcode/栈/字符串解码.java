package com.hzm.leetcode.栈;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Objects;

/**
 * https://leetcode-cn.com/problems/decode-string/solution/zi-fu-chuan-jie-ma-by-leetcode-solution/
 *
 * @author Hezeming
 * @version 1.0
 * @date 2020年11月22日
 */
public class 字符串解码 {

    public static void main(String[] args) {
//        System.out.println(decodeString("3[a]2[bc]"));
//        System.out.println(decodeString("3[a2[c]]"));
//        System.out.println(decodeString("2[abc]3[cd]ef"));
//        System.out.println(decodeString("abc3[cd]xyz"));
        System.out.println(decodeString("3[z]2[2[y]pq4[2[jk]e1[f]]]ef"));

        System.out.println("zzzyypqjkjkefjkjkefjkjkefjkjkefyypqjkjkefjkjkefjkjkefjkjkefef");
    }

    public static String decodeString(String s) {
        Deque<String> stack = new LinkedList<>();
        char[] charArr = s.toCharArray();
        for (int i = 0; i < charArr.length; i++) {
            char c = charArr[i];
            // 如果是数字，需要解析下一位得到完整的数字入栈
            if (Character.isDigit(c)) {
                StringBuilder build = new StringBuilder();
                do {
                    build.append(c);
                } while (Character.isDigit((c = charArr[++i])));
                stack.push(build.toString());
                // 此时c是数字的下一位，肯定是[，所以直接入栈，不用再循环判断
                stack.push(String.valueOf(c));
                continue;
            } else if (c == '[' || c != ']') {
                // 如果是[或者字母则直接进栈
                stack.push(String.valueOf(c));
            } else {
                // 如果是]则开始出栈
                String first;
                StringBuilder build = new StringBuilder();
                // 知道first是[左括号退出，采用由内向外分解左右括号
                while (!(first = stack.pop()).equals("[")) {
                    // 因为是倒序，存在 a, bcd
                    // 结果：bcda ，反过来：adcb
                    // 所以应该转为字符，倒序append
                    char[] firstCharArr = first.toCharArray();
                    for (int j = firstCharArr.length - 1; j >= 0; j--) {
                        build.append(firstCharArr[j]);
                    }
                }
                String value = build.reverse().toString();
                // 栈顶一定是数字，因为前一个数是[
                first = stack.pop();
                // 对build进行次数转换
                for (int j = 1; j < Integer.parseInt(first); j++) {
                    build.append(value);
                }
                // 入栈
                stack.push(build.toString());
            }

        }
        String end;
        StringBuilder builder = new StringBuilder();
        while ((end = stack.pollLast()) != null) {
            builder.append(end);
        }
        return builder.toString();
    }

}
