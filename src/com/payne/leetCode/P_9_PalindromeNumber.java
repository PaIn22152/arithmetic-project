package com.payne.leetCode;

/**
 * Project    arithmetic-project-git
 * Path       com.payne.leetCode
 * Date       2018/11/08 - 16:49
 * Author     Payne.
 * About      类描述：
 */

public class P_9_PalindromeNumber {
    /**
     * https://leetcode.com/problems/palindrome-number/description/
     * <p>
     * Determine whether an integer is a palindrome.
     * An integer is a palindrome when it reads the same backward as forward.
     */

    public boolean isPalindrome(int x) {
        return my(x);
    }

    public boolean my(int x) {
        if (x < 0) {
            return false;
        }
        if (x < 10) {
            return true;
        }
        String s = String.valueOf(x);
        int len = s.length();
        for (int i = 0; i < len / 2; i++) {
            if (s.charAt(i) != s.charAt(len - 1 - i)) {
                return false;
            }
        }
        return true;
    }
}
