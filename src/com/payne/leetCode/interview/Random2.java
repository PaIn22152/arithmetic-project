package com.payne.leetCode.interview;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Project    arithmetic-project-git
 * Path       com.payne.leetCode.interview
 * Date       2020/08/05 - 10:10
 * Author     Payne.
 * About      类描述：
 */

public class Random2 {

    /**
     * 已知一个 NxN 的国际象棋棋盘，棋盘的行号和列号都是从 0 开始。
     * 即最左上角的格子记为 (0, 0)，最右下角的记为 (N-1, N-1)。
     * <p>
     * <p>
     * 现有一个 “马”（也译作 “骑士”）位于 (r, c) ，并打算进行 K 次移动。
     * <p>
     * 如下图所示，国际象棋的 “马” 每一步先沿水平或垂直方向移动 2 个格子，
     * 然后向与之相垂直的方向再移动 1 个格子，共有 8 个可选的位置。
     * <p>
     * 现在 “马” 每一步都从可选的位置（包括棋盘外部的）中独立随机地选择一个进行移动，直到移动了 K 次或跳到了棋盘外面。
     * 求移动结束后，“马” 仍留在棋盘上的概率。
     * <p>
     * <p>
     * 示例：
     * 输入: 3, 2, 0, 0
     * 输出: 0.0625
     * 解释:
     * 输入的数据依次为 N, K, r, c
     * 第 1 步时，有且只有 2 种走法令 “马” 可以留在棋盘上（跳到（1,2）或（2,1））。对于以上的两种情况，各自在第2步均有且只有2种走法令 “马” 仍然留在棋盘上。
     * 所以 “马” 在结束后仍在棋盘上的概率为 0.0625。
     */

    //超过内存限制，未通过
    public double knightProbability(int N, int K, int r, int c) {
        int in = 0;
        int out = 0;
        int[] p = new int[2];
        p[0] = r;
        p[1] = c;
        List<int[]> ps = new ArrayList<>();
        ps.add(p);
        double per = 1;
        for (int i = 0; i < K; i++) {
            List<int[]> positions = getPositions(ps);
            ps.clear();
            for (int[] t : positions) {
                if (out(N - 1, t)) {
                    out++;
                } else {
                    in++;
                    ps.add(t);
                }

            }
            if (in == 0) {
                per = 0D;
            } else {
                per *= (double) in / (double) (in + out);
            }
            in = 0;
            out = 0;
        }

        return per;
    }


    public List<int[]> getPositions(List<int[]> positions) {
        List<int[]> res = new ArrayList<>();
        for (int[] p : positions) {
            List<int[]> tem = getPositions(p);
            res.addAll(tem);
        }
        return res;
    }

    /**
     * 根据当前点，获取所有可以走的位置
     */
    public List<int[]> getPositions(int[] position) {
        int x = position[0];
        int y = position[1];
        List<int[]> res = new ArrayList<>();

        for (int i = 0; i < 2; i++) {
            int temx;
            if (i == 0) {
                temx = x - 1;
            } else temx = x + 1;
            for (int j = 0; j < 2; j++) {
                int temy;
                if (j == 0) {
                    temy = y + 2;
                } else temy = y - 2;
                int[] p = new int[2];
                p[0] = temx;
                p[1] = temy;
                res.add(p);
            }
        }

        for (int i = 0; i < 2; i++) {
            int temx;
            if (i == 0) {
                temx = x - 2;
            } else temx = x + 2;
            for (int j = 0; j < 2; j++) {
                int temy;
                if (j == 0) {
                    temy = y + 1;
                } else temy = y - 1;
                int[] p = new int[2];
                p[0] = temx;
                p[1] = temy;
                res.add(p);
            }
        }
        return res;
    }

    /**
     * 判断点是否到棋盘外
     */
    public boolean out(int max, int[] p) {
        int x = p[0];
        int y = p[1];
        return !(x >= 0 && y >= 0 && x <= max && y <= max);
    }


    /**
     * n 名士兵站成一排。每个士兵都有一个 独一无二 的评分 rating 。
     * <p>
     * 每 3 个士兵可以组成一个作战单位，分组规则如下：
     * 从队伍中选出下标分别为 i、j、k 的 3 名士兵，他们的评分分别为 rating[i]、rating[j]、rating[k]
     * 作战单位需满足： rating[i] < rating[j] < rating[k] 或者 rating[i] > rating[j] > rating[k] ，
     * 其中  0 <= i < j < k < n
     * 请你返回按上述条件可以组建的作战单位数量。每个士兵都可以是多个作战单位的一部分。
     * <p>
     * 示例 1：
     * 输入：rating = [2,5,3,4,1]
     * 输出：3
     * 解释：我们可以组建三个作战单位 (2,3,4)、(5,4,1)、(5,3,1) 。
     * <p>
     * 示例 2：
     * 输入：rating = [2,1,3]
     * 输出：0
     * 解释：根据题目条件，我们无法组建作战单位。
     * <p>
     * 示例 3：
     * 输入：rating = [1,2,3,4]
     * 输出：4
     * <p>
     * 提示：
     * n == rating.length
     * 1 <= n <= 200
     * 1 <= rating[i] <= 10^5
     */
    public int numTeams(int[] rating) {
        if (rating.length < 3) {
            return 0;
        }
        int left = 0;//头指针
        int right = rating.length - 1;//尾指针
        int num = 0;
        while (left < right) {

            int[] tem = new int[3];
            tem[0] = rating[left];
            tem[2] = rating[right];
            for (int i = left + 1; i < right; i++) {
                tem[1] = rating[i];
                if (canTeam(tem)) {
                    num++;
                }
            }
            left++;
            if (right - left < 2) {
                left = 0;
                right--;
            }
        }
        return num;
    }

    /**
     * rating.len == 3
     */
    public boolean canTeam(int[] rating) {
        if (rating.length == 3) {
            return (rating[0] < rating[1] && rating[1] < rating[2])
                    || (rating[0] > rating[1] && rating[1] > rating[2]);
        }
        return false;
    }


    /**
     * 给定一个正整数 n，你可以做如下操作：
     * 1. 如果 n 是偶数，则用 n / 2替换 n。
     * 2. 如果 n 是奇数，则可以用 n + 1或n - 1替换 n。
     * n 变为 1 所需的最小替换次数是多少？
     * <p>
     * 示例 1:
     * 输入:
     * 8
     * 输出:
     * 3
     * 解释:
     * 8 -> 4 -> 2 -> 1
     * <p>
     * 示例 2:
     * 输入:
     * 7
     * 输出:
     * 4
     * 解释:
     * 7 -> 8 -> 4 -> 2 -> 1
     * 或
     * 7 -> 6 -> 3 -> 2 -> 1
     */
    public int integerReplacement(int i) {
        long n = (long) i;
        if (n == 1) {
            return 0;
        }
        Set<Long> input = new HashSet<>();
        Set<Long> history = new HashSet<>();
        input.add(n);
        history.add(n);
        int p = 0;
        while (true) {
            p++;
            Set<Long> handler = handler(input, history);
            if (handler.contains(1L)) {
                return p;
            } else {
                history.addAll(handler);

                input.clear();
                input.addAll(handler);
            }
        }
    }

    public Set<Long> handler(Set<Long> input, Set<Long> history) {
        Set<Long> res = new HashSet<>();
        for (long i : input) {
            long t;
            if (i % 2 == 0) {
                t = i / 2;
                if (!history.contains(t)) {
                    res.add(t);
                }
            } else {
                t = i + 1;
                if (!history.contains(t)) {
                    res.add(t);
                }

                t = i - 1;
                if (!history.contains(t)) {
                    res.add(t);
                }
            }
        }
        return res;
    }
}
