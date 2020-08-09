package com.payne.leetCode.contest.weekly_165;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Project    arithmetic-project-git
 * Path       com.payne.leetCode.contest.weekly_165
 * Date       2019/12/02 - 09:44
 * Author     Payne.
 * About      类描述：
 */

public class P_1275 {
    /**
     * https://leetcode.com/contest/weekly-contest-165/problems/find-winner-on-a-tic-tac-toe-game/
     */
    public String tictactoe(int[][] moves) {
        //Pending
        //Draw
        //A
        //B
        if (moves.length < 5) {
            return "Pending";
        }
        List<int[]> listA = new ArrayList<>();
        List<int[]> listB = new ArrayList<>();
        for (int i = 0; i < moves.length; i++) {
            if (i % 2 == 0) {
                listA.add(moves[i]);
            } else {
                listB.add(moves[i]);
            }
        }

        if (haveLine(listA) || haveDiagonal(listA)) {
            return "A";
        }
        if (haveLine(listB) || haveDiagonal(listB)) {
            return "B";
        }
        if (moves.length == 9) {
            return "Draw";
        }
        return "Pending";
    }

    private boolean haveLine(List<int[]> list) {

        if (list.size() < 3) {
            return false;
        }
        //行
        Map<Integer, Integer> mapRow = new HashMap<>();
        //列
        Map<Integer, Integer> mapColumn = new HashMap<>();
        for (int i = 0; i < list.size(); i++) {
            int x = list.get(i)[0];
            int y = list.get(i)[1];
            if (mapRow.containsKey(x)) {
                int r = mapRow.get(x);
                if (r == 2) {
                    return true;
                }
                mapRow.put(x, r + 1);
            } else {
                mapRow.put(x, 1);
            }
            if (mapColumn.containsKey(y)) {
                int r = mapColumn.get(y);
                if (r == 2) {
                    return true;
                }
                mapColumn.put(y, r + 1);
            } else {
                mapColumn.put(y, 1);
            }
        }
        return false;
    }

    private boolean haveDiagonal(List<int[]> list) {
        if (list.size() < 3) {
            return false;
        }
        int d1 = 3;
        int d2 = 3;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i)[0] == 0 && list.get(i)[1] == 0) {
                d1--;
            }
            if (list.get(i)[0] == 0 && list.get(i)[1] == 2) {
                d2--;
            }
            if (list.get(i)[0] == 1 && list.get(i)[1] == 1) {
                d1--;
                d2--;
            }
            if (list.get(i)[0] == 2 && list.get(i)[1] == 0) {
                d2--;
            }
            if (list.get(i)[0] == 2 && list.get(i)[1] == 2) {
                d1--;
            }
        }
        return d1 == 0 || d2 == 0;
    }
}
