package com.payne.leetCode.contest.weekly_119;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Project    arithmetic-project-git
 * Path       com.payne.leetCode.contest.weekly_119
 * Date       2019/01/14 - 14:18
 * Author     Payne.
 * About      类描述：
 */

class P_973 {

    /**
     * https://leetcode.com/contest/weekly-contest-119/problems/k-closest-points-to-origin/
     * */

    int distance(int[] a) {
        return a[0] * a[0] + a[1] * a[1];
    }

    public int[][] kClosest(int[][] points, int K) {
        Arrays.sort(points, (a, b) -> (distance(a) - distance(b)));

//        Arrays.sort(points, new Comparator<int[]>() {
//            @Override
//            public int compare(int[] o1, int[] o2) {
//                return distance(o1)-distance(o2);
//            }
//        });

        //Arrays.sort(points,(a,b)->(0));

        int[][] ans = new int[K][2];
        for (int i = 0; i < K; i++) {
            ans[i] = points[i];
        }
        return ans;
    }

}
