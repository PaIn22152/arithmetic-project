package com.payne.leetCode.contest.weekly_167;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class P_5124 {

    /**
     * https://leetcode.com/contest/weekly-contest-167/problems/sequential-digits/
     */
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> res = new ArrayList<>();
        String tem = "";
        int temInt = 0;
        for (int left = 1; left < 9; left++) {
            tem = "" + left;
            for (int right = left + 1; right <= 9; right++) {
                tem += right;
                temInt = Integer.parseInt(tem);
                if (temInt >= low && temInt <= high) {
                    res.add(temInt);
                }
            }

        }
        Collections.sort(res);
        return res;
    }

}
