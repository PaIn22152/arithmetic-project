package com.payne.leetCode.daily;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Project    arithmetic-project-git
 * Path       com.payne.leetCode.daily
 * Date       2020/08/07 - 09:46
 * Author     Payne.
 * About      类描述：
 */

class D_336 {

    /**
     * 给定一组 互不相同 的单词，
     * 找出所有不同 的索引对(i, j)，
     * 使得列表中的两个单词， words[i] + words[j] ，可拼接成回文串。
     * <p_old>
     * 示例 1：
     * 输入：["abcd","dcba","lls","s","sssll"]
     * 输出：[[0,1],[1,0],[3,2],[2,4]]
     * 解释：可拼接成的回文串为 ["dcbaabcd","abcddcba","slls","llssssll"]
     * <p_old>
     * 示例 2：
     * 输入：["bat","tab","cat"]
     * 输出：[[0,1],[1,0]]
     * 解释：可拼接成的回文串为 ["battab","tabbat"]
     * <p_old>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/palindrome-pairs
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */


    //双指针遍历   性能差，LeetCode超出时间限制
    public List<List<Integer>> palindromePairs(String[] words) {
        int left = 0, right = words.length - 1;
        List<List<Integer>> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        while (right > 0) {

            sb.delete(0, sb.length());
            sb.append(words[left]).append(words[right]);
            if (isPlalindrome(sb.toString())) {
                List<Integer> tem = new ArrayList<>();
                tem.add(left);
                tem.add(right);
                res.add(tem);
            }

            sb.delete(0, sb.length());
            sb.append(words[right]).append(words[left]);
            if (isPlalindrome(sb.toString())) {
                List<Integer> tem = new ArrayList<>();
                tem.add(right);
                tem.add(left);
                res.add(tem);
            }

            left++;
            if (left >= right) {
                left = 0;
                right--;
            }
        }
        return res;
    }

    public boolean isPlalindrome(String s) {

        int len = s.length();
        for (int i = 0; i < len / 2; i++) {
            if (s.charAt(i) != s.charAt(len - 1 - i)) {
                return false;
            }
        }
        return true;
    }


    public List<List<Integer>> palindromePairs2(String[] words) {
        int left = 0, right = words.length - 1;
        List<List<Integer>> res = new ArrayList<>();
        while (right > 0) {

            if (isPlalindrome(words[left], words[right])) {
                List<Integer> tem = new ArrayList<>();
                tem.add(left);
                tem.add(right);
                res.add(tem);
            }

            if (isPlalindrome(words[right], words[left])) {
                List<Integer> tem = new ArrayList<>();
                tem.add(right);
                tem.add(left);
                res.add(tem);
            }

            left++;
            if (left >= right) {
                left = 0;
                right--;
            }
        }
        return res;
    }

    public boolean isPlalindrome(String s1, String s2) {
        int len = s1.length() + s2.length();
        for (int i = 0; i < len / 2; i++) {
            if (getChar(s1, s2, i) != getChar(s1, s2, len - 1 - i)) {
                return false;
            }
        }

        return true;
    }

    private char getChar(String s1, String s2, int i) {
        if (i < s1.length()) {
            return s1.charAt(i);
        } else return s2.charAt(i - s1.length());
    }


    //暴力求解
    public List<List<Integer>> palindromePairs3(String[] words) {
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if (isPlalindrome2(words[i], words[j])) {
                    List<Integer> tem = new ArrayList<>();
                    tem.add(i);
                    tem.add(j);
                    res.add(tem);
                }

                if (isPlalindrome2(words[j], words[i])) {
                    List<Integer> tem = new ArrayList<>();
                    tem.add(j);
                    tem.add(i);
                    res.add(tem);
                }
            }
        }
        return res;
    }


    public boolean isPlalindrome2(String s1, String s2) {
        int p1 = 0, p2 = s2.length() - 1;
        while (p1 < s1.length() || p2 >= 0) {
            if (p1 >= s1.length()) {
                return isPlalindrome(s2.substring(0, p2 + 1));
            }
            if (p2 < 0) {
                return isPlalindrome(s1.substring(p1));
            }
            if (s1.charAt(p1) != s2.charAt(p2)) {
                return false;
            }
            p1++;
            p2--;
        }

        return true;
    }

    public List<List<Integer>> palindromePairs4(String[] words) {
        List<List<Integer>> res = new ArrayList<>();
        Map<String, Integer> reverse = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            reverse.put(reverse(words[i]), i);
        }

        return res;
    }

    public String reverse(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            sb.append(s.charAt(i));
        }

        return sb.toString();
    }


    /**
     * 思考过程记录
     * 数组遍历两次是必须的操作，关键是怎么提升回文判断的效率
     *
     * 发现一个关键信息，所有单词互不相同，是否可以利用这点做优化
     *
     * s1+s2 是回文  有三种情况
     * 1. s1 与 s2 互为翻转
     * 2. s1=s2翻转+回文
     * 3. s2=回文+s1翻转
     *
     * 即(s1*表示s1翻转)
     * s1+s1*(s1翻转)
     * s1+（回文+s1*）
     * （s1*+回文）+s1
     *
     * 所以，如果s2满足下列情况，就可以和s1组成回文
     * 1. s2=s1*       （s1+s2   和  s2+s1）
     * 2. s2=回文+s1*  （s1+s2）
     * 3. s2=s1*+回文  （s2+s1*）
     * */
}
