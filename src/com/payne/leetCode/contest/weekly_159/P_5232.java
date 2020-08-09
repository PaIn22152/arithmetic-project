package com.payne.leetCode.contest.weekly_159;

public class P_5232 {


    /**
     * "WWEQ ERQW QWWR WWER QWEQ"
     * 4
     *
     * "WWQQ RRRR QRQQ"
     * 4
     */

//    public int balancedString(String s) {
//
//        int res = 0;
//        if(s.length()==4){
//            return subBlance(s);
//        }
//        for (int i = 0; i < s.length() ; i+=4) {
//            String sub=s.substring(i, i + 4);
//            res += subBlance(sub);
//        }
//        return res;
//
//
//    }

    /**
     * WWEQ ERQW QWWR WWER QWEQ
     * 4
     *
     * "WQWRQQQW"
     */

    public int balancedString(String s) {
        int[] nums = new int[4];
        for (char c : s.toCharArray()) {
            switch (c) {
                case 'Q':
                    nums[0]++;
                    break;
                case 'W':
                    nums[1]++;
                    break;
                case 'E':
                    nums[2]++;
                    break;
                case 'R':
                    nums[3]++;
                    break;
            }
        }

        int p = s.length() / 4;
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > p) {
                nums[i] = nums[i] - p;
                res += nums[i];
            } else {
                nums[i] = 0;
            }
        }
        for (int i = res; i < s.length(); i++) {
            for (int j = 0; j <= s.length() - i; j++) {
                String sub = s.substring(j, j + i);
                int[] tem = nums.clone();
                for (char c : sub.toCharArray()) {
                    switch (c) {
                        case 'Q':
                            tem[0]--;
                            break;
                        case 'W':
                            tem[1]--;
                            break;
                        case 'E':
                            tem[2]--;
                            break;
                        case 'R':
                            tem[3]--;
                            break;
                    }
                }
                if (tem[0] <= 0 && tem[1] <= 0 && tem[2] <= 0 && tem[3] <= 0) {
                    return i;
                }

            }

        }

        return s.length();

    }
}
