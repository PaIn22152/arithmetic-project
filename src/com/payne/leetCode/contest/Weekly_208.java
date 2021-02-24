package com.payne.leetCode.contest;

import java.util.List;

/**
 * Project    arithmetic-project-git
 * Path       com.payne.leetCode.contest
 * Date       2020/09/27 - 10:15
 * Author     Payne.
 * About      类描述：
 */

class Weekly_208 {

    /*
     *https://leetcode-cn.com/contest/weekly-contest-208/problems/crawler-log-folder/
     * 5523. 文件夹操作日志搜集器
     * */

    public int minOperations(String[] logs) {
        int i = 0;
        for (String s : logs) {
            if ("../".equals(s)) {
                if (i > 0) {
                    i--;
                }
            } else if (!"../".equals(s) && !"./".equals(s)) {
                i++;
            }
        }
        return i;
    }


    /*
     *https://leetcode-cn.com/contest/weekly-contest-208/problems/maximum-profit-of-operating-a-centennial-wheel/
     * 5524. 经营摩天轮的最大利润
     * */
    public int minOperationsMaxProfit(int[] customers, int boardingCost, int runningCost) {
        int i = 0;
        int profit = 0;
        int last = 0;
        boolean have = false;
        while (true) {
            int num = last + customers[i];
            if (have) {

            }
        }
    }


    /*
     *https://leetcode-cn.com/contest/weekly-contest-208/problems/throne-inheritance/
     * 5525. 皇位继承顺序
     * */
    class ThroneInheritance {

        public ThroneInheritance(String kingName) {

        }

        public void birth(String parentName, String childName) {

        }

        public void death(String name) {

        }


    }


    /*
     *https://leetcode-cn.com/contest/weekly-contest-208/problems/maximum-number-of-achievable-transfer-requests/
     * 5526. 最多可达成的换楼请求数目
     * */
    /*
    * 3
[[0,0],[1,1],[0,0],[2,2],[1,1],[2,0],[2,1],[0,1],[0,1]]
    * */
    public int maximumRequests(int n, int[][] requests) {
        int[] arr = new int[n];
        int all = requests.length;
        for (int[] is : requests) {
            int from = is[0];
            int to = is[1];
            arr[from]--;
            arr[to]++;
        }
        int un = 0;
        for (int i : arr) {
            if (i > 0) {
                un += i;
            }
        }
        return all - un;
    }
}
