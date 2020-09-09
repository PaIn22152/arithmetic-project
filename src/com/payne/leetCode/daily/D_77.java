package com.payne.leetCode.daily;

import java.util.ArrayList;
import java.util.List;

/**
 * Project    arithmetic-project-git
 * Path       com.payne.leetCode.daily
 * Date       2020/09/08 - 10:26
 * Author     Payne.
 * About      类描述：
 */

public class D_77 {

    /*
    77. 组合
给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。

示例:

输入: n = 4, k = 2
输出:
[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]
    * */

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        if (k <= n) {
            if (k == 1) {//当k=1时，把1-n添加到结果
                for (int i = 1; i <= n; i++) {
                    List<Integer> tem = new ArrayList<>();
                    tem.add(i);
                    ans.add(tem);
                }
            } else {
                //从i=[2,n]遍历,找到i和i左边数组成的解
                for (int i = 2; i <= n; i++) {
                    List<List<Integer>> res = combine(i - 1, k - 1);
                    for (List<Integer> tem : res) {
                        tem.add(i);
                        ans.add(tem);
                    }
                }
            }
        }
        return ans;
    }

    //有重复的算法
    public List<List<Integer>> combine2(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        if (k <= n) {
            if (k == 1) {
                for (int i = 1; i <= n; i++) {
                    List<Integer> tem = new ArrayList<>();
                    tem.add(i);
                    ans.add(tem);
                }
            } else {
                for (int i = 1; i <= n; i++) {
                    List<List<Integer>> res = combine(n, k - 1);
                    for (List<Integer> tem : res) {
                        tem.add(i);
                        ans.add(tem);
                    }
                }
            }
        }
        return ans;
    }


    //官方代码
    List<Integer> temp = new ArrayList<Integer>();
    List<List<Integer>> ans = new ArrayList<List<Integer>>();

    public List<List<Integer>> combine3(int n, int k) {
        List<Integer> temp = new ArrayList<Integer>();
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        // 初始化
        // 将 temp 中 [0, k - 1] 每个位置 i 设置为 i + 1，即 [0, k - 1] 存 [1, k]
        // 末尾加一位 n + 1 作为哨兵
        for (int i = 1; i <= k; ++i) {
            temp.add(i);
        }
        temp.add(n + 1);

        int j = 0;
        while (j < k) {
            ans.add(new ArrayList<Integer>(temp.subList(0, k)));
            j = 0;
            // 寻找第一个 temp[j] + 1 != temp[j + 1] 的位置 t
            // 我们需要把 [0, t - 1] 区间内的每个位置重置成 [1, t]
            while (j < k && temp.get(j) + 1 == temp.get(j + 1)) {
                temp.set(j, j + 1);
                ++j;
            }
            // j 是第一个 temp[j] + 1 != temp[j + 1] 的位置
            temp.set(j, temp.get(j) + 1);
        }
        return ans;
    }



    /*
     * 思考过程
     * 因为[1,2] 和 [2,1] 表示的是同一种组合方式，
     * 假设第一轮先取包含n的数组，
     * */


}
