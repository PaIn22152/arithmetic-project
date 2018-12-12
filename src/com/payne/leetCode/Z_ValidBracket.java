package com.payne.leetCode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Project    arithmetic-project-git
 * Path       com.payne.leetCode
 * Date       2018/11/12 - 11:36
 * Author     Payne.
 * About      类描述：有效括号判断
 */

public class Z_ValidBracket {

    public boolean checkValid(String s) {
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');
        for (Character tem : s.toCharArray()) {
            if (!map.containsKey(tem)) {
                stack.add(tem);
            } else if (stack.empty() || map.get(tem) != stack.pop()) {
                return false;
            }
        }
        return stack.empty();
    }

}
