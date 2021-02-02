package com.hzm.leetcode.回溯;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/combination-sum/
 *
 * @author Hezeming
 * @version 1.0
 * @date 2021年02月02日
 */
public class 组合总和 {

    public static void main(String[] args) {
        组合总和 demo = new 组合总和();
        int[] arr = {1, 2};
        List<List<Integer>> lists = demo.combinationSum(arr, 4);
        for (List<Integer> list : lists) {
            System.out.println(list);
        }
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(candidates, target, result, new ArrayList<>(), new HashMap<>());
        return result;
    }

    /**
     * 递归
     *
     * @param candidates 原始数组
     * @param target 目标和
     * @param result 返回集合
     * @param cur 当前集合
     * @return void
     * @author Hezeming
     */
    public void backtrack(int[] candidates, int target, List<List<Integer>> result, List<Integer> cur, Map<String, String> map) {
        // 等于0说明符合条件，添加到result
        if (target == 0) {
            ArrayList<Integer> newCur = new ArrayList<>(cur);
            String curStr = ser(newCur);
            if (!map.containsKey(curStr)) {
                result.add(new ArrayList<>(cur));
                map.put(curStr, curStr);
            }
            return;
        }
        for (int candidate : candidates) {
            final int newTarget = target - candidate;
            // 大于说明还存在下一轮
            // 等于说明刚好
            if (newTarget >= 0) {
                // 插枝
                cur.add(candidate);
                // 进入下一轮
                backtrack(candidates, newTarget, result, cur, map);
                // 剪枝
                cur.remove(cur.size() - 1);
            }
            // 小于直接跳过
        }
    }

    public String ser(List<Integer> cur) {
        cur.sort(Comparator.naturalOrder());
        StringBuilder builder = new StringBuilder();
        cur.forEach(e -> builder.append(e).append('-'));
        return builder.toString();
    }
}
