package com.payne.utils;

import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

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

    public static <T> void println(List<T> list) {
        System.out.print(getTimeString() + "println list<" + list.getClass() + "> = {");
        for (int i = 0; i < list.size(); i++) {
            if (i == list.size() - 1) {
                System.out.print(list.get(i));
            } else {
                System.out.print(list.get(i));
                System.out.print(",");
            }
        }
        System.out.println("}");
    }

    public static <T> void println(T[] ts) {
        System.out.print(getTimeString() + "println [" + ts.getClass() + "] = {");
        for (int i = 0; i < ts.length; i++) {
            if (i == ts.length - 1) {
                System.out.print(ts[i]);
                System.out.println("}");
            } else {
                System.out.print(ts[i]);
                System.out.print(",");
            }
        }
    }

    public static <T> void println(Collection<T> collection){
        System.out.print(getTimeString() + "println stack<" + collection.getClass() + "> = {");
        int len = collection.size();
        int pos = 0;
        for (T t : collection) {
            pos++;
            System.out.print(t);
            if (pos < len) {
                System.out.print(",");
            }
        }
        System.out.println("}");
    }

    private static String getTimeString() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
        return "# Time:" + format.format(new Date()) + " # ";
    }

    private static long startTime = 0;

    public static void start() {
        startTime = System.currentTimeMillis();
        println("start time = " + startTime);
    }

    public static void end() {
        long endTime = System.currentTimeMillis();
        long time = endTime - startTime;
        println("end time = " + endTime + "  time = " + time + "ms");
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

    public static <K, V> void println(Map<K, V> map) {
        if (map == null) {
            println(" map = null;");
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append(" map =  ");
            int num = 0;
            for (Map.Entry<K, V> tem : map.entrySet()) {
                sb.append(num++).append(" <").append(tem.getKey()).append(",").append(tem.getValue()).append(">  #  ");
            }
            println(sb.toString());
        }
    }

}
