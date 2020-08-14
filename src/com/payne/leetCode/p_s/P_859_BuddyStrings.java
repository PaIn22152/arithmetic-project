package com.payne.leetCode.p_s;

import java.util.HashMap;
import java.util.Map;

/**
 * Project    arithmetic-project-git
 * Path       com.payne.leetCode
 * Date       2018/09/17 - 17:14
 * Author     Payne.
 * About      类描述：
 */

public class P_859_BuddyStrings {
    /**
     * https://leetcode.com/problems/buddy-strings/description/
     * <p_old>
     * Given two strings A and B of lowercase letters,
     * return true if and only if we can swap two letters in A so that the result equals B.
     * Example 1:
     * Input: A = "ab", B = "ba"
     * Output: true
     * <p_old>
     * Example 2:
     * Input: A = "ab", B = "ab"
     * Output: false
     * <p_old>
     * Example 3:
     * Input: A = "aa", B = "aa"
     * Output: true
     * <p_old>
     * Example 4:
     * Input: A = "aaaaaaabc", B = "aaaaaaacb"
     * Output: true
     * <p_old>
     * Example 5:
     * Input: A = "", B = "aa"
     * Output: false
     * <p_old>
     * Note:
     * 0 <= A.length <= 20000
     * 0 <= B.length <= 20000
     * A and B consist only of lowercase letters.
     */

    public boolean buddyStrings(String A, String B) {
        return my(A, B);
    }

    private int p1 = 0;
    private int p2 = 0;

    public boolean my(String A, String B) {
        if (A == null || B == null) {
            return false;
        }
        if (A.length() != B.length()) {
            return false;
        }
        if (A.equals(B)) {
            return haveSimilarLetter(A);
        }
        if (!only2LettersDifferent(A, B)) {
            return false;
        }
        System.out.println(" A p1 = " + A.toCharArray()[p1]);
        System.out.println(" B p2 = " + B.toCharArray()[p2]);
        System.out.println(" A p2 = " + A.toCharArray()[p2]);
        System.out.println(" B p1 = " + B.toCharArray()[p1]);
        return A.toCharArray()[p1] == B.toCharArray()[p2] && A.toCharArray()[p2] == B.toCharArray()[p1];

    }


    private boolean haveSimilarLetter(String s) {
        Map<Character, Character> map = new HashMap<>();
        for (Character c : s.toCharArray()) {
            if (map.containsKey(c)) {
                return true;
            } else {
                map.put(c, c);
            }
        }
        return false;
    }

    private boolean only2LettersDifferent(String s1, String s2) {
        System.out.println("only2LettersDifferent  s1 = " + s1 + "; s2 = " + s2);
        int dif = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.toCharArray()[i] != s2.toCharArray()[i]) {
                dif++;
                if (dif == 1) {
                    p1 = i;
                }
                if (dif == 2) {
                    p2 = i;
                }
            }
            if (dif > 2) {
                return false;
            }
        }
        System.out.println("p1 = " + p1);
        System.out.println("p2 = " + p2);
        System.out.println("dif = " + dif);
        return dif == 2;
    }
}
