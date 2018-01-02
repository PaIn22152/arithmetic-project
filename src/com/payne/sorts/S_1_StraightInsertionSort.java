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
 * <p>
 * 如果碰见一个和插入元素相等的，那么插入元素把想插入的元素放在相等元素的后面。
 * 所以，相等元素的前后顺序没有改变，从原无序序列出去的顺序就是排好序后的顺序，所以插入排序是稳定的。
 * 时间复杂度：O（n^2）.
 */
public class S_1_StraightInsertionSort {

    public static int[] sort(int[] nums) {
        int[] result = new int[nums.length];
        result[0] = nums[0];
    /*for(int i=1;i<nums.length;i++){
        for(int j=0;j<result.length;j++){
            if(nums[i]  >=result[j]){
                result[j+1]=
            }
        }
    }*/

        return result;
    }

}
