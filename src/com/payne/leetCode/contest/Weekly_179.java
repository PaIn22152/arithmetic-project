package com.payne.leetCode.contest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Project    arithmetic-project-git
 * Path       com.payne.leetCode.contest
 * Date       2020/03/09 - 10:09
 * Author     Payne.
 * About      类描述：
 */

public class Weekly_179 {

    public String generateTheString(int n) {
        StringBuilder sb = new StringBuilder();
        if (n % 2 == 0) {
            sb.append("x");
            n--;
        }
        for (int i = 0; i < n; i++) {
            sb.append("y");
        }
        return sb.toString();
    }


    //[2,1,3,5,4]
    //1,2,4     [0,n-1]
    public int numTimesAllBlue(int[] light) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < light.length; i++) {
            map.put(light[i], i);
        }
        int res = 0;
        for (int i = 0; i < light.length; i++) {
            light[map.get(i)] = 0;
            if (isAllBlue(light)) {
                res++;
            }
        }
        return res;
    }

    private boolean isAllBlue(int[] light) {
        if (light[0] != 0) {
            return false;
        }
        boolean off = false;
        for (int i = 1; i < light.length; i++) {
            if (light[i] == 0 && off) {
                return false;
            }
            if (light[i] != 0) {
                off = true;
            }
        }
        return true;
    }
}
