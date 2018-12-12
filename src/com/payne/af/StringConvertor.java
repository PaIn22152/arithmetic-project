package com.payne.af;

import java.util.Random;

/**
 * Project    arithmetic-project-git
 * Path       com.payne.af
 * Date       2018/12/04 - 17:01
 * Author     Payne.
 * About      类描述：
 */

public class StringConvertor {

    public static int[] string2IntArray(String s) {
        int more = 7;
        int[] result = new int[s.length() + more];
        char[] cs = s.toCharArray();
        for (int i = 0; i < cs.length; i++) {
            if (i % 2 == 0) {
                result[i] = cs[i] - more;
            } else {
                result[i] = cs[i] + more;
            }
        }

        for (int i = 0; i < more; i++) {
            result[cs.length + i] = new Random().nextInt(100);
        }

        return result;
    }

    public static String intArray2String(int[] ints) {
        int more = 7;
        char[] cs = new char[ints.length - more];
        for (int i = 0; i < cs.length; i++) {
            if (i % 2 == 0) {
                cs[i] = (char) (ints[i] + more);
            } else {
                cs[i] = (char) (ints[i] - more);
            }
        }
        return new String(cs);
    }

}
