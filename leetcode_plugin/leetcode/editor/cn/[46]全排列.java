//给定一个 没有重复 数字的序列，返回其所有可能的全排列。 
//
// 示例: 
//
// 输入: [1,2,3]
//输出:
//[
//  [1,2,3],
//  [1,3,2],
//  [2,1,3],
//  [2,3,1],
//  [3,1,2],
//  [3,2,1]
//] 
// Related Topics 回溯算法 
// 👍 1105 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
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
//leetcode submit region end(Prohibit modification and deletion)
