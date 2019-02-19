package com.payne.leetCode.contest.weekly_124;

import java.util.HashSet;
import java.util.Set;

/**
 * Project    arithmetic-project-git
 * Path       com.payne.leetCode.contest.weekly_124
 * Date       2019/02/18 - 09:52
 * Author     Payne.
 * About      类描述：
 */

public class P_996 {
    /**
     *https://leetcode.com/contest/weekly-contest-124/problems/number-of-squareful-arrays/
     * */

    public int numSquarefulPerms(int[] A) {
        ans = 0;
        dfs(A, 0);
        return ans;
    }

    int ans = 0;

    public void dfs(int[] A, int k) {
        int n = A.length;
        if (k == n) {
            ans++;
        } else {
            Set<Integer> set = new HashSet<>();
            for (int i = k; i < n; i++) {
                if ((k == 0 || sq(A[k - 1] + A[i])) && !set.contains(A[i])) {
                    set.add(A[i]);
                    swap(A, k, i);
                    dfs(A, k + 1);
                    swap(A, k, i);
                }
            }
        }
    }

    public boolean sq(int n) {
        int r = (int) Math.sqrt(n);
        return r * r == n;
    }

    public void swap(int[] A, int i, int j) {
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }
}
