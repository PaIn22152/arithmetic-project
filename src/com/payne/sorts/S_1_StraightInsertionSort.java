package com.payne.sorts;

/**
 * Author:  Payne
 * Date:  2018/1/1
 * About:
 * 插入排序—直接插入排序(Straight Insertion Sort)
 * 基本思想:
 * 将一个记录插入到已排序好的有序表中，从而得到一个新，记录数增1的有序表。
 * 即：先将序列的第1个记录看成是一个有序的子序列，然后从第2个记录逐个进行插入，直至整个序列有序为止。
 * 要点：设立哨兵，作为临时存储和判断数组边界之用。
 * <p_old>
 * 如果碰见一个和插入元素相等的，那么插入元素把想插入的元素放在相等元素的后面。
 * 所以，相等元素的前后顺序没有改变，从原无序序列出去的顺序就是排好序后的顺序，所以插入排序是稳定的。
 * 时间复杂度：O（n^2）.
 */
public class S_1_StraightInsertionSort {


    /**
     * random array.
     * len = 90000
     * time = 1*1000 ms
     * */
    public static int[] sort(int array[], int count) {
        int[] result = new int[array.length];
        result[0] = array[0];
        for (int i = 1; i < count; i++) {//i，有序表len，array当前需要判断的pos
            int pos = array[i];
            boolean insert = false;
            for (int j = 0; j < i; j++) {
                if (result[j] > pos) {
                    insert = true;
                    for (int k = i; k > j; k--) {
                        result[k] = result[k - 1];
                    }
                    result[j] = pos;
                    break;
                }
            }
            if (!insert) {
                result[i] = pos;
            }
        }
        return result;
    }

    public static int[] insertSort(int array[], int count) {

        int i, j, k;

        for (i = 1; i < count; i++) {

            for (j = i - 1; j >= 0; j--) { // 为a[i]在a[0, i-1]上找一个合适的位置
                if (array[j] < array[i]) break;
            }

            if (j != i - 1) { // 找到了一个合适的位置j

                int temp = array[i];
                // 将比array[i]大的数据全部往后移
                for (k = i - 1; k > j; k--) {
                    array[k + 1] = array[k];
                }
                // 将array[i]放入合适的位置
                array[k + 1] = temp;

            }

        }
        return array;
    }


}
