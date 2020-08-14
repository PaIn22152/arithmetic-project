package com.payne.leetCode.p_s;

/**
 * Project    arithmetic-project-git
 * Path       com.payne.leetCode
 * Date       2018/11/12 - 16:17
 * Author     Payne.
 * About      类描述：
 */

public class P_14_LongestCommonPrefix {
    /**
     * https://leetcode.com/problems/longest-common-prefix/description/
     * <p_old>
     * Write a function to find the longest common prefix string amongst an array of strings.
     * <p_old>
     * If there is no common prefix, return an empty string "".
     * <p_old>
     * Example 1:
     * <p_old>
     * Input: ["flower","flow","flight"]
     * Output: "fl"
     * Example 2:
     * <p_old>
     * Input: ["dog","racecar","car"]
     * Output: ""
     * Explanation: There is no common prefix among the input strings.
     */

    public String longestCommonPrefix(String[] strs) {
        return my(strs);
    }

    public String my(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }
        String result = strs[0];
        for (int i = 1; i < strs.length; i++) {
            for (int j = result.length(); j >= 0; j--) {
                if (strs[i].startsWith(result.substring(0, j))) {
                    break;
                } else {
                    result = result.substring(0, j - 1);
                }
                if ("".equals(result)) {
                    return "";
                }
            }
        }
        return result;

    }
}
