package com.payne.leetCode.solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P_16 {


    //解法1
    //算法原理,暴力遍历所有三数和

    int mSum = 0;//三数之和
    int mDiff = Integer.MAX_VALUE;//三数和与target的差的绝对值


    public int threeSumClosest2(int[] nums, int target) {
        Arrays.sort(nums);

        ArrayList input = new ArrayList<>();
        for (int i : nums) {
            input.add(i);
        }
        while (input.size() >= 3) {
            input = cal(input, target);
        }

        return mSum;

    }

    private ArrayList<Integer> cal(ArrayList<Integer> input, int target) {
        int start = input.get(0);
        ArrayList<Integer> subList = new ArrayList<>();
        for (int i = 1; i < input.size(); i++) {
            subList.add(input.get(i));
        }
        for (int i = 0; i < subList.size(); i++) {
            for (int j = i + 1; j < subList.size(); j++) {
                int sum = start + subList.get(i) + subList.get(j);
                int diff = Math.abs(target - sum);
                if (diff < mDiff) {
                    mSum = sum;
                    mDiff = diff;
                }
            }
        }
        return subList;
    }


    //解法2
    //算法原理，排序，双指针移动

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        ArrayList input = new ArrayList<>();
        for (int i : nums) {
            input.add(i);
        }
        while (input.size() >= 3) {
            input = move(input, target);
        }

        return mSum;

    }

    private ArrayList<Integer> move(List<Integer> input, int target) {
        int start = input.get(0);
        ArrayList<Integer> subList = new ArrayList<>();
        for (int i = 1; i < input.size(); i++) {
            subList.add(input.get(i));
        }
        int pointL = 0;
        int pointR = subList.size() - 1;
        while (pointL < pointR) {
            int sum = start + subList.get(pointL) + subList.get(pointR);
            int diff = Math.abs(sum - target);
            if (diff < mDiff) {
                mSum = sum;
                mDiff = diff;
            }
            if (sum == target) {
                mDiff = 0;
                mSum = sum;
                return subList;
            }
            if (sum < target) {
                pointL++;
            } else {
                pointR--;
            }

        }
        return subList;
    }


    //解法3
    //算法原理同2，代码写法优化

    public int threeSumClosest3(int[] nums, int target) {
        Arrays.sort(nums);
        int ans = nums[0] + nums[1] + nums[2];
        int diffTem = Integer.MAX_VALUE;//三数和与target的距离（绝对值）
        for (int i = 0; i < nums.length; i++) {
            int leftP = i + 1;
            int rightP = nums.length - 1;
            while (leftP < rightP) {
                int sum = nums[i] + nums[leftP] + nums[rightP];
                int diff = Math.abs(sum - target);
                if (diff == 0) {
                    return sum;
                }
                if (diff < diffTem) {
                    diffTem = diff;
                    ans = sum;
                }
                if (sum > target) {
                    rightP--;
                } else {
                    leftP++;
                }
            }
        }
        return ans;
    }


}
