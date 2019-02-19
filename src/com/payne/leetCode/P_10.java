package com.payne.leetCode;

import com.payne.utils.PrintHelper;

import java.util.HashMap;
import java.util.Map;

/**
 * Project    arithmetic-project-git
 * Path       com.payne.leetCode
 * Date       2019/01/04 - 12:22
 * Author     Payne.
 * About      类描述：
 */

public class P_10 {
    /**
     * https://leetcode.com/problems/regular-expression-matching/
     * <p>
     * Given an input string (s) and a pattern (p), implement regular expression matching with support for '.' and '*'.
     * '.' Matches any single character.
     * '*' Matches zero or more of the preceding element.
     * The matching should cover the entire input string (not partial).
     * <p>
     * Note:
     * s could be empty and contains only lowercase letters a-z.
     * p could be empty and contains only lowercase letters a-z, and characters like . or *.
     */

    private static final char DOT = '.';
    private static final char ASTERISK = '*';

    // the key is asterisk's position
    // the value is the preceding element to this asterisk
    private Map<Integer, Character> asteriskMap = new HashMap<>();

    //s could be empty and contains only lowercase letters a-z.
    //p could be empty and contains only lowercase letters a-z, and characters like . or *.
    public boolean isMatch(String s, String p) {
        initMap(p);
        PrintHelper.println(asteriskMap);
        return isMatchDot(s, p);
    }




    //s could be empty and contains only lowercase letters a-z.
    //p could be empty and contains only lowercase letters a-z, and characters like ..
    private boolean isMatchDot(String s, String p) {
        if (s.length() != p.length()) {
            return false;
        }
        for (int i = 0; i < s.length(); i++) {
            if (p.charAt(i) != DOT && p.charAt(i) != s.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    private void initMap(String p) {
        if (p.startsWith(ASTERISK + "")) {
            return;
        }
        for (int i = 1; i < p.toCharArray().length; i++) {
            if (p.toCharArray()[i] == ASTERISK) {
                asteriskMap.put(i, p.toCharArray()[i - 1]);
            }
        }
    }
}
