package com.payne.leetCode.daily;

public class D_201 {

    /**
     * 201. 数字范围按位与
     * 给定范围 [m, n]，其中 0 <= m <= n <= 2147483647，
     * 返回此范围内所有数字的按位与（包含 m, n 两端点）。
     * <p>
     * 示例 1:
     * 输入: [5,7]
     * 输出: 4
     * <p>
     * 示例 2:
     * 输入: [0,1]
     * 输出: 0
     * 通过次数23,208提交次数47,403
     */


    public int rangeBitwiseAnd(int m, int n) {
        if (m == n) {
            return n;
        }
        int left = m;
        for (int right = left + 1; right <= n; ) {
            left = left & right;
            if (left == 0) {
                return 0;
            }
            if (right < Integer.MAX_VALUE) {
                right++;
            }
            if (right == Integer.MAX_VALUE) {
                break;
            }
        }
        return left;
    }

}
