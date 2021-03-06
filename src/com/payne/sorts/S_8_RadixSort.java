package com.payne.sorts;

/**
 * Author:  Payne
 * Date:  2018/1/1
 * About:桶排序/基数排序(Radix Sort)
 * 基本思想：是将阵列分到有限数量的桶子里。每个桶子再个别排序
 * （有可能再使用别的排序算法或是以递回方式继续使用桶排序进行排序）。
 * 桶排序是鸽巢排序的一种归纳结果。当要被排序的阵列内的数值是均匀分配的时候，
 * 桶排序使用线性时间（Θ（n））。但桶排序并不是 比较排序，他不受到 O(n log n) 下限的影响。
 * 简单来说，就是把数据分组，放在一个个的桶中，然后对每个桶里面的在进行排序。
 * 例如要对大小为[1..1000]范围内的n个整数A[1..n]排序
 * 首先，可以把桶设为大小为10的范围，具体而言，设集合B[1]存储[1..10]的整数，集合B[2]存储
 * (10..20]的整数，……集合B[i]存储(   (i-1)*10,   i*10]的整数，i   =   1,2,..100。总共有  100个桶。
 * 然后，对A[1..n]从头到尾扫描一遍，把每个A[i]放入对应的桶B[j]中。
 * 再对这100个桶中每个桶里的数字排序，这时可用冒泡，选择，乃至快排，一般来说任  何排序法都可以。
 * 最后，依次输出每个桶里面的数字，且每个桶中的数字从小到大输出，这  样就得到所有数字排好序的一个序列了。
 * 假设有n个数字，有m个桶，如果数字是平均分布的，则每个桶里面平均有n/m个数字。如果
 * 对每个桶中的数字采用快速排序，那么整个算法的复杂度是
 * O(n   +   m   *   n/m*log(n/m))   =   O(n   +   nlogn   -   nlogm)
 * 从上式看出，当m接近n的时候，桶排序复杂度接近O(n)
 * 当然，以上复杂度的计算是基于输入的n个数字是平均分布这个假设的。这个假设是很强的  ，
 * 实际应用中效果并没有这么好。如果所有的数字都落在同一个桶中，那就退化成一般的排序了。
 * 前面说的几大排序算法 ，大部分时间复杂度都是O（n2），也有部分排序算法时间复杂度是O(nlogn)。
 * 而桶式排序却能实现O（n）的时间复杂度。但桶排序的缺点是：
 * 1）首先是空间复杂度比较高，需要的额外开销大。排序有两个数组的空间开销，一个存放待排序数组，
 * 一个就是所谓的桶，比如待排序值是从0到m-1，那就需要m个桶，这个桶数组就要至少m个空间。
 * 2）其次待排序的元素都要在一定的范围内等等。
 * 桶式排序是一种分配排序。分配排序的特定是不需要进行关键码的比较，但前提是要知道待排序列的一些具体情况。
 */
public class S_8_RadixSort {
}
