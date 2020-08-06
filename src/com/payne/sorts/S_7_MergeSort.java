package com.payne.sorts;

import java.util.ArrayList;
import java.util.List;

/**
 * Author:  Payne
 * Date:  2018/1/1
 * About:归并排序（Merge Sort）
 * 基本思想：
 * 归并（Merge）排序法是将两个（或两个以上）有序表合并成一个新的有序表，
 * 即把待排序序列分为若干个子序列，每个子序列是有序的。然后再把有序子序列合并为整体有序序列。
 * 设r[i…n]由两个有序子表r[i…m]和r[m+1…n]组成，两个子表长度分别为n-i +1、n-m。
 * j=m+1；k=i；i=i; //置两个子表的起始下标及辅助数组的起始下标
 * 若i>m 或j>n，转⑷ //其中一个子表已合并完，比较选取结束
 * //选取r[i]和r[j]较小的存入辅助数组rf
 * 如果r[i]<r[j]，rf[k]=r[i]； i++； k++； 转⑵
 * 否则，rf[k]=r[j]； j++； k++； 转⑵
 * //将尚未处理完的子表中元素存入rf
 * 如果i<=m，将r[i…m]存入rf[k…n] //前一子表非空
 * 如果j<=n ,  将r[j…n] 存入rf[k…n] //后一子表非空
 * 合并结束。
 */
public class S_7_MergeSort {



    //
    public List<Integer> sort(List<Integer> list) {
        if (list == null || list.size() == 1) {
            return list;
        }
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (i < list.size() / 2) {
                left.add(list.get(i));
            } else {
                right.add(list.get(i));
            }
        }
        return merge(sort(left), sort(right));
    }

    public List<Integer> merge(List<Integer> l1, List<Integer> l2) {
        int p1 = 0, p2 = 0;
        List<Integer> mer = new ArrayList<>();
        while (p1 < l1.size() || p2 < l2.size()) {
            if (p1 < l1.size() && p2 < l2.size()) {
                if (l1.get(p1) < l2.get(p2)) {
                    mer.add(l1.get(p1));
                    p1++;
                } else {
                    mer.add(l2.get(p2));
                    p2++;
                }
            } else if (p1 < l1.size()) {
                mer.add(l1.get(p1));
                p1++;
            } else if (p2 < l2.size()) {
                mer.add(l2.get(p2));
                p2++;
            }
        }
        return mer;
    }


    //归并排序
    public int[] sortArray(int[] nums) {
        if (nums.length == 1) {
            return nums;
        }
        int[] left = new int[nums.length / 2];
        int[] right = new int[nums.length - nums.length / 2];
        int pl = 0;
        int pr = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i < nums.length / 2) {
                left[pl++] = nums[i];
            } else {
                right[pr++] = nums[i];
            }
        }
        return merge2(sortArray(left), sortArray(right));
    }


    public int[] merge2(int[] l1, int[] l2) {
        int p1 = 0, p2 = 0;
        int[] mer = new int[l1.length + l2.length];
        int p = 0;
        while (p1 < l1.length || p2 < l2.length) {
            if (p1 < l1.length && p2 < l2.length) {
                if (l1[p1] < l2[p2]) {
                    mer[p++] = l1[p1];
                    p1++;
                } else {
                    mer[p++] = l2[p2];
                    p2++;
                }
            } else if (p1 < l1.length) {
                mer[p++] = l1[p1];
                p1++;
            } else if (p2 < l2.length) {
                mer[p++] = l2[p2];
                p2++;
            }
        }
        return mer;
    }

}
