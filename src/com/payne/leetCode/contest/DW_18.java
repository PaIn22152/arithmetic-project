package com.payne.leetCode.contest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class DW_18 {

    /**
     * 双周赛18
     */

    public int[] arrayRankTransform(int[] arr) {
        int[] copy = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            copy[i] = arr[i];
        }
        Arrays.sort(copy);
        int[] i2 = new int[copy.length];//arr排序去重后的数组
        int recur = 0;
        for (int i = 0; i < i2.length; i++) {
            if (i == 0) {
                i2[0] = copy[0];
            } else {
                if (copy[i] == copy[i - 1]) {
                    recur++;
                } else {
                    i2[i - recur] = copy[i];
                }
            }

        }
        int[] i3 = new int[i2.length - recur];
        for (int i = 0; i < i3.length; i++) {
            i3[i] = i2[i];
        }

        int[] res = new int[arr.length];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < i3.length; i++) {
            map.put(i3[i], i + 1);
        }
        for (int i = 0; i < arr.length; i++) {
            int num = arr[i];
            res[i] = map.get(num);
        }
        return res;
    }


    public String breakPalindrome(String palindrome) {
        char[] chars=palindrome.toCharArray();
        char[] letters=new char[26];
        char a='a';
        for(int i=0;i<letters.length;i++){
            letters[i]=(char)(a+i);
        }
        for(int ){

        }
    }

    private boolean isPalindrome(String s) {
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length / 2; i++) {
            if (chars[i] != chars[chars.length - 1 - i]) {
                return false;
            }
        }
        return true;
    }


}
