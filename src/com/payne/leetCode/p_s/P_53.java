package com.payne.leetCode.p_s;

/**
 * Project    arithmetic-project-git
 * Path       com.payne.leetCode.p_s
 * Date       2021/02/26 - 17:05
 * Author     Payne.
 * About      类描述：
 */

class P_53 {

    /**
     * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），
     * 返回其最大和。
     * <p>
     * 示例 1：
     * 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
     * 输入：nums = [-2,1,-3,4,-1,2,1,-5,5]
     * 输出：6
     * 解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/maximum-subarray
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * <p>
     * 进阶：如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的 分治法 求解。
     */

    //动态规划
    public int maxSubArray(int[] nums) {
        //状态转移方程
        //f(k)=max{f(k-1)+nums[k],nums[k]}
        int pre = 0, max = nums[0];
        for (int i : nums) {
            pre = Math.max(pre + i, i);
            max = Math.max(pre, max);
        }
        return max;
    }
}
