package com.payne.leetCode.contest.weekly_167;

import java.util.*;

public class P_5285 {

    /**
     * https://leetcode.com/contest/weekly-contest-167/problems/maximum-side-length-of-a-square-with-sum-less-than-or-equal-to-threshold/
     */

//    public int maxSideLength(int[][] mat, int threshold) {
//
//    }
    public int findNumbers(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if ((nums[i] + "").length() % 2 == 0) {
                res++;
            }
        }
        return res;

    }


    public boolean isPossibleDivide(int[] nums, int k) {
        int len = nums.length;
        if (len % k != 0) {
            return false;
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            list.add(nums[i]);
        }
        Collections.sort(list);
        int max = list.size() / k;
        int index = 0;
        for (int i = 0; i < max; i++) {
            if (list.size() > 0) {
                index = list.get(0);
            }
            for (int j = 0; j < k; j++) {
                if (!haveAndRemove(list, index + j)) {
                    return false;
                }

            }
        }
        return true;
    }

    private boolean haveAndRemove(List<Integer> list, int n) {
        int remove = -1;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == n) {
                remove = i;
                break;
            }
        }
        if (remove == -1) {
            return false;
        } else {
            list.remove(remove);
            return true;
        }
    }


    public int maxCandies(int[] status, int[] candies, int[][] keys,
                          int[][] containedBoxes, int[] initialBoxes) {
        Map<Integer, Integer> gotBox = new HashMap<>();
        Map<Integer, Integer> gotKey = new HashMap<>();
        for (int i = 0; i < status.length; i++) {
            if (status[i] == 1) {
                gotKey.put(i, i);
            }
        }
        for (int initialBox : initialBoxes) {
            gotBox.put(initialBox, initialBox);
        }
        if (gotBox.size() == 0 || gotKey.size() == 0) {
            return 0;
        }
        int maxBox = status.length;
        int lastLen = 0;
        for (int t = 0; t < maxBox; t++) {
            for (int i = 0; i < maxBox; i++) {
                if (gotBox.containsKey(i) && gotKey.containsKey(i)) {
                    int[] k = keys[i];
                    int[] b = containedBoxes[i];
                    for (int value : k) {
                        gotKey.put(value, value);
                    }
                    for (int value : b) {
                        gotBox.put(value, value);
                    }
                }
            }
            int len = gotBox.size() + gotKey.size();
            if (lastLen == len) {
                break;
            }
            lastLen = len;
        }
        int res = 0;
        for (int i = 0; i < maxBox; i++) {
            if (gotBox.containsKey(i) && gotKey.containsKey(i)) {
                res += candies[i];
            }
        }
        return res;

    }
}
