package com.payne.leetCode.p_s;

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

    //2021-02-24
    //马拉车算法
    public String longestPalindrome4(String s) {
        char space = '#';
        char header = '^';
        char tail = '$';
        StringBuilder sb = new StringBuilder();
        sb.append(header).append(space);
        int len = s.length();
        for (int i = 0; i < len; i++) {
            sb.append(s.charAt(i)).append(space);
        }
        sb.append(tail);
        String newS = sb.toString();

        int p[] = new int[newS.length()];
        int left, right, value;
        for (int i = 1; i < newS.length() - 1; i++) {
            left = i - 1;
            right = i + 1;
            value = 0;
            while (newS.charAt(left) != tail && newS.charAt(right) != tail
                    && newS.charAt(left) == newS.charAt(right)) {
                left--;
                right++;
                value++;
            }
            p[i - 1] = value;
        }

        int maxLen = 0;
        int start = 0;
        for (int i = 0; i < p.length; i++) {
            if (p[i] >= maxLen) {
                start = i;
                maxLen = p[i];
            }
        }
        start = (start - maxLen) / 2;
        return s.substring(start, start + maxLen);
    }

    //2021-02-24
    //中心扩散
    public String longestPalindrome3(String s) {
        if (s.length() <= 1) {
            return s;
        }
        String ans = "";
        for (int i = 0; i < s.length() - 1; i++) {
            ans = maxStr(ans, spread(s, i, false));
            ans = maxStr(ans, spread(s, i, true));
        }
        return ans;

    }

    private String maxStr(String s1, String s2) {
        if (s1.length() >= s2.length()) {
            return s1;
        }
        return s2;
    }

    private String spread(String s, int center, boolean even) {
        int left = center;
        int right = center;
        if (even) {
            right = center + 1;
        }
        while (left >= 0 && right < s.length()) {
            if (s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
            } else {
                break;
            }
        }
        return s.substring(left + 1, right);
    }

    //2021-02-24
    //动态规划
    public String longestPalindrome2(String s) {
        int len = s.length();
        if (len <= 1) {
            return s;
        }

        //pass[i][j] 表示s的子串 [i,j]是否是回文
        //状态转移方程 pass[i][j]= s[i]==s[j] && pass[i+1][j-1]
        boolean[][] pass = new boolean[len][len];
        char[] chars = s.toCharArray();
        int start = 0;
        int maxLen = 1;
        for (int i = 0; i < len; i++) {
            pass[i][i] = true;
        }

        for (int j = 1; j < len; j++) {
            for (int i = 0; i < j; i++) {
                if (chars[i] != chars[j]) {
                    pass[i][j] = false;
                } else {
                    if (j - i <= 2) {
                        pass[i][j] = true;
                    } else {
                        //外层循环是j++，所以在此之前，一定已经给pass[0到j][j-1]赋值了
                        pass[i][j] = pass[i + 1][j - 1];
                    }
                }

                if (pass[i][j] && j - i + 1 > maxLen) {
                    start = i;
                    maxLen = j - i + 1;
                }
            }
        }
        return s.substring(start, start + maxLen);
    }

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
