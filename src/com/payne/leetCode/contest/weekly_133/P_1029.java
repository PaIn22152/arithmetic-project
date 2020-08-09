package com.payne.leetCode.contest.weekly_133;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class P_1029 {

    public class Cost {
        int diff;
        boolean positive;
        int aCost;
        int bCost;

        public Cost(int diff, boolean positive, int aCost, int bCost) {
            this.diff = diff;
            this.positive = positive;
            this.aCost = aCost;
            this.bCost = bCost;
        }
    }

    public int twoCitySchedCost(int[][] costs) {
        List<Cost> costList = new ArrayList<>();
        int num = 0;
        for (int i = 0; i < costs.length; i++) {
            int diff = costs[i][0] - costs[i][1];
            costList.add(new Cost(diff, diff >= 0, costs[i][0], costs[i][1]));
            if (diff >= 0) {
                num++;
            } else {
                num--;
            }
        }
        Collections.sort(costList, Comparator.comparingInt(o -> Math.abs(o.diff)));
        int numAbs = Math.abs(num) / 2;
        for (int i = 0; i < costList.size(); i++) {

            if (numAbs > 0) {
                if (num > 0) {
                    if (costList.get(i).positive) {
                        costList.get(i).positive = false;
                        numAbs--;
                    }
                } else {
                    if (!costList.get(i).positive) {
                        costList.get(i).positive = true;
                        numAbs--;
                    }
                }
            }

        }
        int total = 0;
        for (int i = 0; i < costList.size(); i++) {
            if (costList.get(i).positive) {
                total += costList.get(i).bCost;
            } else {
                total += costList.get(i).aCost;
            }
        }
        return total;

    }
}
