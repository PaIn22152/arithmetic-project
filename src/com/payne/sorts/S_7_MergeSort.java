package com.payne.sorts;

/**
 * Author:  Payne
 * Date:  2018/1/1
 * About:归并排序（Merge Sort）
 * 基本思想：
 * 归并（Merge）排序法是将两个（或两个以上）有序表合并成一个新的有序表，
 * 即把待排序序列分为若干个子序列，每个子序列是有序的。然后再把有序子序列合并为整体有序序列。
 * 设r[i…n]由两个有序子表r[i…m]和r[m+1…n]组成，两个子表长度分别为n-i +1、n-m。
 * j=m+1；k=i；i=i; //置两个子表的起始下标及辅助数组的起始下标
 * 若i>m 或j>n，转⑷ //其中一个子表已合并完，比较选取结束
 * //选取r[i]和r[j]较小的存入辅助数组rf
 * 如果r[i]<r[j]，rf[k]=r[i]； i++； k++； 转⑵
 * 否则，rf[k]=r[j]； j++； k++； 转⑵
 * //将尚未处理完的子表中元素存入rf
 * 如果i<=m，将r[i…m]存入rf[k…n] //前一子表非空
 * 如果j<=n ,  将r[j…n] 存入rf[k…n] //后一子表非空
 * 合并结束。
 */
public class S_7_MergeSort {
}