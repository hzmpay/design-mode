package com.hzm.leetcode.剑指Offer;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/zi-fu-chuan-de-pai-lie-lcof/
 *
 * @author Hezeming
 * @version 1.0
 * @date 2021年01月12日
 */
public class 字符串的排列 {


    public static void main(String[] args) {
        String[] strings = new 字符串的排列().permutation3("aab");
        System.out.println(Arrays.toString(strings));
        System.out.println(strings.length);
    }

    private static final List<String> list = new ArrayList<>();

    private char[] chars;

    public String[] permutation3(String s) {
        chars = s.toCharArray();
        dfs(0);
        return list.toArray(new String[list.size()]);
    }

    public void dfs(int x) {
        if (x == chars.length - 1) {
            list.add(String.valueOf(chars));
            return;
        }
        // 定义set防止同一层重复元素计算
        HashSet<Character> set = new HashSet<>();
        for (int i = x; i < chars.length; i++) {
            char aChar = chars[i];
            if (set.contains(aChar)) {
                continue;
            }
            set.add(aChar);
            swap(x, i);
            dfs(x + 1);
            swap(x, i);
        }
    }

    private void swap(int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }

    private static final Set<String> result = new HashSet<>();

    public String[] permutation2(String s) {
        char[] chars = s.toCharArray();
        HashSet<Character> set = new HashSet<>();
        for (char aChar : chars) {
            set.add(aChar);
        }
        backtrack2(set, 0, new StringBuilder(s.length()), set.size());
        return result.toArray(new String[result.size()]);
    }

    /**
     * 回溯的写法：迭代charArr每层，传入每层可用字符（TODO:废弃：题目要求是可以重复字符，但是字符串不能重复）
     *
     * @param set 用于每层可用字符的获取
     * @param index 层次数
     * @param builder 每层字符串拼接使用
     * @return void
     * @author Hezeming
     */
    public void backtrack2(Set<Character> set, int index, StringBuilder builder, int totalSize) {
        if (index == totalSize || set.isEmpty()) {
            // 遍历到最后一个
            result.add(builder.toString());
            return;
        }
        TreeSet<Character> newSet = new TreeSet<>(set);
        set.forEach(e -> {
            newSet.remove(e);
            builder.append(e);
            backtrack2(newSet, index + 1, builder, totalSize);
            newSet.add(e);
            builder.deleteCharAt(builder.length() - 1);
        });
    }

    public String[] permutation(String s) {
        char[] chars = s.toCharArray();
        backtrack(chars, 0, new StringBuilder(s.length()), new HashSet<>());
        return result.toArray(new String[result.size()]);
    }

    /**
     * 回溯的写法：迭代charArr每层，进行剪枝加枝操作（TODO:废弃：题目要求是可以重复字符，但是字符串不能重复）
     *
     * @param charArr 原始数组
     * @param index 层次数
     * @param builder 每层字符串拼接使用
     * @param set 用于每层字符是否使用判断
     * @return void
     * @author Hezeming
     */
    public void backtrack(char[] charArr, int index, StringBuilder builder, Set<Character> set) {
        if (index == charArr.length) {
            // 遍历到最后一个
            result.add(builder.toString());
            return;
        }

        // 存在元素一个都没匹配上，此时index没有进入到下一层，需要手动添加builder
        boolean flag = false;
        for (int i = 0; i < charArr.length; i++) {
            char c = charArr[i];
            if (set.contains(c)) {
                continue;
            }
            flag = true;
            set.add(c);
            // 加枝
            builder.append(c);
            // 回溯
            backtrack(charArr, index + 1, builder, set);
            // 剪枝
            builder.deleteCharAt(builder.length() - 1);
            set.remove(c);
        }
        if (!flag) {
            result.add(builder.toString());
        }
    }

//    private void backtrack("原始参数") {
//        //终止条件(递归必须要有终止条件)
//        if ("终止条件") {
//            //一些逻辑操作（可有可无，视情况而定）
//            return;
//        }
//
//        for (int i = "for循环开始的参数"; i < "for循环结束的参数"; i++) {
//            //一些逻辑操作（可有可无，视情况而定）
//
//            //做出选择
//
//            //递归
//            backtrack("新的参数");
//            //一些逻辑操作（可有可无，视情况而定）
//
//            //撤销选择
//        }
//    }

}
