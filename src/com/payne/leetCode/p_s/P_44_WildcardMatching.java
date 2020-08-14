package com.payne.leetCode.p_s;

/**
 * Created by payne on 2018-01-03.
 * About 类描述：
 * Implement wildcard pattern matching with support for '?' and '*'.
 * '?' Matches any single character.
 * '*' Matches any sequence of characters (including the empty sequence).
 * The matching should cover the entire input string (not partial).
 * The function prototype should be:
 * bool isMatch(const char *s, const char *p_old)
 * Some examples:
 * isMatch("aa","a") → false
 * isMatch("aa","aa") → true
 * isMatch("aaa","aa") → false
 * isMatch("aa", "*") → true
 * isMatch("aa", "a*") → true
 * isMatch("ab", "?*") → true
 * isMatch("aab", "c*a*b") → false
 */
public class P_44_WildcardMatching {

    public boolean isMatch(String s, String p) {
        //return my(s, p_old);
        //return singleWildcard(s, p_old);
        //return oneSequenceWildcard(s, p_old);
        return sequenceWildcard(s, p);
        //return true;
    }

    //?通配符
    private boolean singleWildcard(String s, String p) {
        if (s.length() != p.length()) {
            return false;
        }
        for (int i = 0; i < s.length(); i++) {
            char cs = s.charAt(i);
            char cp = p.charAt(i);
            if (cp != '?' && cs != cp) {
                return false;
            }
        }
        return true;
    }

    private static final String sSequenceWildcard = "\\*";

    //裁剪后逐一对应
    private boolean sequenceWildcard(String s, String p) {
        String[] split = p.split(sSequenceWildcard);
        for (String temp : split) {
            System.out.println(" temp = " + temp);
        }

        //  abc *a*b*c
        boolean head = false;
        for (int i = 0; i < split.length; i++) {
            if ("".equals(split[i])) {
                head = true;
            } else if (!head && !"".equals(split[i])) {
                if (!s.startsWith(split[i])) {
                    return false;
                }
            } else if (!head && "".equals(split[i])) {

            }
        }

        return true;
    }

    //单个*通配符
    private boolean oneSequenceWildcard(String s, String p) {
        if (s.length() == p.length()) {
            return singleWildcard(s, p.replace('*', '?'));
        }
        if (s.length() < p.length()) {
            return false;
        }
        String newP = "";
        for (int i = 0; i < p.length(); i++) {
            char cp = p.charAt(i);
            if (cp == '*') {
                newP += "**";
            } else {
                newP += cp;
            }
        }
        if (newP.length() > p.length()) {
            return oneSequenceWildcard(s, newP);
        } else return false;


    }


    public boolean my(String s, String p) {
        if (s == null && p == null) {
            return true;
        }
        if (s == null || p == null) {
            return false;
        }
        if (s.equals(p)) {
            return true;
        }
        if (!containWildcard(s) && !containWildcard(p)) {
            return s.equals(p);
        }


        int length = s.length();
        int j = 0;
        for (int i = 0; i < length; i++) {
            if (p.length() <= j) {
                return false;
            }
            if (s.charAt(i) != p.charAt(j)
                    && p.charAt(j) != '*' && p.charAt(j) != '?') {
                return false;
            } else if (s.charAt(i) == p.charAt(j)) {
                j++;
            } else if (p.charAt(j) == '*') {

            } else if (p.charAt(j) == '?') {
                j++;
            }
        }

        return true;
    }

    public boolean containWildcard(String s) {
        return s.contains("*") || s.contains("?");
    }
}
