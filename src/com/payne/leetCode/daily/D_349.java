package com.payne.leetCode.daily;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Project    arithmetic-project-git
 * Path       com.payne.leetCode.daily
 * Date       2020/11/02 - 19:08
 * Author     Payne.
 * About      类描述：
 */

class D_349 {

    /*https://leetcode-cn.com/problems/intersection-of-two-arrays/
    * 349. 两个数组的交集
给定两个数组，编写一个函数来计算它们的交集。

示例 1：
输入：nums1 = [1,2,2,1], nums2 = [2,2]
输出：[2]

示例 2：
输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
输出：[9,4]

说明：
输出结果中的每个元素一定是唯一的。
我们可以不考虑输出结果的顺序。
    * */
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        for (int i : nums1) {
            set.add(i);
        }
        Set<Integer> ansSet = new HashSet<>();
        for (int i : nums2) {
            if (set.contains(i)) {
                ansSet.add(i);
            }
        }
        int[] ans = new int[ansSet.size()];
        int p = 0;
        for (int i : ansSet) {
            ans[p++] = i;
        }
        return ans;
    }

    //代码简洁一点，但效率不如以上
    public int[] intersection2(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        for (int i : nums1) {
            set.add(i);
        }
        Set<Integer> ansSet = new HashSet<>();
        for (int i : nums2) {
            if (set.contains(i)) {
                ansSet.add(i);
            }
        }
        return ansSet.stream().mapToInt(i->i).toArray();
    }
}
