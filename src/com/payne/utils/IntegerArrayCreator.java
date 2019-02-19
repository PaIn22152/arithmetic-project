package com.payne.utils;

import java.util.Random;

/**
 * Project    arithmetic-project-git
 * Path       com.payne.utils
 * Date       2018/12/13 - 17:36
 * Author     Payne.
 * About      类描述：
 */

public class IntegerArrayCreator {

    public static int[] getRandomArray(int len) {
        int[] result = new int[len];

        for (int i = 0; i < len; i++) {
            result[i] = new Random().nextInt(len * 2);
        }

        return result;

    }

    public static Integer[] getRandomArray2(int len) {
        Integer[] result = new Integer[len];

        for (int i = 0; i < len; i++) {
            result[i] = new Random().nextInt(len * 2);
        }

        return result;

    }

}
