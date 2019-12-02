package com.payne.leetCode.contest.weekly_164;

import java.util.HashMap;
import java.util.Map;

/**
 * Project    arithmetic-project-git
 * Path       com.payne.leetCode.contest.weekly_164
 * Date       2019/11/26 - 15:20
 * Author     Payne.
 * About      类描述：
 */

public class P_1267 {
    /**
     * https://leetcode.com/contest/weekly-contest-164/problems/count-servers-that-communicate/
     */

    public int countServers(int[][] grid) {
        Map<Integer, Boolean> mapRow = new HashMap<>();//行
        Map<Integer, Boolean> mapColumn = new HashMap<>();//列
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    if (mapRow.containsKey(i)) {
                        mapRow.put(i, true);
                    } else {
                        mapRow.put(i, false);
                    }

                    if (mapColumn.containsKey(j)) {
                        mapColumn.put(j, true);
                    } else {
                        mapColumn.put(j, false);
                    }
                }
            }
        }

        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    if (mapRow.get(i)) {
                        res++;
                    } else if (mapColumn.get(j)) {
                        res++;
                    }
                }
            }
        }
        return res;
    }
}
