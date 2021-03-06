package com.payne.sorts;

/**
 * Author:  Payne
 * Date:  2018/1/1
 * About:交换排序—冒泡排序（Bubble Sort）
 * 基本思想：
 * 在要排序的一组数中，对当前还未排好序的范围内的全部数，自上而下对相邻的两个数依次进行比较和调整，
 * 让较大的数往下沉，较小的往上冒。即：每当两相邻的数比较后发现它们的排序与排序要求相反时，就将它们互换。
 * <p_old>
 * 冒泡排序算法的改进
 * 对冒泡排序常见的改进方法是加入一标志性变量exchange，用于标志某一趟排序过程中是否有数据交换，
 * 如果进行某一趟排序时并没有进行数据交换，则说明数据已经按要求排列好，可立即结束排序，
 * 避免不必要的比较过程。本文再提供以下两种改进算法：
 * <p_old>
 * 1．设置一标志性变量pos,用于记录每趟排序中最后一次进行交换的位置。
 * 由于pos位置之后的记录均已交换到位,故在进行下一趟排序时只要扫描到pos位置即可。
 * <p_old>
 * 2．传统冒泡排序中每一趟排序操作只能找到一个最大值或最小值,
 * 我们考虑利用在每趟排序中进行正向和反向两遍冒泡的方法一次可以得到两个最终值(最大者和最小者) ,
 * 从而使排序趟数几乎减少了一半。
 */
public class S_5_BubbleSort {
//    public static int[] sort(int array[], int count) {
//
//        //return bubblingSort1(array, count);
//        return bubblingSortOpt2(array, count);
//
//    }


    /**
     * random array.
     * len = 90000
     * time = 12*1000 ms
     * */
    public static int[] sort(int array[], int count) {

        for (int i = 0; i < count; i++) {
            for (int j = 0; j < count - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int tem = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tem;
                }
            }
        }
        return array;

    }

    /**
     * random array.
     * len = 90000
     * time = 12*1000 ms
     * */
    public static int[] sort1(int array[], int count) {

        for (int i = 0; i < count; i++) {
            boolean exchange = false;
            for (int j = 0; j < count - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int tem = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tem;
                    exchange = true;
                }
            }
            if (!exchange) {
                return array;
            }
        }
        return array;

    }

    /**
     * random array.
     * len = 90000
     * time = 8*1000 ms
     * */
    public static int[] sort2(int array[], int count) {

        for (int i = 0; i < count / 2; i++) {
            boolean exchange = false;

            //大数后移
            for (int j = 0; j < count - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int tem = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tem;
                    exchange = true;
                }
            }


            //小数前移
            for (int j = count - 1; j > i; j--) {
                if (array[j] < array[j - 1]) {
                    int tem = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = tem;
                    exchange = true;
                }
            }

            if (!exchange) {
                return array;
            }
        }
        return array;

    }
}
