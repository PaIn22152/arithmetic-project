package com.payne;

import com.payne.leetCode.TreeNode;
import com.payne.leetCode.contest.DW_18;
import com.payne.leetCode.contest.Weekly_197;
import com.payne.leetCode.daily.*;
import com.payne.leetCode.p_s.P_130_SurroundedRegions;
import com.payne.leetCode.p_s.P_26_RemoveDuplicatesfromSortedArray;
import com.payne.leetCode.p_s.P_763;
import com.payne.leetCode.p_s.P_805;
import com.payne.leetCode.p_s.P_array;
import com.payne.leetCode.solutions.P_16;
import com.payne.leetCode.contest.Weekly_179;
import com.payne.leetCode.contest.weekly_165.P_1275;
import com.payne.leetCode.interview.Random1;
import com.payne.leetCode.interview.Random2;
import com.payne.leetCode.interview.Random3;
import com.payne.leetCode.p_s.P_148;
import com.payne.utils.PrintHelper;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static int roundToTimesOfFour(int value) {
        return (value + 3) & (~3);
    }

    private static void test() {

        d();
    }

    public static void d() {

    }

    public static boolean B = true;


    private static String getDay() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH");
        return simpleDateFormat.format(new java.util.Date());
    }

    private static void t(Object o) {
        PrintHelper.println(o instanceof Boolean);
    }

    public static void main(String[] args) {


        D_106 d_106 = new D_106();
        int[] i1 = new int[]{9, 3, 15, 20, 7};
        int[] i2 = new int[]{9, 15, 7, 20, 3};
        TreeNode treeNode = d_106.buildTree(i1, i2);
        d();


    }


}
