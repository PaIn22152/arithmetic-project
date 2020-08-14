package com.payne.leetCode.contest.weekly_114;

/**
 * Project    arithmetic-project-git
 * Path       com.payne.leetCode.contest.weekly_114
 * Date       2018/12/10 - 10:14
 * Author     Payne.
 * About      类描述：
 */

public class P_954_ArrayOfDoubledPairs {


    /**
     * https://leetcode.com/contest/weekly-contest-114/problems/array-of-doubled-pairs/
     * <p_old>
     * Given an array of integers A with even length, return true if and only if it is
     * possible to reorder it such that A[2 * i + 1] = 2 * A[2 * i] for every 0 <= i < len(A) / 2.
     * <p_old>
     * Example 1:
     * Input: [3,1,3,6]
     * Output: false
     * <p_old>
     * Example 2:
     * Input: [2,1,2,6]
     * Output: false
     * <p_old>
     * Example 3:
     * Input: [4,-2,2,-4]
     * Output: true
     * Explanation: We can take two groups, [-2,-4] and [2,4] to form [-2,-4,2,4] or [2,4,-2,-4].
     * <p_old>
     * Note:
     * 0 <= A.length <= 30000
     * A.length is even
     * -100000 <= A[i] <= 100000
     */

    public boolean canReorderDoubled(int[] A) {
        if (A.length == 0) {
            return true;
        }
        int[] newA = new int[A.length - 2];
        int start = A[0];
        boolean got = false;
        for (int i = 1; i < A.length; i++) {

            if (!got && (start * 2 == A[i] || A[i] * 2 == start)) {
                got = true;
                continue;
            }


            try {
                if (!got) {
                    newA[i - 1] = A[i];
                } else {
                    newA[i - 2] = A[i];
                }
            } catch (Exception e) {
                return false;
            }


        }
        if (!got) {
            return false;
        }
        if (A.length == 2) {
            return true;
        }
        return canReorderDoubled(newA);


    }


}
