package com.payne.leetCode.daily;

import java.util.HashMap;
import java.util.Map;

/**
 * Project    arithmetic-project-git
 * Path       com.payne.leetCode.daily
 * Date       2020/09/01 - 09:52
 * Author     Payne.
 * About      类描述：
 */

public class D_486 {

    /**
     * 486. 预测赢家
     * 给定一个表示分数的非负整数数组。
     * 玩家 1 从数组任意一端拿取一个分数，
     * 随后玩家 2 继续从剩余数组任意一端拿取分数，
     * 然后玩家 1 拿，…… 。
     * 每次一个玩家只能拿取一个分数，分数被拿取之后不再可取。
     * 直到没有剩余分数可取时游戏结束。最终获得分数总和最多的玩家获胜。
     * <p>
     * 给定一个表示分数的数组，预测玩家1是否会成为赢家。
     * 你可以假设每个玩家的玩法都会使他的分数最大化。
     * <p>
     * 示例 1：
     * 输入：[1, 5, 2]
     * 输出：False
     * 解释：一开始，玩家1可以从1和2中进行选择。
     * 如果他选择 2（或者 1 ），那么玩家 2 可以从 1（或者 2 ）和 5 中进行选择。
     * 如果玩家 2 选择了 5 ，那么玩家 1 则只剩下 1（或者 2 ）可选。
     * 所以，玩家 1 的最终分数为 1 + 2 = 3，而玩家 2 为 5 。
     * 因此，玩家 1 永远不会成为赢家，返回 False 。
     * <p>
     * 示例 2：
     * 输入：[1, 5, 233, 7]
     * 输出：True
     * 解释：玩家 1 一开始选择 1 。然后玩家 2 必须从 5 和 7 中进行选择。
     * 无论玩家 2 选择了哪个，玩家 1 都可以选择 233 。
     * 最终，玩家 1（234 分）比玩家 2（12 分）获得更多的分数，所以返回 True，表示玩家 1 可以成为赢家。
     * <p>
     * 提示：
     * 1 <= 给定的数组长度 <= 20.
     * 数组里所有分数都为非负数且不会大于 10000000 。
     * 如果最终两个玩家的分数相等，那么玩家 1 仍为赢家。
     * <p>
     * https://leetcode-cn.com/problems/predict-the-winner/
     */

    //官方动态规划代码
    public boolean PredictTheWinner(int[] nums) {
        int length = nums.length;
        int[] dp = new int[length];
        for (int i = 0; i < length; i++) {
            dp[i] = nums[i];
        }
        for (int i = length - 2; i >= 0; i--) {
            for (int j = i + 1; j < length; j++) {
                dp[j] = Math.max(nums[i] - dp[j], nums[j] - dp[j - 1]);
            }
        }
        return dp[length - 1] >= 0;
    }

    public boolean PredictTheWinner2(int[] nums) {
        int left = 0, right = nums.length - 1;
        Map<String, Integer> map = new HashMap<>();
        return total(nums, left, right, 1, map) >= 0;
    }


    /**
     * 当玩家1时，+当前值，当玩家2时，-当前值
     * 然后判断最终的值是否大于大于0
     * 玩家1希望这个值越大越好，大于等于0就赢了
     * 玩家2希望这个值越小越好，小于0就赢了
     */
    private int total(int[] nums, int left, int right, int turn, Map<String, Integer> map) {

        String s = left + "" + turn + "" + right;
        if (map.containsKey(s)) {
            return map.get(s);
        }
        //当左右指针相等，表示只剩一个值，如果当前是玩家1，返回正，是玩家2返回负
        if (left == right) {
            return nums[left] * turn;
        }


        //当前是玩家1，分为两种情况，取左值和取右值，然后取两种情况中的最大值
        if (turn > 0) {
            int leftTotal = nums[left] + total(nums, left + 1, right, -turn, map);
            int rightTotal = nums[right] + total(nums, left, right - 1, -turn, map);
            int ans = Math.max(leftTotal, rightTotal);
            map.put(s, ans);
            return ans;
        } else {

            //当前是玩家2，也是分两种情况，不同的是取两种情况的最小值，因为玩家2希望的是值越小越好
            int leftTotal = -nums[left] + total(nums, left + 1, right, -turn, map);
            int rightTotal = -nums[right] + total(nums, left, right - 1, -turn, map);
            int ans = Math.min(leftTotal, rightTotal);
            map.put(s, ans);
            return ans;
        }
    }


    //穷举，不可行
    public boolean PredictTheWinner1(int[] nums) {
        int left = 0, right = nums.length - 1;
        int sum1 = 0, sum2 = 0;
        return calc(nums, sum1, sum2, left, right, 0);
    }

    private boolean calc(int[] nums, int sum1, int sum2, int left, int right, int index) {
        if (left > right) {
            return sum1 >= sum2;
        }
        if (index % 2 == 0) {//玩家1
            return calc(nums, sum1 + nums[left], sum2, left + 1, right, index + 1)
                    || calc(nums, sum1 + nums[right], sum2, left, right - 1, index + 1);
        } else {
            return calc(nums, sum1, sum2 + nums[left], left + 1, right, index + 1)
                    || calc(nums, sum1, sum2 + nums[right], left, right - 1, index + 1);
        }
    }

    /**
     思考过程
     假如用穷举法，算法复杂度为2^n
     但是题目说到每个玩家会使自己分数最大化，所以用穷举，不满足这个条件
     * */
}
