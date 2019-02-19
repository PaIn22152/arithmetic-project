package com.payne.leetCode.contest.weekly_120;

import com.payne.utils.PrintHelper;

/**
 * Project    arithmetic-project-git
 * Path       com.payne.leetCode.contest.weekly_120
 * Date       2019/01/24 - 10:15
 * Author     Payne.
 * About      类描述：
 */

public class P_978 {
    /**
     * https://leetcode.com/contest/weekly-contest-120/problems/longest-turbulent-subarray/
     */

    public int maxTurbulenceSize(int[] A) {

        return my1(A);
    }


    //time limit exceeded
    private int my1(int[] A) {
        for (int i = A.length; i > 0; i--) {
            int[] Tem = new int[i];
            for (int n = 0; n < A.length + 1 - i; n++) {
                for (int j = 0; j < i; j++) {
                    Tem[j] = A[j + n];
                }
                if (isTurbulence(Tem)) {
                    return i;
                }

            }
        }
        return 0;
    }

    private boolean isTurbulence(int[] A) {
        if (A.length == 1) {
            return true;
        }
        if (A.length == 2) {
            return A[0] != A[1];
        }
        boolean greater = true;
        for (int i = 1; i < A.length; i++) {
            if (A[i - 1] == A[i]) {
                return false;
            }
            if (i == 1) {
                greater = A[i - 1] - A[i] > 0;
            } else {
                greater = !greater;
                if (greater != A[i - 1] - A[i] > 0) {
                    return false;
                }
            }
        }
        return true;
    }
}
