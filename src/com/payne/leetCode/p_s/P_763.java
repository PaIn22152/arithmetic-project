package com.payne.leetCode.p_s;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Project    arithmetic-project-git
 * Path       com.payne.leetCode.p_s
 * Date       2020/08/12 - 11:56
 * Author     Payne.
 * About      类描述：
 */

public class P_763 {

    /**
     * 字符串 S 由小写字母组成。我们要把这个字符串划分为尽可能多的片段，
     * 同一个字母只会出现在其中的一个片段。
     * 返回一个表示每个字符串片段的长度的列表。
     * <p_old>
     * 示例 1：
     * 输入：S = "ababcbaca defegde hijhklij"
     * 输出：[9,7,8]
     * 解释：
     * 划分结果为 "ababcbaca", "defegde", "hijhklij"。
     * 每个字母最多出现在一个片段中。
     * 像 "ababcbacadefegde", "hijhklij" 的划分是错误的，因为划分的片段数较少。
     * <p_old>
     * 提示：
     * S的长度在[1, 500]之间。
     * S只包含小写字母 'a' 到 'z' 。
     * <p_old>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/partition-labels
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    public List<Integer> partitionLabels(String s) {
        int left = 0, right = left + 1;
        List<Integer> res = new ArrayList<>();
        Set<Character> set = new HashSet<>();
        while (right < s.length()) {
            if (!check(s, left, right, set)) {
                right++;
            } else {
                res.add(right - left + 1);
                left = right + 1;
                right = left + 1;
            }
        }
        return res;
    }

    private boolean check(String s, int left, int right, Set<Character> set) {
        set.clear();
        for (int i = left; i <= right; i++) {
            set.add(s.charAt(i));
        }
        for (int i = 0; i < s.length(); i++) {
            if (i < left || i > right) {
                if (set.contains(s.charAt(i))) {
                    return false;
                }
            }
        }
        return true;
    }


    public List<Integer> partitionLabels2(String s) {
        Map<Character, Integer> mapL = new HashMap<>();
        Map<Character, Integer> mapR = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!mapL.containsKey(c)) {
                mapL.put(c, i);
            }
            mapR.put(c, i);
        }
        int left = 0, right = 0, start = 0;
        List<Integer> res = new ArrayList<>();
        while (left < s.length()) {
            char c = s.charAt(left);
            right = Math.max(right, mapR.get(c));
            if (left < right) {
                left++;
            } else {
                res.add(right - start + 1);
                left = right + 1;
                start = left;
                right = 0;
            }
        }
        return res;
    }


    /**
     * 执行用时：5 ms
     * 内存消耗：38.1 MB
     * <p_old>
     * 遍历一遍字符串，找到每个char在s中最靠右的位置并记录，
     * 因为s全是由小写字母组成，所以可以用int[26]，节省空间和时间
     * 然后再从left=0遍历s，找到left位置char的最右位置right，
     * 然后left++，找到新的最右位置，如果比上一次的大，更新right
     * 直到left==right，找到一个满足条件的子串，len=right+1-left
     * 然后left=right+1
     * 一直到left=s.len
     */
    public List<Integer> partitionLabels3(String s) {
        int[] rightIndex = new int[26];//存储char在s中最靠右的位置
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            rightIndex[c - 'a'] = i;
        }

        int left = 0, right = 0, start = 0;
        List<Integer> res = new ArrayList<>();
        while (left < s.length()) {
            right = Math.max(right, rightIndex[s.charAt(left) - 'a']);
            if (left < right) {
                left++;
            } else {
                res.add(right - start + 1);
                left = right + 1;
                start = left;
                right = 0;
            }
        }
        return res;

    }


    /**
     * 官方代码
     * <p_old>
     * 执行用时：5 ms, 在所有 Java 提交中击败了78.37%的用户
     * 内存消耗：38.2 MB, 在所有 Java 提交中击败了77.47%的用户
     */
    public List<Integer> partitionLabels4(String s) {
        int[] last = new int[26];
        for (int i = 0; i < s.length(); ++i)
            last[s.charAt(i) - 'a'] = i;

        int j = 0, anchor = 0;
        List<Integer> ans = new ArrayList();
        for (int i = 0; i < s.length(); ++i) {
            j = Math.max(j, last[s.charAt(i) - 'a']);
            if (i == j) {
                ans.add(i - anchor + 1);
                anchor = i + 1;
            }
        }
        return ans;
    }

}
