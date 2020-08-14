package com.payne.leetCode.daily;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Project    arithmetic-project-git
 * Path       com.payne.leetCode.daily
 * Date       2020/08/14 - 09:31
 * Author     Payne.
 * About      类描述：
 */

public class D_20 {

    /**
     * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
     * <p_old>
     * 有效字符串需满足：
     * 左括号必须用相同类型的右括号闭合。
     * 左括号必须以正确的顺序闭合。
     * 注意空字符串可被认为是有效字符串。
     * <p_old>
     * 示例 1:
     * 输入: "()"
     * 输出: true
     * <p_old>
     * 示例 2:
     * 输入: "()[]{}"
     * 输出: true
     * <p_old>
     * 示例 3:
     * 输入: "(]"
     * 输出: false
     * <p_old>
     * 示例 4:
     * 输入: "([)]"
     * 输出: false
     * <p_old>
     * 示例 5:
     * 输入: "{[]}"
     * 输出: true
     * <p_old>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/valid-parentheses
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    //1 ms  37.5 MB
    public boolean isValid(String s) {
        if (s.length() % 2 != 0) {
            return false;
        }
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (char c : chars) {
            if (c == '(') {
                stack.add(c);
            } else if (c == ')'
                    && (stack.empty() || '(' != stack.pop())) {
                return false;
            } else if (c == '{') {
                stack.add(c);
            } else if (c == '}'
                    && (stack.empty() || '{' != stack.pop())) {
                return false;
            } else if (c == '[') {
                stack.add(c);
            } else if (c == ']'
                    && (stack.empty() || '[' != stack.pop())) {
                return false;
            }
        }
        return stack.empty();
    }

    //2 ms  37.9 MB
    public boolean isValid2(String s) {
        if (s.length() % 2 != 0) {
            return false;
        }
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for (char c : chars) {
            if (c == '(' || c == '[' || c == '{') {
                stack.add(c);
            } else if (stack.empty() || stack.pop() != map.get(c)) {
                return false;
            }
        }
        return stack.isEmpty();

    }
}
