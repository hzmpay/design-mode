//给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。 
//
// candidates 中的数字可以无限制重复被选取。 
//
// 说明： 
//
// 
// 所有数字（包括 target）都是正整数。 
// 解集不能包含重复的组合。 
// 
//
// 示例 1： 
//
// 输入：candidates = [2,3,6,7], target = 7,
//所求解集为：
//[
//  [7],
//  [2,2,3]
//]
// 
//
// 示例 2： 
//
// 输入：candidates = [2,3,5], target = 8,
//所求解集为：
//[
//  [2,2,2,2],
//  [2,3,3],
//  [3,5]
//] 
//
// 
//
// 提示： 
//
// 
// 1 <= candidates.length <= 30 
// 1 <= candidates[i] <= 200 
// candidate 中的每个元素都是独一无二的。 
// 1 <= target <= 500 
// 
// Related Topics 数组 回溯算法 
// 👍 1147 👎 0


import java.util.Map;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
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
//leetcode submit region end(Prohibit modification and deletion)
