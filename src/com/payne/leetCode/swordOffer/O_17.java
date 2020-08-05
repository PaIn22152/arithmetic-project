package com.payne.leetCode.swordOffer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Project    arithmetic-project-git
 * Path       com.payne.leetCode.swordOffer
 * Date       2020/08/05 - 09:44
 * Author     Payne.
 * About      类描述：
 */

public class O_17 {
    /**
     * 输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。
     * 比如输入 3，则打印出 1、2、3 一直到最大的 3 位数 999。
     * <p>
     * 示例 1:
     * 输入: n = 1
     * 输出: [1,2,3,4,5,6,7,8,9]
     *  
     * 说明：
     * 用返回一个整数列表来代替打印
     * n 为正整数
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/da-yin-cong-1dao-zui-da-de-nwei-shu-lcof
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    public int[] printNumbers(int n) {
        int max = 0;
        int multiple = 1;
        for (int i = 1; i <= n; i++) {
            max += (multiple * 9);
            multiple *= 10;
        }
        int[] res = new int[max];
        for (int i = 1; i <= max; i++) {
            res[i - 1] = i;
        }
        return res;
    }

    //最低效
    public int[] printNumbers2(int n) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 1; i < Integer.MAX_VALUE; i++) {
            if (("" + i).length() <= n) {
                list.add(i);
            } else {
                break;
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    public int[] printNumbers3(int n) {
        if (n < 1) {
            return null;
        }
        //求最大值-边界
        int max = 1;
        while (n >= 1) {
            max *= 10;

            n--;
        }

        int[] ret = new int[max - 1];

        for (int i = 0; i < max - 1; i++) {
            ret[i] = i + 1;
        }
        return ret;
    }
}
