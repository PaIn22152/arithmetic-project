package com.payne.leetCode.contest.weekly_127;

import java.util.Arrays;

/**
 * Project    arithmetic-project-git
 * Path       com.payne.leetCode.contest.weekly_127
 * Date       2019/03/11 - 18:48
 * Author     Payne.
 * About      类描述：
 */

public class P_1005 {
    /**
     * https://leetcode.com/contest/weekly-contest-127/problems/maximize-sum-of-array-after-k-negations/
     */

    public int largestSumAfterKNegations(int[] A, int K) {
        Arrays.sort(A);
        for (int i = 0; i < A.length; i++) {
            if (K <= 0) {
                break;
            } else {
                if (A[i] < 0) {
                    A[i] = -A[i];
                    K--;
                } else {
                    K = K % 2;
                    //k==0  or  k==1

                    break;
                }
            }
        }
        if (K > 0) {
            Arrays.sort(A);
            A[0] = -A[0];
        }
        int res = 0;
        for (int i : A) {
            res += i;
        }
        return res;
    }
}
