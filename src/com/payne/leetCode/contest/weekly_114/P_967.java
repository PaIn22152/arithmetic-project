package com.payne.leetCode.contest.weekly_114;

import com.payne.utils.PrintHelper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Project    arithmetic-project-git
 * Path       com.payne.leetCode.contest.weekly_114
 * Date       2019/01/02 - 18:23
 * Author     Payne.
 * About      类描述：
 */

public class P_967 {
    public int[] numsSameConsecDiff(int N, int K) {
        List<Integer> possible = new ArrayList(Arrays.asList(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9}));
        if (N == 1) {
            possible.add(0);
            return from(possible);
        }

        return from(dfs(possible, N - 1, K));
    }

    public static List<Integer> dfs(List<Integer> last, int n, int k) {
        if (n == 0) {
            return last;
        }
        List<Integer> current = new ArrayList();
        for (Integer i : last) {
            int lastDigit = i % 10;
            if (lastDigit - k >= 0) {
                current.add(i * 10 + lastDigit - k);
            }
            if (lastDigit + k < 10 && k != 0) {
                current.add(i * 10 + lastDigit + k);
            }
        }
        return dfs(current, n - 1, k);
    }

    public static int[] from(List<Integer> list) {
        int n = list.size();
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = list.get(i);
        }
        return res;
    }


    public int[] numsSameConsecDiff2(int N, int K) {
        if (N == 1) {
            List<Integer> possible = new ArrayList(Arrays.asList(new Integer[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9}));
            return from(possible);
        }
        List<Integer> list = new ArrayList<>();

        int min = 1;
        for (int i = 0; i < N - 1; i++) {
            min *= 10;
        }

        int max = 9;
        for (int i = 0; i < N - 1; i++) {
            max *= 10;
            max += 9;
        }

        for (int i = min; i <= max; i++) {
            if (isSameConsecDiff(i, K)) {
                list.add(i);
            }
        }

        return from(list);
    }

    private boolean isSameConsecDiff(int i, int K) {
        String iS = i + "";
        for (int j = 0; j < iS.length() - 1; j++) {
            int n1 = iS.charAt(j);
            int n2 = iS.charAt(j + 1);
            if (!isDiff(n1, n2, K)) {
                return false;
            }
        }
        return true;
    }

    private boolean isDiff(int n1, int n2, int d) {
        return n1 - n2 == d || n2 - n1 == d;
    }
}
