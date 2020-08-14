package com.payne.leetCode.p_old;

/**
 * Project    arithmetic-project-git
 * Path       com.payne.leetCode
 * Date       2018/08/10 - 10:57
 * Author     Payne.
 * About      类描述：
 */

class P_771_JewelsAndStones {
    /**
     * You're given strings J representing the types of stones that are jewels,
     * and S representing the stones you have.  Each character in S is a type of stone you have.
     * You want to know how many of the stones you have are also jewels.
     * <p_old>
     * The letters in J are guaranteed distinct, and all characters in J and S are letters.
     * Letters are case sensitive, so "a" is considered a different type of stone from "A".
     * <p_old>
     * Example 1:
     * <p_old>
     * Input: J = "aA", S = "aAAbbbb"
     * Output: 3
     * Example 2:
     * <p_old>
     * Input: J = "z", S = "ZZ"
     * Output: 0
     * Note:
     * <p_old>
     * S and J will consist of letters and have length at most 50.
     * The characters in J are distinct.
     */

    //用时7min36s
    public int numJewelsInStones(String J, String S) {
        return my(J, S);
    }

    public int my(String J, String S) {
       int n=0;
        for(char cj:J.toCharArray()){
            for(char cs:S.toCharArray()){
                if(cj==cs){
                    n++;
                }
            }
        }
        return n;
    }
}
