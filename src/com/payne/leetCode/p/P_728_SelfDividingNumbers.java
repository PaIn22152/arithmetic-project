package com.payne.leetCode.p;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by payne on 2018-01-07.
 * About 类描述：
 * A self-dividing number is a number that is divisible by every digit it contains.
 * For example, 128 is a self-dividing number because 128 % 1 == 0, 128 % 2 == 0, and 128 % 8 == 0.
 * Also, a self-dividing number is not allowed to contain the digit zero.
 * Given a lower and upper number bound, output a list of every possible self dividing number,
 * including the bounds if possible.
 * Note:
 * The boundaries of each input argument are 1 <= left <= right <= 10000.
 */
public class P_728_SelfDividingNumbers {


    public List<Integer> selfDividingNumbers(int left, int right) {
        return my(left, right);
    }

    /**
     * 完成时间，8min20sec
     */
    public List<Integer> my(int left, int right) {
        List<Integer> result = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            if (isSelfDividingNumber(i)) {
                result.add(i);
            }
        }
        return result;
    }

    public boolean isSelfDividingNumber(int i) {
        String s = "" + i;
        List<Integer> list = new ArrayList<>();
        for (int j = 0; j < s.length(); j++) {
            list.add(Integer.parseInt(s.substring(j, j + 1)));
        }
        for (Integer temp : list) {
            if (temp == 0) {
                return false;
            }
            if (i % temp != 0) {
                return false;
            }
        }
        return true;
    }

}
