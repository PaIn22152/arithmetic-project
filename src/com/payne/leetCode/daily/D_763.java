package com.payne.leetCode.daily;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Project    arithmetic-project-git
 * Path       com.payne.leetCode.daily
 * Date       2020/10/22 - 09:51
 * Author     Payne.
 * About      类描述：
 */

class D_763 {

    /*https://leetcode-cn.com/problems/partition-labels/
    * 763. 划分字母区间
字符串 S 由小写字母组成。我们要把这个字符串划分为尽可能多的片段，
同一个字母只会出现在其中的一个片段。返回一个表示每个字符串片段的长度的列表。

示例 1：
输入：S = "ababcbacadefegdehijhklij"
输出：[9,7,8]
解释：
划分结果为 "ababcbaca", "defegde", "hijhklij"。
每个字母最多出现在一个片段中。
像 "ababcbacadefegde", "hijhklij" 的划分是错误的，因为划分的片段数较少。

提示：
S的长度在[1, 500]之间。
S只包含小写字母 'a' 到 'z' 。
    * */

    //"ababcbacadefegdehijhklij"
    //"ababcbaca  defegde  hijhklij"
    public List<Integer> partitionLabels(String s) {
        List<Integer> ans = new ArrayList<>();
        int lastP = 0;
        int p = 1;
        Set<Character> set = new HashSet<>();
        while (p <= s.length()) {
            for (int i = lastP; i < p; i++) {
                char c = s.charAt(i);
                if (!set.contains(c)) {
                    int rightPosition = getRightPosition(s, c);
                    p = Math.max(p, rightPosition);
                    set.add(c);
                }
            }
            ans.add(p - lastP);
            lastP = p;
            p++;

        }
        return ans;
    }

    private int getRightPosition(String s, char c) {
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == c) {
                return i + 1;
            }
        }
        return 0;
    }

    //官方代码
    public List<Integer> partitionLabels2(String S) {
        int[] last = new int[26];
        int length = S.length();
        for (int i = 0; i < length; i++) {
            last[S.charAt(i) - 'a'] = i;
        }
        List<Integer> partition = new ArrayList<Integer>();
        int start = 0, end = 0;
        for (int i = 0; i < length; i++) {
            end = Math.max(end, last[S.charAt(i) - 'a']);
            if (i == end) {
                partition.add(end - start + 1);
                start = end + 1;
            }
        }
        return partition;
    }
}
