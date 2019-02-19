package com.payne.leetCode.contest.weekly_119;

import java.util.Arrays;

/**
 * Project    arithmetic-project-git
 * Path       com.payne.leetCode.contest.weekly_119
 * Date       2019/01/14 - 10:48
 * Author     Payne.
 * About      类描述：
 */

public class P_976 {

    /**
     * https://leetcode.com/contest/weekly-contest-119/problems/largest-perimeter-triangle/
     */

    public int largestPerimeter(int[] A) {
        Arrays.sort(A);

        for (int i = A.length - 1; i >= 2; i--) {
            if (A[i] < A[i - 1] + A[i - 2]) {
                return A[i] + A[i - 1] + A[i - 2];
            }
        }
        return 0;
    }
}
