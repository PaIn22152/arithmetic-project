package com.payne.leetCode.p_old;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Project    arithmetic-project-git
 * Path       com.payne.leetCode
 * Date       2018/11/14 - 11:20
 * Author     Payne.
 * About      类描述：
 */

public class P_45_JumpGameII {
    /**
     * https://leetcode.com/problems/jump-game-ii/description/
     * <p_old>
     * Given an array of non-negative integers,
     * you are initially positioned at the first index of the array.
     * Each element in the array represents your maximum jump length at that position.
     * Your goal is to reach the last index in the minimum number of jumps.
     * <p_old>
     * Example:
     * Input: [2,3,1,1,4]
     * Output: 2
     * Explanation: The minimum number of jumps to reach the last index is 2.
     * Jump 1 step from index 0 to 1, then 3 steps to the last index.
     */

    public int jump(int[] nums) {
        return f1(nums);
    }

//    public int my(int[] nums) {
//
//    }

    /**
     * BFS宽度优先搜索（Breadth-First-Search）
     *  0 1 2 3 4 5 6 7 8 9 0 1 2 3
     * [4,4,1,1,2,3,1,1,1,3,1,2,5,1]
     */
    public int f1(int[] nums) {
        int len = nums.length;
        int[] jumps = new int[len];
        Arrays.fill(jumps, Integer.MAX_VALUE);
        jumps[0] = 0;
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        while (!q.isEmpty()) {
            int cur = q.remove();
            int maxJump = nums[cur];
            for (int j = maxJump; j >= 1; j--) {
                int k = Math.min(cur + j, len - 1);
                if (jumps[k] == Integer.MAX_VALUE) {
                    jumps[k] = jumps[cur] + 1;
                    q.add(k);
                }
                if (jumps[len - 1] != Integer.MAX_VALUE) break;
            }
            if (jumps[len - 1] != Integer.MAX_VALUE) break;
        }
        return jumps[len - 1];
    }


}
