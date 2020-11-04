package com.hzm.缓存;

import java.util.Arrays;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author Hezeming
 * @version 1.0
 * @date 2020年07月05日
 */
public class Test {

    public static void main(String[] args) {

    }

    public static Integer demo(int[] nums) {
        Map<Integer, Long> map = Arrays.stream(nums)
                .boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        int max = nums.length >> 1;
        Integer value = null;
        for (Map.Entry<Integer, Long> entry : map.entrySet()) {
            if (entry.getValue() > max) {
                return entry.getKey();
            }
        }
        return -1;
    }
}
