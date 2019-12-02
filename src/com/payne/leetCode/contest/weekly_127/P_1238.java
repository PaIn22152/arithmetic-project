package com.payne.leetCode.contest.weekly_127;

import java.util.ArrayList;
import java.util.List;

/**
 * Project    arithmetic-project-git
 * Path       com.payne.leetCode.contest.weekly_127
 * Date       2019/10/28 - 10:40
 * Author     Payne.
 * About      类描述：
 */

public class P_1238 {

    public List<Integer> circularPermutation(int n, int start) {
//        for(){
//
//        }
        return null;
    }

    public List<Integer> getValidNumber(int num, int len) {
        String s = Integer.toBinaryString(num);
        int zero = len - s.length();
        String header = "";
        for (int i = 0; i < zero; i++) {
            header += "0";
        }
        s = header + s;
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.toCharArray()[i];

        }
        return null;
    }

}
