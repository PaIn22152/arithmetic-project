package com.payne.leetCode.contest.weekly_127;

import java.util.ArrayList;
import java.util.List;

/**
 * Project    arithmetic-project-git
 * Path       com.payne.leetCode.contest.weekly_127
 * Date       2019/03/11 - 19:58
 * Author     Payne.
 * About      类描述：
 */

public class P_1006 {

    /**
     * https://leetcode.com/contest/weekly-contest-127/problems/clumsy-factorial/
     */

    private static final String MUL = "*";
    private static final String DIV = "/";
    private static final String ADD = "+";
    private static final String SUB = "-";

    public int clumsy(int N) {
        String formula = "";
        List<String> operator = new ArrayList<>();
        operator.add(MUL);
        operator.add(DIV);
        operator.add(ADD);
        operator.add(SUB);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            if (i < N - 1) {
                sb.append(N - i).append(operator.get(i % 4));
            } else {
                sb.append(N - i);
            }
        }
        return calculate(sb.toString());
    }


    /**
     * 10 * 9 / 8 + 7 - 6 * 5 / 4 + 3 - 2 * 1
     * multiply (*), divide (/), add (+) and subtract (-)
     */
    private int calculate(String formula) {

        int num1;
        int num2;
        if (formula.contains(MUL) || formula.contains(DIV)) {
            int lastPos=0;
            for (int i = 0; i < formula.length(); i++) {
                if (isOperator(formula.substring(i, i + 1))) {
                    int num=Integer.parseInt(formula.substring(lastPos,i-lastPos));
                    lastPos=num;
                }
            }
        } else if (formula.contains(ADD) || formula.contains(SUB)) {

        }
return 0;
    }

    private boolean isOperator(String s) {
        return s.length() == 1 && (MUL.equals(s) || DIV.equals(s) || ADD.equals(s) || SUB.equals(s));
    }

}
