package com.payne.leetCode.p_s;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by payne on 2017-12-21.
 * About 类描述：
 * Given a string, find the length of the longest substring without repeating characters.
 * Examples:
 * Given "abcabcbb", the answer is "abc", which the length is 3.
 * Given "bbbbb", the answer is "b", with the length of 1.
 * Given "pweywkwwwuew", the answer is "wke", with the length of 3.
 * Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */
public class P_3_LongestSubstring {


    // "jxdlnaaij"
    public int lengthOfLongestSubstring2(String s) {
        if(s==null||s.length()==0){
            return 0;
        }
        int left = 0, right = s.length() - 1;
        while (true) {
            String sub = s.substring(left, right + 1);
            int i = isValid(sub);
            if (i == 0) {
                return sub.length();
            } else if (i > 0) {
                left += i;
            } else {
                right += i;
            }
        }
    }

    /**
     * 如果字符串没有重复，返回0，如果移动左边，返回+n，如果移动右边，返回-n
     */
    private int isValid(String s) {
        if (s.substring(1).contains(s.substring(0, 1))) {
            return 1;
        }
        if (s.substring(0, s.length() - 1).contains(s.substring(s.length() - 1))) {
            return -1;
        }
        if (isValid2(s)) {
            return 0;
        } else {
            int i = isValid(s.substring(1, s.length() - 1));
            if (i < 0) {
                return i - 1;
            } else return i + 1;
        }
    }

    private boolean isValid2(String s) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (set.contains(c)) {
                return false;
            } else {
                set.add(c);
            }
        }
        return true;
    }

    public int lengthOfLongestSubstring(String s) {
        return f1(s);
        //return f2(s);
        //return f3(s);
        //return my(s);

    }

    //pwwkew
    public int f1(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        HashMap<Character, Integer> map = new HashMap<>();
        int max = 0;
        for (int i = 0, j = 0; i < s.length(); ++i) {
            if (map.containsKey(s.charAt(i))) {
                j = Math.max(j, map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i), i);
            max = Math.max(max, i - j + 1);
        }
        return max;
    }

    public int f2(String s) {
        int i = 0, j = 0, max = 0;
        Set<Character> set = new HashSet<>();

        while (j < s.length()) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                max = Math.max(max, set.size());
            } else {
                set.remove(s.charAt(i++));
            }
        }

        return max;
    }

    public int f3(String s) {
        int[] map = new int[256]; // map from character's ASCII to its last occured index

        int j = 0;
        int i = 0;
        int ans = 0;
        for (i = 0; i < s.length(); i++) {
            while (j < s.length() && map[s.charAt(j)] == 0) {
                map[s.charAt(j)] = 1;
                ans = Math.max(ans, j - i + 1);
                j++;
            }
            map[s.charAt(i)] = 0;
        }

        return ans;
    }

    public int my(String s) {
        int longest = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.length() - i <= longest) {
                return longest;
            }
            int subLength = getWithoutRepeatingLength(s.substring(i));
            longest = subLength > longest ? subLength : longest;
        }
        return longest;

    }


    public int getWithoutRepeatingLength(String s) {

        StringBuffer sb = new StringBuffer();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            String c = String.valueOf(chars[i]);
            String subs = sb.toString();
            if (!subs.contains(c)) {
                sb.append(c);
            } else {
                return subs.length();
            }
        }
        return sb.toString().length();
    }

}
