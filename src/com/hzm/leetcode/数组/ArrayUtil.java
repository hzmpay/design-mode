package com.hzm.leetcode.数组;

import java.util.Arrays;

/**
 * 数组工具类
 *
 * @author Hezeming
 * @version 1.0
 * @date 2021年01月09日
 */
public class ArrayUtil {

    /**
     * 根据字符串转数组
     *
     * @param str
     * @return int[]
     * @author Hezeming
     */
    public static Integer[] toArray(String str) {
        String[] split = str.substring(1, str.length() - 1).split(",");
        return Arrays.stream(split).map(e -> Integer.valueOf(e)).toArray(Integer[]::new);
    }

    /**
     * 根据字符串转二维数组
     *
     * @param str
     * @return int[]
     * @author Hezeming
     */
    public static Integer[][] toArray2(String str) {
        String[] split = str.substring(2, str.length() - 2).split("],\\[");
        return Arrays.stream(split).map(e -> Arrays.stream(e.split(",")).map(i -> Integer.valueOf(i)).toArray(Integer[]::new)).toArray(Integer[][]::new);
    }

    /**
     * 根据字符串转数组
     *
     * @param str
     * @return int[]
     * @author Hezeming
     */
    public static int[] toArrayInt(String str) {
        String[] split = str.substring(1, str.length() - 1).split(",");
        return Arrays.stream(split).mapToInt(e -> Integer.parseInt(e)).toArray();
    }

    /**
     * 根据字符串转二维数组
     *
     * @param str
     * @return int[]
     * @author Hezeming
     */
    public static int[][] toArrayInt2(String str) {
        String[] split = str.substring(2, str.length() - 2).split("],\\[");
        return Arrays.stream(split).map(e -> Arrays.stream(e.split(",")).mapToInt(i -> Integer.valueOf(i)).toArray()).toArray(int[][]::new);
    }
}
