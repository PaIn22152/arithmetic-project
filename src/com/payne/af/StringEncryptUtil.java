package com.payne.af;

import com.payne.utils.PrintHelper;

import java.util.HashMap;
import java.util.Map;

/**
 * Project    arithmetic-project-git
 * Path       com.payne.af
 * Date       2018/12/14 - 15:11
 * Author     Payne.
 * About      类描述：
 */

public class StringEncryptUtil {

    private static Map<Character, Integer> charMap = null;
    private static Map<Integer, Character> intMap = null;

    private static final int KEY_NUM = 5;
    //private static final int MAX = 52;


    //52
    private static void initMap() {
        if (charMap == null || intMap == null) {
            initMap2();
        }
    }

    private static void initMap1() {
        charMap = new HashMap<>();
        intMap = new HashMap<>();
        char c = 'A';
        for (int i = 0; i < 26; i++) {
            charMap.put((char) (c + i), i);
            intMap.put(i, (char) (c + i));
        }
        c = 'a';
        for (int i = 26; i < 52; i++) {
            charMap.put((char) (c + i - 26), i);
            intMap.put(i, (char) (c + i - 26));
        }
        PrintHelper.println(charMap);
        PrintHelper.println(intMap);
    }

    private static void initMap2() {
        //自定义加密对照表
        char[] chars = {'a', 'm', 't', 'i', 'M', 'A','-'};
        charMap = new HashMap<>();
        intMap = new HashMap<>();
        for(int i=0;i<chars.length;i++){
            charMap.put(chars[i],i);
            intMap.put(i,chars[i]);
        }

        PrintHelper.println(charMap);
        PrintHelper.println(intMap);
    }


    public static String enc(String s) {
        initMap();
        StringBuilder sb = new StringBuilder();
        for (char tem : s.toCharArray()) {
            if (charMap.containsKey(tem)) {
                int i = charMap.get(tem) + KEY_NUM;
                if (i >= charMap.size()) {
                    i = i - charMap.size();
                }
                sb.append(intMap.get(i));
            } else {
                sb.append(tem);
            }

        }
        return sb.toString();

    }

    public static String dec(String s) {
        initMap();
        StringBuilder sb = new StringBuilder();
        for (char tem : s.toCharArray()) {
            if (charMap.containsKey(tem)) {
                int i = charMap.get(tem) - KEY_NUM;
                if (i < 0) {
                    i = i + charMap.size();
                }
                sb.append(intMap.get(i));
            } else {
                sb.append(tem);
            }

        }
        return sb.toString();
    }


    public static String enc2(String s) {
        initMap();
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < s.toCharArray().length; j++) {
            char tem = s.toCharArray()[j];
            if (charMap.containsKey(tem)) {
                int i = charMap.get(tem) + (j + 1) % KEY_NUM;
                if (i >= charMap.size()) {
                    i = i - charMap.size();
                }
                sb.append(intMap.get(i));
            } else {
                sb.append(tem);
            }

        }
        return sb.toString();
    }


    public static String dec2(String s) {
        initMap();
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < s.toCharArray().length; j++) {
            char tem = s.toCharArray()[j];
            if (charMap.containsKey(tem)) {
                int i = charMap.get(tem) - (j + 1) % KEY_NUM;
                if (i < 0) {
                    i = i + charMap.size();
                }
                sb.append(intMap.get(i));
            } else {
                sb.append(tem);
            }

        }
        return sb.toString();
    }


    public static void main() {
        String s0 = "0ABCXYZabcxyz09-=";
        PrintHelper.println("s0 = " + s0);
        String enc0 = enc2(s0);
        PrintHelper.println("enc0 = " + enc0);

        String s = "ABCXYZabcxyz09-=";
        PrintHelper.println("s = " + s);
        String enc = enc2(s);
        PrintHelper.println("enc = " + enc);
        String dec = dec2(enc);
        PrintHelper.println("dec = " + dec);


        String s1 = "#  map =  " +
                "0 <A,0>  #  1 <B,1>  #  2 <C,2>  #  3 <D,3>  #  4 <E,4>  #  " +
                "5 <F,5>  #  6 <G,6>  #  7 <H,7>  #  8 <I,8>  #  9 <J,9>  #  " +
                "10 <K,10>  #  11 <L,11>  #  12 <M,12>  #  13 <N,13>  #  14 <O,14>  #  " +
                "15 <P,15>  #  16 <Q,16>  #  17 <R,17>  #  18 <S,18>  #  19 <T,19>  #  " +
                "20 <U,20>  #  21 <V,21>  #  22 <W,22>  #  23 <X,23>  #  24 <Y,24>  #  " +
                "25 <Z,25>  #  26 <a,26>  #  27 <b,27>  #  28 <c,28>  #  29 <d,29>  #  " +
                "30 <e,30>  #  31 <f,31>  #  32 <g,32>  #  33 <h,33>  #  34 <i,34>  #  " +
                "35 <j,35>  #  36 <k,36>  #  37 <l,37>  #  38 <m,38>  #  39 <n,39>  #  " +
                "40 <o,40>  #  41 <p,41>  #  42 <q,42>  #  43 <r,43>  #  44 <s,44>  #  " +
                "45 <t,45>  #  46 <u,46>  #  47 <v,47>  #  48 <w,48>  #  49 <x,49>  #  " +
                "50 <y,50>  #  51 <z,51>  #";
        String s2 = "#  map =  " +
                "0 <0,A>  #  1 <1,B>  #  2 <2,C>  #  3 <3,D>  #  4 <4,E>  #  " +
                "5 <5,F>  #  6 <6,G>  #  7 <7,H>  #  8 <8,I>  #  9 <9,J>  #  " +
                "10 <10,K>  #  11 <11,L>  #  12 <12,M>  #  13 <13,N>  #  14 <14,O>  #  " +
                "15 <15,P>  #  16 <16,Q>  #  17 <17,R>  #  18 <18,S>  #  19 <19,T>  #  " +
                "20 <20,U>  #  21 <21,V>  #  22 <22,W>  #  23 <23,X>  #  24 <24,Y>  #  " +
                "25 <25,Z>  #  26 <26,a>  #  27 <27,b>  #  28 <28,c>  #  29 <29,d>  #  " +
                "30 <30,e>  #  31 <31,f>  #  32 <32,g>  #  33 <33,h>  #  34 <34,i>  #  " +
                "35 <35,j>  #  36 <36,k>  #  37 <37,l>  #  38 <38,m>  #  39 <39,n>  #  " +
                "40 <40,o>  #  41 <41,p>  #  42 <42,q>  #  43 <43,r>  #  44 <44,s>  #  " +
                "45 <45,t>  #  46 <46,u>  #  47 <47,v>  #  48 <48,w>  #  49 <49,x>  #  " +
                "50 <50,y>  #  51 <51,z>  #  ";
    }

}
