package com.payne.leetCode.daily;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Project    arithmetic-project-git
 * Path       com.payne.leetCode.daily
 * Date       2020/08/26 - 09:24
 * Author     Payne.
 * About      类描述：
 */

public class D_17 {

    /**
     * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
     * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
     * <p>
     * 示例:
     * 输入："23"
     * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
     * <p>
     * 说明:
     * 尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */


    public List<String> letterCombinations(String digits) {
        Map<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        List<String> ans = new ArrayList<>();
        List<String> tem = new ArrayList<>();
        for (char c : digits.toCharArray()) {
            if (map.containsKey(c)) {
                tem.add(map.get(c));
            }
        }
//        bfs(ans, tem, 0);

        List<Integer> ptag = new ArrayList<>();
        for (int i = 0; i < tem.size(); i++) {
            ptag.add(0);
        }
        dfs(ans, tem, ptag);
        return ans;
    }

    public void bfs(List<String> ans, List<String> input, int index) {
        if (index < input.size()) {
            String s = input.get(index);
            if (ans.size() == 0) {
                for (char c : s.toCharArray()) {
                    ans.add(c + "");
                }
            } else {
                List<String> tem = new ArrayList<>();
                for (String an : ans) {
                    for (char c : s.toCharArray()) {
                        tem.add(an + c);
                    }
                }
                ans.clear();
                ans.addAll(tem);
            }
            bfs(ans, input, index + 1);
        }
    }

    public void dfs(List<String> ans, List<String> input, List<Integer> ptag) {
        if (input.size() == 0) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < input.size(); i++) {
            String s = input.get(i);
            if (s.length() > ptag.get(i)) {
                sb.append(s.charAt(ptag.get(i)));
            }
        }
        ans.add(sb.toString());

        for (int i = ptag.size() - 1; i >= 0; i--) {
            if (ptag.get(i) < input.get(i).length() - 1) {
                ptag.set(i, ptag.get(i) + 1);
                break;
            } else {
                ptag.set(i, 0);
                if (i > 0) {
                    ptag.set(i - 1, ptag.get(i - 1) + 1);
                    if (ptag.get(i - 1) <= input.get(i - 1).length() - 1) {
                        break;
                    }
                } else {
                    return;
                }

            }
        }
        dfs(ans, input, ptag);
    }


    //官方代码
    public List<String> letterCombinations2(String digits) {
        List<String> combinations = new ArrayList<String>();
        if (digits.length() == 0) {
            return combinations;
        }
        Map<Character, String> phoneMap = new HashMap<Character, String>() {{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};
        backtrack(combinations, phoneMap, digits, 0, new StringBuffer());
        return combinations;
    }

    public void backtrack(List<String> combinations, Map<Character, String> phoneMap,
                          String digits, int index, StringBuffer combination) {
        if (index == digits.length()) {
            combinations.add(combination.toString());
        } else {
            char digit = digits.charAt(index);
            String letters = phoneMap.get(digit);
            int lettersCount = letters.length();
            for (int i = 0; i < lettersCount; i++) {
                combination.append(letters.charAt(i));
                backtrack(combinations, phoneMap, digits, index + 1, combination);
                combination.deleteCharAt(index);
            }
        }
    }
}
