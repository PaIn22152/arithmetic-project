package com.payne.utils;

/**
 * Project    arithmetic-project-git
 * Path       com.payne.utils
 * Date       2019/02/20 - 10:27
 * Author     Payne.
 * About      类描述：
 */

public class Hex2Dec {

    /**
     * 16进制转10进制
     */

    public static String convert(String hex) {
//        int ans = 0;
//        hex = hex.toUpperCase();
//        if (hex.startsWith("0X")) {
//            hex = hex.substring(2);
//            int mul = 1;
//            for (int i = hex.length() - 1; i >= 0; i--) {
//                char c = hex.charAt(i);
//                ans += hexChar2Int(c) * mul;
//                mul *= 16;
//            }
//        }
//        return "" + ans;
        return Integer.parseInt(hex.substring(2), 36)+"";
    }

    private static int hexChar2Int(char c) {
        switch (c) {
            case 'A':
                return 10;
            case 'B':
                return 11;
            case 'C':
                return 12;
            case 'D':
                return 13;
            case 'E':
                return 14;
            case 'F':
                return 15;
            default:
                return Integer.parseInt(c + "");
        }
    }

//    public static String convert(String in,int radix){
//
//    }
//    private static int hexChar2Int(char c,int radix) {
//
//    }


}
