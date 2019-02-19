package com.payne.leetCode.contest.weekly_118;

import com.payne.utils.PrintHelper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Project    arithmetic-project-git
 * Path       com.payne.leetCode.contest.weekly_118
 * Date       2019/01/07 - 15:47
 * Author     Payne.
 * About      类描述：
 */

public class P_970 {

    /**
     * https://leetcode.com/contest/weekly-contest-118/problems/powerful-integers/
     * <p>
     * Given two non-negative integers x and y, an integer is powerful if it is equal
     * to x^i + y^j for some integers i >= 0 and j >= 0.
     * Return a list of all powerful integers that have value less than or equal to bound.
     * You may return the answer in any order.  In your answer, each value should occur at most once.
     * <p>
     * Example 1:
     * Input: x = 2, y = 3, bound = 10
     * Output: [2,3,4,5,7,9,10]
     * Explanation:
     * 2 = 2^0 + 3^0
     * 3 = 2^1 + 3^0
     * 4 = 2^0 + 3^1
     * 5 = 2^1 + 3^1
     * 7 = 2^2 + 3^1
     * 9 = 2^3 + 3^0
     * 10 = 2^0 + 3^2
     * <p>
     * Note:
     * 1 <= x <= 100
     * 1 <= y <= 100
     * 0 <= bound <= 10^6
     */

    public List<Integer> powerfulIntegers(int x, int y, int bound) {

        Map<Integer, Integer> resMap = new HashMap<>();

        int i = 0;
        int j = 0;
        int n1 = 0;
        int n2 = 0;
        int max = 24;
        for (int k = 0; k <= 24; k++) {
            if (Math.pow(2, k) > bound) {
                max = k;
                break;
            }
        }

        while (true) {
            if (i > max) {
                break;
            }
            n1 = (int) Math.pow(x, i);
            if (n1 < bound) {
                while (true) {
                    if (j > max) {
                        i++;
                        j = 0;
                        break;
                    }
                    n2 = (int) Math.pow(y, j++);
                    if (n2 < bound) {
                        int n = n1 + n2;
                        if (n <= bound) {
                            resMap.put(n, n);
                        }
                    } else {
                        i++;
                        j = 0;
                        break;
                    }
                }

            } else {
                break;
            }
        }


        List<Integer> resList = new ArrayList<>();
        for (Map.Entry<Integer, Integer> tem : resMap.entrySet()) {
            resList.add(tem.getKey());
        }
        return resList;
    }
}
