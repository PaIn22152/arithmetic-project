package com.payne.leetCode.match;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class M20200912 {

    /*match
    力扣杯秋季编程大赛
     */


    //1
    int x = 1;
    int y = 0;

    public int calculate(String s) {
        for (char c : s.toCharArray()) {
            if (c == 'A') {
                a();
            }
            if (c == 'B') {
                b();
            }
        }
        return x + y;
    }

    private void a() {
        x = 2 * x + y;
    }

    private void b() {
        y = 2 * y + x;
    }


    //2
    public int breakfastNumber2(int[] staple, int[] drinks, int x) {
        int ans = 0;
//        Arrays.sort(staple);
//        Arrays.sort(drinks);
        for (int i = 0; i < drinks.length; i++) {
            if (drinks[i] >= x) {
                continue;
            }
            for (int j = 0; j < staple.length; j++) {
                if (drinks[i] + staple[j] <= x) {
                    ans++;

                }
            }
        }
        ans = ans % 1000000007;
        return ans;

    }

    public int breakfastNumber(int[] staple, int[] drinks, int x) {
        int ans=0;
        List<Integer> list=new ArrayList<>();
        for(int i=0;i<staple.length;i++){
            if(x-staple[i]>0){
                list.add(x-staple[i]);
            }
        }
        for(int i=0;i<list.size();i++){

        }
        return ans;
    }


    //3
    public int minimumOperations(String leaves) {
        int ans = 0;
        int left = 0;
        int right = leaves.length() - 1;
        char[] chars = leaves.toCharArray();
        if (chars[left] != 'r') {
            chars[left] = 'r';
            ans++;
        }
        if (chars[right] != 'r') {
            chars[right] = 'r';
            ans++;
        }
        for (int i = 0; i < leaves.length(); i++) {
            if (chars[i] == 'y') {
                left = i;
                break;
            }
        }
        for (int i = leaves.length() - 1; i >= 0; i--) {
            if (chars[i] == 'y') {
                right = i;
                break;
            }
        }
        if (left == 0) {//没有y
            return ans + 1;
        }
        if (left == right) {//一个y，满足
            return ans;
        }
        int rn = 0;
        int yn = 0;
        for (int i = left; i <= right; i++) {
            if (chars[i] == 'y') {
                yn++;
            } else if (chars[i] == 'r') {
                rn++;
            }
        }

        return ans;

    }

}
