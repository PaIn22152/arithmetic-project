package com.payne.leetCode.daily;

/**
 * Project    arithmetic-project-git
 * Path       com.payne.leetCode.daily
 * Date       2020/08/24 - 10:02
 * Author     Payne.
 * About      类描述：
 */

public class D_459 {

    /**
     * 给定一个非空的字符串，判断它是否可以由它的一个子串重复多次构成。
     * 给定的字符串只含有小写英文字母，并且长度不超过10000。
     * <p>
     * 示例 1:
     * 输入: "abab"
     * 输出: True
     * 解释: 可由子字符串 "ab" 重复两次构成。
     * <p>
     * 示例 2:
     * 输入: "aba"
     * 输出: False
     * <p>
     * 示例 3:
     * 输入: "abcabcabcabc"
     * 输出: True
     * 解释: 可由子字符串 "abc" 重复四次构成。 (或者子字符串 "abcabc" 重复两次构成。)
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/repeated-substring-pattern
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */


    public boolean repeatedSubstringPattern(String s) {
        if (s == null || s.length() < 2) {
            return false;
        }
        for (int i = 1; i <= s.length() / 2; i++) {
            if (s.length() % i == 0) {
                int num = s.length() / i;
                String sub = s.substring(0, i);
                String tem = "";
                for (int j = 0; j < num; j++) {
                    tem += sub;
                }
                if (s.equals(tem)) {
                    return true;
                }
            }
        }
        return false;
    }


    public boolean repeatedSubstringPattern2(String s) {
        if (s == null || s.length() < 2) {
            return false;
        }
        for (int i = 1; i <= s.length() / 2; i++) {
            if (s.length() % i == 0) {
                String sub = s.substring(0, i);
                if (s.replace(sub, "").length() == 0) {
                    return true;
                }
            }
        }
        return false;
    }


    //官方代码
    public boolean repeatedSubstringPattern3(String s) {
        return (s + s).indexOf(s, 1) != s.length();
    }

}
