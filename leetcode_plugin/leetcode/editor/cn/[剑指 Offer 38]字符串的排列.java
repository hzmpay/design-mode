//输入一个字符串，打印出该字符串中字符的所有排列。 
//
// 
//
// 你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。 
//
// 
//
// 示例: 
//
// 输入：s = "abc"
//输出：["abc","acb","bac","bca","cab","cba"]
// 
//
// 
//
// 限制： 
//
// 1 <= s 的长度 <= 8 
// Related Topics 回溯算法 
// 👍 158 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    private static final List<String> list = new ArrayList<>();

    private char[] chars;

    public String[] permutation(String s) {
        chars = s.toCharArray();
        dfs(0);
        return list.toArray(new String[list.size()]);
    }

    public void dfs(int x) {
        if (x == chars.length - 1) {
            list.add(new String(chars));
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
}
//leetcode submit region end(Prohibit modification and deletion)
