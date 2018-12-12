package com.payne.leetCode;

/**
 * Project    arithmetic-project-git
 * Path       com.payne.leetCode
 * Date       2018/08/30 - 17:28
 * Author     Payne.
 * About      类描述：
 */

public class P_479LargestPalindromeProduct {
    /**
     * https://leetcode.com/problems/largest-palindrome-product/description/
     * <p>
     * Find the largest palindrome made from the product of two n-digit numbers.
     * <p>
     * Since the result could be very large, you should return the largest palindrome mod 1337.
     * <p>
     * Example:
     * <p>
     * Input: 2
     * <p>
     * Output: 987
     * <p>
     * Explanation: 99 x 91 = 9009, 9009 % 1337 = 987
     * <p>
     * Note:
     * <p>
     * The range of n is [1,8].
     */

    public int largestPalindrome(int n) {
        return my(n);
    }

    public int my(int n) {
        StringBuilder maxString = new StringBuilder();
        for (int i = 0; i < n; i++) {
            maxString.append("9");
        }
        int max = Integer.parseInt(maxString.toString());
        return 21;
    }

    public boolean isPalindrome(String s) {
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length / 2; i++) {
            if (chars[i] != chars[chars.length - i - 1]) {
                return false;
            }
        }
        return true;
    }
}
