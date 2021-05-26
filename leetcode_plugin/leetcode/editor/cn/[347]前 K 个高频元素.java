//给定一个非空的整数数组，返回其中出现频率前 k 高的元素。 
//
// 
//
// 示例 1: 
//
// 输入: nums = [1,1,1,2,2,3], k = 2
//输出: [1,2]
// 
//
// 示例 2: 
//
// 输入: nums = [1], k = 1
//输出: [1] 
//
// 
//
// 提示： 
//
// 
// 你可以假设给定的 k 总是合理的，且 1 ≤ k ≤ 数组中不相同的元素的个数。 
// 你的算法的时间复杂度必须优于 O(n log n) , n 是数组的大小。 
// 题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一的。 
// 你可以按任意顺序返回答案。 
// 
// Related Topics 堆 哈希表 
// 👍 593 👎 0


import java.util.Map;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public int[] topKFrequent(int[] nums, int k) {
//        // 构建出现次数Map<值，出现次数>
//        Map<Integer, Integer> map = new HashMap<>(nums.length / 3 * 4);
//        for (int num : nums) {
//            map.put(num, map.getOrDefault(num, 0) + 1);
//        }
//        map.keySet();
//        Map.Entry[] entryArr = map.entrySet().toArray(new Map.Entry[0]);
//        sort(entryArr, 0, entryArr.length - 1);
//
//
//        int[] result = new int[k];
//        for (int i = 0; i < result.length; i++) {
//            result[i] = (int) entryArr[i].getKey();
//        }
//
//        return result;
        // 构建出现次数Map<值，出现次数>
        Map<Integer, Integer> map = new HashMap<>(nums.length / 3 * 4);
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // 按照value值从小到大排
        PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue((Comparator<Map.Entry<Integer, Integer>>) (o1, o2) -> o1.getValue().compareTo(o2.getValue()));
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            // 存入K个数即可
            if (queue.size() == k) {
                // 判断是否比栈顶的值大
                if (entry.getValue() > queue.peek().getValue()) {
                    // 出栈
                    queue.poll();
                    // 入栈
                    queue.offer(entry);
                }
            } else {
                queue.offer(entry);
            }
        }
        int[] result = new int[k];
        for (int i = 0; i < result.length; i++) {
            result[i] = queue.poll().getKey();
        }
        return result;
    }

    public void sort(Map.Entry[] nums, int l, int r) {
        if (l >= r) {
            return;
        }
        int left = l;
        int right = r;

        // 最左边的当做中间值
        int temp = (int) nums[l].getValue();
        // 直到左右指针相遇
        while (left < right) {
            while (((int) nums[right].getValue() <= temp) && (left < right)) {
                right--;
            }
            swap(nums, right, left);

            while (((int) nums[left].getValue() >= temp) && (left < right)) {
                left++;
            }
            swap(nums, left, right);
        }
        sort(nums, l, left);
        sort(nums, left + 1, r);
    }

    public void swap(Map.Entry[] nums, int l, int r) {
        Map.Entry temp = nums[l];
        nums[l] = nums[r];
        nums[r] = temp;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
