package com.payne.leetCode.solutions;

import java.util.*;

public class P_15 {


    //解法1
    //算法原理，排序，遍历，双指针，使用HashSet去重
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        Set<List<Integer>> map = new HashSet<>();
        if (nums.length < 3) {
            return res;
        }

        int last = nums[0];
        for (int i = 0; i < nums.length; i++) {
            int leftP = i + 1;
            int rightP = nums.length - 1;
            if (i > 0 && nums[i] == last) {
                continue;
            }
            last = nums[i];
            while (leftP < rightP) {
                int sum = nums[i] + nums[leftP] + nums[rightP];
                if (sum == 0) {
                    ArrayList<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[leftP]);
                    list.add(nums[rightP]);
                    if (!map.contains(list)) {
                        res.add(list);
                        map.add(list);
                    }
                    leftP++;
                    rightP--;
                } else if (sum < 0) {
                    leftP++;
                } else if (sum > 0) {
                    rightP--;
                }
            }
        }
        return res;
    }

    //解法2
    //算法原理同1，通过逻辑判断去重
    public List<List<Integer>> threeSum2(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length < 3) {
            return res;
        }

        int last = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {//当三个数中最小的一个大于0时，三数和一定大于0，结束循环
                break;
            }
            int leftP = i + 1;
            int rightP = nums.length - 1;
            if (i > 0 && nums[i] == last) {
                continue;
            }
            last = nums[i];

            while (leftP < rightP) {
                int sum = nums[i] + nums[leftP] + nums[rightP];
                if (sum == 0) {
                    ArrayList<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[leftP]);
                    list.add(nums[rightP]);
                    res.add(list);

                    while (leftP < rightP && nums[leftP] == nums[leftP + 1]) {
                        leftP++;
                    }
                    while (leftP < rightP && nums[rightP] == nums[rightP - 1]) {
                        rightP--;
                    }
                    leftP++;
                    rightP--;
                } else if (sum < 0) {
                    leftP++;
                } else if (sum > 0) {
                    rightP--;
                }
            }
        }
        return res;
    }
}
