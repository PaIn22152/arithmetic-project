package com.payne.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * created by xuya on 2018/11/06 10:46:28
 */
public class PrintHelper {

    public static void println(byte[] bs) {
        System.out.print(getTimeString() + "println byte[] = {");
        for (int i = 0; i < bs.length; i++) {
            if (i == bs.length - 1) {
                System.out.print(bs[i]);
                System.out.println("}");
            } else {
                System.out.print(bs[i]);
                System.out.print(",");
            }

        }

    }

    public static void println(int[] bs) {
        System.out.print(getTimeString() + "println int[] = {");
        for (int i = 0; i < bs.length; i++) {
            if (i == bs.length - 1) {
                System.out.print(bs[i]);
                System.out.println("}");
            } else {
                System.out.print(bs[i]);
                System.out.print(",");
            }

        }

    }

    private static String getTimeString() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
        return "# Time:" + format.format(new Date()) + " # ";
    }

    public static void println(String s) {
        System.out.println(getTimeString() + s);
    }

    public static void println(int s) {
        System.out.println(getTimeString() + s);
    }

    public static void println(boolean s) {
        System.out.println(getTimeString() + s);
    }

}
