package com.payne.leetCode.contest.weekly_123;

import com.payne.utils.PrintHelper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Project    arithmetic-project-git
 * Path       com.payne.leetCode.contest.weekly_123
 * Date       2019/02/13 - 14:20
 * Author     Payne.
 * About      类描述：
 */

public class P_989 {

    /**
     * https://leetcode.com/contest/weekly-contest-123/problems/add-to-array-form-of-integer/
     */

    public List<Integer> addToArrayForm(int[] A, int K) {
        String ks = K + "";

        StringBuilder asBuilder = new StringBuilder();
        for (int aA : A) {
            asBuilder.append(aA);
        }
        String as = asBuilder.toString();

        String zero;
        int zn = ks.length() - as.length() >= 0 ? ks.length() - as.length() : as.length() - ks.length();
        StringBuilder zeroBuilder = new StringBuilder();
        for (int i = 0; i < zn; i++) {
            zeroBuilder.append("0");
        }
        zero = zeroBuilder.toString();

        if (ks.length() > as.length()) {
            as = zero + as;
        } else {
            ks = zero + ks;
        }

        List<Integer> res = new ArrayList<>();
        boolean carry = false;
        for (int i = ks.length() - 1; i >= 0; i--) {
            int num = Integer.parseInt(ks.substring(i, i + 1)) + Integer.parseInt(as.substring(i, i + 1));
            if (carry) {
                num++;
            }
            carry = num >= 10;
            if (carry) {
                num -= 10;
            }
            res.add(num);
        }
        if (carry) {
            res.add(1);
        }

        Collections.reverse(res);
        return res;
    }

}
