package com.payne.leetCode.p_old;

/**
 * Project    arithmetic-project-git
 * Path       com.payne.leetCode
 * Date       2018/08/30 - 17:15
 * Author     Payne.
 * About      类描述：
 */

public class P_739DailyTemperatures {
    /**
     * https://leetcode.com/problems/daily-temperatures/description/
     * <p_old>
     * Given a list of daily temperatures, produce a list that, for each day in the input,
     * tells you how many days you would have to wait until a warmer temperature. If there is no
     * future day for which this is possible, put 0 instead.
     * <p_old>
     * For example, given the list temperatures = [73, 74, 75, 71, 69, 72, 76, 73], your output
     * should be [1, 1, 4, 2, 1, 1, 0, 0].
     * <p_old>
     * Note: The length of temperatures will be in the range [1, 30000]. Each temperature
     * will be an integer in the range [30, 100].
     */

    //用时8min48s
    public int[] dailyTemperatures(int[] temperatures) {
        return my(temperatures);
    }

    public int[] my(int[] temperatures) {
        int[] result = new int[temperatures.length];
        for (int i = 0; i < temperatures.length; i++) {
            result[i] = getDay(temperatures, i);
        }
        return result;
    }

    private int getDay(int[] temperatures, int position) {

        int day = 0;
        int start = temperatures[position];
        for (int i = position + 1; i < temperatures.length; i++) {
            day++;
            if (temperatures[i] > start) {
                return day;
            }
        }
        return 0;
    }
}
