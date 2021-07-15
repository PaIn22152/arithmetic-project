package com.payne.sorts;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

/**
 * Project    arithmetic-project-git
 * Path       com.payne.sorts
 * Date       2021/07/15 - 09:45
 * Author     Payne.
 * About      类描述：
 */

public class Main {


    public static void main(String[] args) {


        int[] data1 = createData(25000);
        int[] data2 = createData(50000);
        int[] data3 = createData(85000);
        int[] data4 = createData(110000);

        bubbleSort(data1);
        selectionSort(data2);
        insertionSort(data3);
        insertionSort2(data4);


//        printData(data4);

    }


    //代码来源  https://www.runoob.com/w3cnote/insertion-sort.html
    private static void insertionSort2(int[] arr) {

        //当数据量=110000时，排序用时约为1000ms
        long t1 = System.currentTimeMillis();

        // 从下标为1的元素开始选择合适的位置插入，因为下标为0的只有一个元素，默认是有序的
        for (int i = 1; i < arr.length; i++) {
            // 记录要插入的数据
            int tmp = arr[i];
            // 从已经排序的序列最右边的开始比较，找到比其小的数
            int j = i;
            while (j > 0 && tmp < arr[j - 1]) {
                arr[j] = arr[j - 1];
                j--;
            }
            // 存在比其小的数，插入
            if (j != i) {
                arr[j] = tmp;
            }
        }

        long t2 = System.currentTimeMillis();
        System.out.println("insertionSort2:  data len = " + arr.length + ";  used time = " + (t2 - t1) + " ms ");
    }

    //插入排序
    private static void insertionSort(int[] data) {

        //当数据量=85000时，排序用时约为1000ms，方差较大，不稳定
        long t1 = System.currentTimeMillis();

        for (int i = 1; i < data.length; i++) {
            for (int j = 0; j < i; j++) {
                if (data[i] <= data[j]) {
                    int tem = data[i];
                    for (int k = i; k > j; k--) {
                        data[k] = data[k - 1];
                    }
                    data[j] = tem;
                    break;
                }
            }
        }

        long t2 = System.currentTimeMillis();
        System.out.println("insertionSort:  data len = " + data.length + ";  used time = " + (t2 - t1) + " ms ");

    }

    //选择排序
    private static void selectionSort(int[] data) {

        //当数据量=50000时，排序用时约为1000ms
        long t1 = System.currentTimeMillis();

        for (int i = 0; i < data.length - 1; i++) {
            int temI = i;
            for (int j = i + 1; j < data.length; j++) {
                if (data[j] < data[temI]) {
                    temI = j;
                }
            }
            if (temI != i) {
                int tem = data[i];
                data[i] = data[temI];
                data[temI] = tem;
            }
        }

        long t2 = System.currentTimeMillis();
        System.out.println("selectionSort:  data len = " + data.length + ";  used time = " + (t2 - t1) + " ms ");
    }


    //冒泡排序
    private static void bubbleSort(int[] data) {
        //当数据量=25000时，排序用时约为1000ms
        long t1 = System.currentTimeMillis();
        for (int i = data.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (data[j] > data[j + 1]) {
                    int tem = data[j];
                    data[j] = data[j + 1];
                    data[j + 1] = tem;
                }
            }
        }
        long t2 = System.currentTimeMillis();
        System.out.println("bubbleSort:  data len = " + data.length + ";  used time = " + (t2 - t1) + " ms ");
    }

    //获取当前时间的字符串
    private static String getCurTimeStr() {
        Calendar calendar = Calendar.getInstance();
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);
        int sec = calendar.get(Calendar.SECOND);
        int millsec = calendar.get(Calendar.MILLISECOND);
        return hour + ":" + minute + ":" + sec + "_" + millsec;
    }


    //生成随机数组数据
    private static int[] createData(int len) {
        int[] data = new int[len];
        Random random = new Random();
        for (int i = 0; i < data.length; i++) {
            data[i] = random.nextInt(len);
        }
        return data;
    }

    //打印数组数据
    private static void printData(int[] data) {
        int maxLen = 1024;
        String s = "[";
        for (int i = 0; i < data.length; i++) {
            s = s + data[i] + ",";
            if (s.length() >= maxLen) {
                System.out.print(s);
                s = "";
            }
        }
        if (s.isEmpty()) {
            s = "]";
        } else {
            s = s.substring(0, s.length() - 1) + "]";
        }
        System.out.println(s);
    }
}
