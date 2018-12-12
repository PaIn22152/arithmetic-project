package com.payne.leetCode.contest.weekly_114;

/**
 * Project    arithmetic-project-git
 * Path       com.payne.leetCode.contest.weekly_114
 * Date       2018/12/10 - 09:41
 * Author     Payne.
 * About      类描述：
 */

public class P_953_VerifyingAnAlienDictionary {

    /**
     * https://leetcode.com/contest/weekly-contest-114/problems/verifying-an-alien-dictionary/
     * <p>
     * In an alien language, surprisingly they also use english lowercase letters,
     * but possibly in a different order. The order of the alphabet is some permutation of lowercase letters.
     * <p>
     * Given a sequence of words written in the alien language, and the order of the alphabet,
     * return true if and only if the given words are sorted lexicographicaly in this alien language.
     * <p>
     * Example 1:
     * Input: words = ["hello","leetcode"], order = "hlabcdefgijkmnopqrstuvwxyz"
     * Output: true
     * Explanation: As 'h' comes before 'l' in this language, then the sequence is sorted.
     * Example 2:
     * <p>
     * Input: words = ["word","world","row"], order = "worldabcefghijkmnpqstuvxyz"
     * Output: false
     * Explanation: As 'd' comes after 'l' in this language, then words[0] > words[1],
     * hence the sequence is unsorted.
     * <p>
     * Note:
     * 1 <= words.length <= 100
     * 1 <= words[i].length <= 20
     * order.length == 26
     * All characters in words[i] and order are english lowercase letters.
     */


    public boolean isAlienSorted(String[] words, String order) {

        if (words.length == 1) {
            return true;
        }
        for (int i = 0; i < words.length - 1; i++) {
            if (!isSorted(words[i], words[i + 1], order)) {
                return false;
            }
        }
        return true;

    }

    private boolean isSorted(String front, String back, String order) {

        if (isSorted(front.charAt(0), back.charAt(0), order)) {
            if(front.charAt(0)!=back.charAt(0)){
                return true;
            }
            if (front.length() == 1) {
                return true;
            }
            if (back.length() == 1) {
                return false;
            }
            return isSorted(front.substring(1), back.substring(1), order);
        } else {
            return false;
        }


    }

    private boolean isSorted(char front, char back, String order) {
        if (front == back) {
            return true;
        }
        for (char tem : order.toCharArray()) {
            if (tem == front) {
                return true;
            }
            if (tem == back) {
                return false;
            }
        }
        return false;
    }
}
