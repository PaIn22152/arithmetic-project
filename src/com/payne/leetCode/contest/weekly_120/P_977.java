package com.payne.leetCode.contest.weekly_120;

import java.util.Arrays;

/**
 * Project    arithmetic-project-git
 * Path       com.payne.leetCode.contest.weekly_120
 * Date       2019/01/24 - 10:11
 * Author     Payne.
 * About      类描述：
 */

public class P_977 {
    /**
     * https://leetcode.com/contest/weekly-contest-120/problems/squares-of-a-sorted-array/
     */

    public int[] sortedSquares(int[] A) {
        for (int i = 0; i < A.length; i++) {
            A[i] = A[i] * A[i];
        }
        Arrays.sort(A);
        return A;
    }
}
