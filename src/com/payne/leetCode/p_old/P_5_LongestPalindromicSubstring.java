package com.payne.leetCode.p_old;

/**
 * Created by payne on 2018-01-02.
 * About 类描述：
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
 * Example:
 * Input: "babad"
 * Output: "bab"
 * Note: "aba" is also a valid answer.
 * Example:
 * Input: "cbbd"
 * Output: "bb"
 */
public class P_5_LongestPalindromicSubstring {

    public String longestPalindrome(String s) {
        //return my(s);
        //return f1(s);
        return my(s);
    }

    //private int num = 0;


    public String my(String s) {
        int len = s.length();
        for (int i = 0; i < len; i++) {
            int subNum = i + 1;
            int subLen = len - i;
            for (int j = 0; j < subNum; j++) {
                String subStr = s.substring(j, j + subLen);
                if (isPalindrome(subStr)) {
                    return subStr;
                }
            }
        }
        return "";
    }

    public boolean isPalindrome(String s) {
        int length = s.length();
        for (int i = 0; i < length / 2; i++) {
            if (s.charAt(i) != s.charAt(length - 1 - i)) {
                return false;
            }
        }
        return true;
    }


    private int lo, maxLen;

    public String f1(String s) {
        int len = s.length();
        if (len < 2)
            return s;

        for (int i = 0; i < len - 1; i++) {
            extendPalindrome(s, i, i);  //assume odd length, try to extend Palindrome as possible
            extendPalindrome(s, i, i + 1); //assume even length.

        }
        return s.substring(lo, lo + maxLen);
    }

    private void extendPalindrome(String s, int j, int k) {
        while (j >= 0 && k < s.length() && s.charAt(j) == s.charAt(k)) {
            j--;
            k++;
        }
        if (maxLen < k - j - 1) {
            lo = j + 1;
            maxLen = k - j - 1;
        }
    }


    public String f2(String s) {
        String res = "";
        int currLength = 0;
        for (int i = 0; i < s.length(); i++) {
            if (isPalindrome(s, i - currLength - 1, i)) {
                res = s.substring(i - currLength - 1, i + 1);
                currLength = currLength + 2;
            } else if (isPalindrome(s, i - currLength, i)) {
                res = s.substring(i - currLength, i + 1);
                currLength = currLength + 1;
            }
        }
        return res;
    }

    public boolean isPalindrome(String s, int begin, int end) {
        if (begin < 0) return false;
        while (begin < end) {
            if (s.charAt(begin++) != s.charAt(end--)) return false;
        }
        return true;
    }

}
