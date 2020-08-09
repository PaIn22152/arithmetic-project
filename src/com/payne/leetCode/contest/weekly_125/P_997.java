package com.payne.leetCode.contest.weekly_125;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Project    arithmetic-project-git
 * Path       com.payne.leetCode.contest.weekly_125
 * Date       2019/02/25 - 09:51
 * Author     Payne.
 * About      类描述：
 */

public class P_997 {

    /**
     * https://leetcode.com/contest/weekly-contest-125/problems/find-the-town-judge/
     */


    public int findJudge(int N, int[][] trust) {
        Map<String, String> map = new HashMap<>();//
        List<Integer> list = new ArrayList<>();//

        for (int i = 0; i < N; i++) {
            list.add(i + 1);
        }
        for (int i = 0; i < trust.length; i++) {
            int a = trust[i][0];
            int b = trust[i][1];
            list.remove(a - 1);
            if (map.containsKey(trust[i][1])) {
                String old = map.get(trust[i][1]);
                old += i;
                map.put((b - 1) + "", old);
            } else {
                map.put((b - 1) + "", (b - 1) + "");
            }
        }
        if (list.size() != 1) {
            return -1;
        }
        if (map.get(list.get(0) + "").length() != N - 1) {
            return -1;
        }
        return list.get(0) + 1;

    }

}
