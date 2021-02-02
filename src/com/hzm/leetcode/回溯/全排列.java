package com.hzm.leetcode.回溯;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * https://leetcode-cn.com/problems/permutations/solution/quan-pai-lie-by-leetcode-solution-2/
 *
 * @author Hezeming
 * @version 1.0
 * @date 2021年02月02日
 */
public class 全排列 {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> outPut = Arrays.stream(nums).boxed().collect(Collectors.toList());
        // 用outPut去传递数组的变化，比如:1,2,3,4,5
        // index = 1; outPut = (1 | 2,3,4,5)
        // index = 2; outPut = (1,2 | 3,4,5)
        backtrack(nums.length, result, 0, outPut);
        return result;
    }

    public void backtrack(int len, List<List<Integer>> result, int index, List<Integer> outPut) {
        // 填充完毕
        if (index == len) {
            result.add(new ArrayList<>(outPut));
        }
        for (int i = index; i < len; i++) {
            // 从index位置开始填
            Collections.swap(outPut, index, i);
            // 从index + 1位置开始重新递归填下一个数
            backtrack(len, result, index + 1, outPut);
            // 恢复outPut供下一次使用
            Collections.swap(outPut, index, i);
        }
    }
}
