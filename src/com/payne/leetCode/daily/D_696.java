package com.payne.leetCode.daily;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Project    arithmetic-project-git
 * Path       com.payne.leetCode.daily
 * Date       2020/08/10 - 09:42
 * Author     Payne.
 * About      类描述：
 */

public class D_696 {

    /**
     * 给定一个字符串 s，计算具有相同数量0和1的非空(连续)子字符串的数量，
     * 并且这些子字符串中的所有0和所有1都是组合在一起的。
     * 重复出现的子串要计算它们出现的次数。
     * <p_old>
     * 示例 1 :
     * 输入: "00110011"
     * 输出: 6
     * 解释: 有6个子串具有相同数量的连续1和0：“0011”，“01”，“1100”，“10”，“0011” 和 “01”。
     * 请注意，一些重复出现的子串要计算它们出现的次数。
     * 另外，“00110011”不是有效的子串，因为所有的0（和1）没有组合在一起。
     * <p_old>
     * 示例 2 :
     * 输入: "10101"
     * 输出: 4
     * 解释: 有4个子串：“10”，“01”，“10”，“01”，它们具有相同数量的连续1和0。
     * 注意：
     * s.length 在1到50,000之间。
     * s 只包含“0”或“1”字符。
     * <p_old>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/count-binary-substrings
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    //暴力解法，遍历所有子串，依次判断是否满足（最蠢的解法。。。）
    //超时
    public int countBinarySubstrings2(String s) {
        int left = 0, right = s.length(), num = 0;
        map.clear();
        while (left < right) {
            String sub = s.substring(left, right);
            if (isValid(sub)) {
                map.put(sub, true);
                num++;
            } else {
                map.put(sub, false);
            }
            if (left < right - 1) {
                left++;
            } else {
                right--;
                left = 0;
            }
        }
        return num;
    }

    private HashMap<String, Boolean> map = new HashMap<>();

    //具有相同数量的连续1和0
    private boolean isValid(String s) {
        if (map.containsKey(s)) {
            return map.get(s);
        }
        int len = s.length();
        if (len % 2 != 0) {
            return false;
        }
        boolean leftIs0 = true;
        for (int i = 0; i < len; i++) {
            if (i == 0) {
                leftIs0 = s.charAt(i) == '0';
            } else if (i < len / 2) {
                if ((s.charAt(i) == '0') != leftIs0) {
                    return false;
                }
            } else if (i >= len / 2) {
                if ((s.charAt(i) == '0') == leftIs0) {
                    return false;
                }
            }
        }
        return true;
    }


    /**
     * 官方解法
     * 思路与算法
     * 我们可以将字符串 ss 按照 00 和 11 的连续段分组，
     * 存在  countscounts 数组中，例如 s = 00111011s=00111011，
     * 可以得到这样的 counts 数组：{ counts} = \{2, 3, 1, 2\}counts={2,3,1,2}。
     * 这里  countscounts 数组中两个相邻的数一定代表的是两种不同的字符。
     * 假设  countscounts 数组中两个相邻的数字为 uu 或者 vv，
     * 它们对应着 uu 个 00 和 vv 个 11，或者 uu 个 11 和 vv 个 00。
     * 它们能组成的满足条件的子串数目为 \min \{ u, v \}min{u,v}，
     * 即一对相邻的数字对答案的贡献。
     * <p_old>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/count-binary-substrings/solution/ji-shu-er-jin-zhi-zi-chuan-by-leetcode-solution/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * <p_old>
     * 自己实现的代码
     */
    public int countBinarySubstrings3(String s) {
        if (s.length() < 2) {
            return 0;
        }
        List<Integer> list = new ArrayList<>();
        boolean lastIs0 = s.charAt(0) == '0';
        int n = 1;
        for (int i = 1; i < s.length(); i++) {
            boolean is0 = s.charAt(i) == '0';
            if (lastIs0 == is0) {
                n++;
            } else {
                list.add(n);
                n = 1;
                lastIs0 = is0;
            }
        }
        list.add(n);
        int num = 0;
        for (int i = 0; i < list.size() - 1; i++) {
            num += Math.min(list.get(i), list.get(i + 1));
        }
        return num;
    }

    /**
     * 官方代码
     */
    public int countBinarySubstrings(String s) {
        List<Integer> counts = new ArrayList<>();
        int ptr = 0, n = s.length();
        while (ptr < n) {
            char c = s.charAt(ptr);
            int count = 0;
            while (ptr < n && s.charAt(ptr) == c) {
                ++ptr;
                ++count;
            }
            counts.add(count);
        }
        int ans = 0;
        for (int i = 1; i < counts.size(); ++i) {
            ans += Math.min(counts.get(i), counts.get(i - 1));
        }
        return ans;
    }
}
