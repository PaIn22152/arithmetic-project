package com.payne.leetCode.contest.weekly_114;

/**
 * Project    arithmetic-project-git
 * Path       com.payne.leetCode.contest.weekly_114
 * Date       2018/12/10 - 10:56
 * Author     Payne.
 * About      类描述：
 */

public class P_955_DeleteColumnsToMakeSortedII {

    /**
     * https://leetcode.com/contest/weekly-contest-114/problems/delete-columns-to-make-sorted-ii/
     * <p>
     * We are given an array A of N lowercase letter strings, all of the same length.
     * Now, we may choose any set of deletion indices, and for each string,
     * we delete all the characters in those indices.
     * For example, if we have an array A = ["abcdef","uvwxyz"] and deletion indices {0, 2, 3},
     * then the final array after deletions is ["bef","vyz"].
     * Suppose we chose a set of deletion indices D such that after deletions,
     * the final array has its elements in lexicographic order (A[0] <= A[1] <= A[2] ... <= A[A.length - 1]).
     * Return the minimum possible value of D.length.
     * <p>
     * Example 1:
     * Input: ["ca","bb","ac"]
     * Output: 1
     * Explanation:
     * After deleting the first column, A = ["a", "b", "c"].
     * Now A is in lexicographic order (ie. A[0] <= A[1] <= A[2]).
     * We require at least 1 deletion since initially A was not in lexicographic order, so the answer is 1.
     */

    public int minDeletionSize(String[] A) {
        String order = "abcdefghijklmnopqrstuvwxyz";
        if(isAlienSorted(A,order)){

        }
    }

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
