package com.payne.leetCode.swordOffer;

import java.util.HashMap;
import java.util.Map;

/**
 * Project    arithmetic-project-git
 * Path       com.payne.leetCode.swordOffer
 * Date       2020/08/11 - 12:19
 * Author     Payne.
 * About      类描述：
 */

public class O_10_1 {

    /**
     * 写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项。斐波那契数列的定义如下：
     * <p>
     * F(0) = 0,   F(1) = 1
     * F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
     * 斐波那契数列由 0 和 1 开始，之后的斐波那契数就是由之前的两数相加而得出。
     * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
     * <p>
     * 示例 1：
     * 输入：n = 2
     * 输出：1
     * <p>
     * 示例 2：
     * 输入：n = 5
     * 输出：5
     *  
     * 提示：
     * 0 <= n <= 100
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/fei-bo-na-qi-shu-lie-lcof
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */


    private static final int MOD = 1000000007;


    /**
     * 简单递归
     * 原理： 把 f(n)f(n) 问题的计算拆分成 f(n-1)f(n−1) 和 f(n-2)f(n−2) 两个子问题的计算，
     * 并递归，以 f(0)f(0) 和 f(1)f(1) 为终止条件。
     * <p>
     * 缺点： 大量重复的递归计算，例如 f(n)f(n) 和 f(n - 1)f(n−1)
     * 两者向下递归需要 各自计算 f(n - 2)f(n−2) 的值。
     * <p>
     * 性能较差，
     */
    public int fib(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        } else return (fib(n - 1) + fib(n - 2)) % MOD;

    }


    /**
     * 在简单递归的基础上优化，使用hash减少重复计算
     * */
    public int fib2(int n) {
        return fib2(n, new HashMap<>());
    }

    public int fib2(int n, Map<Integer, Integer> map) {
        if (n <= 1) {
            return n;
        } else if (map.containsKey(n)) {
            return map.get(n);
        } else {
            int v = (fib2(n - 1, map) + fib2(n - 2, map)) % MOD;
            map.put(n, v);
            return v;
        }
    }


    /**
     * 动态规划，性能最佳的解法
     * */
    public int fib3(int n) {
        int a = 0, b = 1, sum;
        for (int i = 0; i < n; i++) {
            sum = (a + b) % MOD;
            a = b;
            b = sum;
        }
        return a;
    }
}
