package com.hzm.leetcode.回溯;

import java.util.List;

/**
 * https://leetcode-cn.com/problems/generate-parentheses/
 *
 * @author Hezeming
 * @version 1.0
 * @date 2021年02月02日
 */
public class 括号生成 {

    public List<String> generateParenthesis(int n) {

        List<String> strings = generateParenthesis(n - 1);
        return null;
    }
}
