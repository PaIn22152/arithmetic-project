package com.payne.leetCode.contest.weekly_118;


import java.util.ArrayList;
import java.util.List;

/**
 * Project    arithmetic-project-git
 * Path       com.payne.leetCode.contest.weekly_118
 * Date       2019/01/07 - 10:42
 * Author     Payne.
 * About      类描述：
 */

public class P_969 {

    /**
     * https://leetcode.com/contest/weekly-contest-118/problems/pancake-sorting/
     * <p_old>
     * Given an array A, we can perform a pancake flip: We choose some positive
     * integer k <= A.length, then reverse the order of the first k elements of A.
     * We want to perform zero or more pancake flips (doing them one after another in succession)
     * to sort the array A.
     * <p_old>
     * Return the k-values corresponding to a sequence of pancake flips that sort A.
     * Any valid answer that sorts the array within 10 * A.length flips will be judged as correct.
     * <p_old>
     * Note:
     * 1 <= A.length <= 100
     * A[i] is a permutation of [1, 2, ..., A.length]
     * <p_old>
     * Example 1:
     * <p_old>
     * Input: [3,2,4,1]
     * Output: [4,2,4,3]
     * Explanation:
     * We perform 4 pancake flips, with k values 4, 2, 4, and 3.
     * Starting state: A = [3, 2, 4, 1]
     * After 1st flip (k=4): A = [1, 4, 2, 3]
     * After 2nd flip (k=2): A = [4, 1, 2, 3]
     * After 3rd flip (k=4): A = [3, 2, 1, 4]
     * After 4th flip (k=3): A = [1, 2, 3, 4], which is sorted.
     * <p_old>
     * 3241
     * 3
     * 4231
     * 4
     * 1324
     * 2
     * 3124
     * 3
     * 2134
     * 2
     * 1234
     */

    public List<Integer> pancakeSort(int[] A) {
        List<Integer> resList = new ArrayList<>();
        if (!isSorted(A)) {
            for (int i = A.length - 1; i >= 0; i--) {
                int maxPos = maxPos(A, i);
                if (maxPos != i) {
                    if (maxPos != 0) {
                        resList.add(maxPos + 1);
                        reverse(A, maxPos);
                    }

                    if (i != 0) {
                        resList.add(i + 1);
                        reverse(A, i);
                    }
                }
            }
        }
        return resList;
    }

    private int maxPos(int[] A, int pos) {
        int max = Integer.MIN_VALUE;
        int maxPos = 0;
        for (int i = 0; i <= pos; i++) {
            if (A[i] > max) {
                max = A[i];
                maxPos = i;
            }
        }
        return maxPos;
    }

    private void reverse(int[] A, int pos) {
        for (int i = 0; i < (pos + 1) / 2; i++) {
            int tem = A[i];
            A[i] = A[pos - i];
            A[pos - i] = tem;
        }
    }

    private boolean isSorted(int[] A) {
        for (int i = 0; i < A.length - 1; i++) {
            if (A[i] > A[i + 1]) {
                return false;
            }
        }
        return true;
    }

}
