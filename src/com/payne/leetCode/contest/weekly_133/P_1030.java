package com.payne.leetCode.contest.weekly_133;

import java.util.ArrayList;
import java.util.List;

public class P_1030 {

    public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
        List<int[]> res = new ArrayList<>();
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                int[] is = new int[2];
                is[0] = i;
                is[1] = j;
                int des = getDis(is[0], is[1], r0, c0);
                if (res.size() == 0) {
                    res.add(is);
                } else {
                    for (int k = 0; k < res.size(); k++) {
                        int[] tem = res.get(k);
                        int desT = getDis(tem[0], tem[1], r0, c0);
                        if (des < desT) {
                            res.add(k, is);
                            break;
                        }
                        if (k == res.size() - 1) {
                            res.add(is);
                            break;
                        }
                    }
                }
            }
        }
        int[][] resA = new int[res.size()][2];
        for (int i = 0; i < res.size(); i++) {
            resA[i] = res.get(i);
        }
        return resA;

    }

    private int getDis(int r1, int c1, int r2, int c2) {
        return Math.abs(r1 - r2) + Math.abs(c1 - c2);
    }
}
