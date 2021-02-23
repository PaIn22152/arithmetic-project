package com.payne.leetCode.daily;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Project    arithmetic-project-git
 * Path       com.payne.leetCode.daily
 * Date       2020/09/18 - 09:38
 * Author     Payne.
 * About      类描述：
 */

class D_47 {
    /*
    * 47. 全排列 II
给定一个可包含重复数字的序列，返回所有不重复的全排列。

示例:

输入: [1,1,2]
输出:
[
  [1,1,2],
  [1,2,1],
  [2,1,1]
]
    * */

    //穷举，hash去重
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list=new ArrayList<>();//position
        for(int i=0;i<nums.length;i++){
            list.add(i);
        }

        return ans;
    }

//    private List<List<Integer>> handle(int[] nums, List<Integer> list) {
//        List<List<Integer>> ans = new ArrayList<>();
//
//        if(list.size()==1){
//            List<Integer> t=new ArrayList<>();
//            t.add(list.get(0));
//            ans.add(t);
//        }else {
//            for(){
//
//            }
//        }
//
//        return ans;
//    }
}
