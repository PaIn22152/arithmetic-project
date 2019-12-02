package com.payne.leetCode.p_s;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Project    arithmetic-project-git
 * Path       com.payne.leetCode
 * Date       2018/08/23 - 15:33
 * Author     Payne.
 * About      类描述：
 */

public class P_440_K_th_Smallest_in_Lexicographical_Order {

    /***
     * https://leetcode.com/problems/k-th-smallest-in-lexicographical-order/description/
     *
     * Given integers n and k, find the lexicographically k-th smallest integer in the range from 1 to n.
     *
     * Note: 1 ≤ k ≤ n ≤ 10的9次方.
     *
     * Example:
     *
     * Input:
     * n: 13   k: 2
     *
     * Output:
     * 10
     *
     * Explanation:
     * The lexicographical order is [1, 10, 11, 12, 13, 2, 3, 4, 5, 6, 7, 8, 9], so the second smallest number is 10.
     * */

    public int findKthNumber(int n, int k) {
        return my(n, k);

    }

    private List<Integer> orderList = null;
    //private Map<Integer,Integer> orderMap=null;

    //1,10,100,101,11,12,13,14,15,16,17,18,19,2,20,21  ...  88,89,9,90,91,92,93,94,95,96,97,98,99
    public int my(int n, int k) {
        List<Integer> tempList = new ArrayList<>();

        //orderMap=new HashMap<>();
        orderList = new ArrayList<>();
        int usedLength = 0;

        while (true) {

            if (usedLength == 0) {
                if (n > 9) {
                    tempList.clear();
                    for (int i = usedLength + 1; i < 10; i++) {
                        tempList.add(i);
                    }
                    orderList.addAll(tempList);
                    usedLength = 9;
                    point = 1;
                } else {
                    tempList.clear();
                    for (int i = usedLength + 1; i <= n; i++) {
                        tempList.add(i);
                    }
                    orderList.addAll(tempList);
                    break;
                }
            } else if (n - usedLength > 10) {
                tempList.clear();
                for (int i = usedLength + 1; i < usedLength + 1 + 10; i++) {
                    tempList.add(i);
                }
                add(tempList);
                usedLength += 10;
                point += 10;
                point += 1;
            } else if ((n - usedLength <= 10)) {
                tempList.clear();
                for (int i = usedLength + 1; i < usedLength + 1 + n - usedLength; i++) {
                    tempList.add(i);
                }
                add(tempList);
                break;
            }
        }

        //System.out.println(orderList);
        return orderList.get(k - 1);

    }

    int num = 0;
    private int point = 0;

    private int getPoint(int point) {
        if (point > orderList.size()) {
            return getPoint(point - orderList.size()+1);
        }
        return point;
    }

    private void add(List<Integer> tempList) {
        if (tempList.size() > 0) {
            int last = tempList.get(0) / 10;
            point = getPoint(point);
            int p=0;
            for (int i = 0; i < orderList.size(); i++) {
                if (orderList.get(i) - last == 0) {
                    p = i + 1;
                    break;
                }
            }
            orderList.addAll(p, tempList);
            //orderList.addAll(point, tempList);
        }

    }

}
