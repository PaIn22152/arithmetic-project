package com.payne.leetCode.p;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by payne on 2017-12-27.
 * About 类描述：
 * Given a roman numeral, convert it to an integer.
 * Input is guaranteed to be within the range from 1 to 3999.
 * （数字范围1-3999，表示没有加线乘千的情况）
 */
public class P_13_Roman2Integer {
    public int romanToInt(String s) {
        return my(s);
    }

    /**
     * Ⅰ（1）、Ⅴ（5）、Ⅹ（10）、Ⅼ（50）、Ⅽ（100）、Ⅾ（500）和Ⅿ（1000）
     * 重复数次：一个罗马数字重复几次，就表示这个数的几倍。
     * 右加左减：
     * 在较大的罗马数字的右边记上较小的罗马数字，表示大数字加小数字。
     * 在较大的罗马数字的左边记上较小的罗马数字，表示大数字减小数字。
     * 左减的数字有限制，仅限于I、X、C。比如45不可以写成VL，只能是XLV
     * 但是，左减时不可跨越一个位值。比如，99不可以用IC（ {\displaystyle 100-1} 100-1）表示，而是用XCIX（ {\displaystyle [100-10]+[10-1]} [100-10]+[10-1]）表示。（等同于阿拉伯数字每位数字分别表示。）
     * 左减数字必须为一位，比如8写成VIII，而非IIX。
     * 右加数字不可连续超过三位，比如14写成XIV，而非XIIII。（见下方“数码限制”一项。）
     * 加线乘千：
     * 在罗马数字的上方加上一条横线或者加上下标的Ⅿ，表示将这个数乘以1000，即是原数的1000倍。
     * 同理，如果上方有两条横线，即是原数的1000000（ {\displaystyle 1000^{2}} 1000^{{2}}）倍。
     * 数码限制：
     * 同一数码最多只能连续出现三次，如40不可表示为XXXX，而要表示为XL。
     * 例外：由于IV是古罗马神话主神朱庇特（即IVPITER，古罗马字母里没有J和U）的首字，因此有时用IIII代替IV。
     * 数字范围1-3999，表示没有加线乘千的情况
     */
    public int my(String s) {//DCXXI
        List<Integer> list = new ArrayList<>();
        char[] chars = s.toCharArray();
        char last = '0';
        int value = 0;
        for (int i = chars.length - 1; i >= 0; i--) {
            char c = chars[i];
            if (last == '0') {
                value = getIntByChar(c);
                last = c;
            } else if (c != last) {
                list.add(value);
                value = getIntByChar(c);
                last = c;
            } else if (c == last) {
                value += getIntByChar(c);
            }
            if (i == 0) {
                list.add(value);
            }

        }

        int result = 0;
        for (int i = 0; i < list.size(); i++) {
            if (i == 0) {
                result = list.get(0);
            } else {
                if (result < list.get(i)) {
                    result += list.get(i);
                } else {
                    result -= list.get(i);
                }
            }
        }
        return result;
    }

    public int getIntByChar(char c) {
        switch (c) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return 0;
        }
    }
}
