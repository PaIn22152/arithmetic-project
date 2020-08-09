package com.payne.leetCode.p;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by payne on 2018-01-10.
 * About 类描述：
 * Given a List of words,
 * return the words that can be typed using letters of alphabet on
 * only one row's of American keyboard like the image below.
 */
public class P_500_KeyboardRow {

    public String[] findWords(String[] words) {
        return my(words);
    }


    public String[] my(String[] words) {

        HashMap<String, String> mapHigh = new HashMap<>();
        mapHigh.put("Q", "Q");
        mapHigh.put("q", "q");
        mapHigh.put("W", "W");
        mapHigh.put("w", "w");
        mapHigh.put("E", "E");
        mapHigh.put("e", "e");
        mapHigh.put("R", "R");
        mapHigh.put("r", "r");
        mapHigh.put("T", "T");
        mapHigh.put("t", "t");
        mapHigh.put("Y", "Y");
        mapHigh.put("y", "y");
        mapHigh.put("U", "U");
        mapHigh.put("u", "u");
        mapHigh.put("I", "I");
        mapHigh.put("i", "i");
        mapHigh.put("O", "O");
        mapHigh.put("o", "o");
        mapHigh.put("P", "P");
        mapHigh.put("p", "p");
        HashMap<String, String> mapMid = new HashMap<>();
        mapMid.put("a", "a");
        mapMid.put("s", "s");
        mapMid.put("d", "d");
        mapMid.put("f", "f");
        mapMid.put("g", "g");
        mapMid.put("h", "h");
        mapMid.put("j", "j");
        mapMid.put("k", "k");
        mapMid.put("l", "l");
        mapMid.put("A", "A");
        mapMid.put("S", "S");
        mapMid.put("D", "D");
        mapMid.put("F", "F");
        mapMid.put("G", "G");
        mapMid.put("H", "H");
        mapMid.put("J", "J");
        mapMid.put("K", "K");
        mapMid.put("L", "L");
        HashMap<String, String> mapLow = new HashMap<>();
        mapLow.put("z", "z");
        mapLow.put("x", "x");
        mapLow.put("c", "c");
        mapLow.put("v", "v");
        mapLow.put("b", "b");
        mapLow.put("n", "n");
        mapLow.put("m", "m");
        mapLow.put("Z", "Z");
        mapLow.put("X", "X");
        mapLow.put("C", "C");
        mapLow.put("V", "V");
        mapLow.put("B", "B");
        mapLow.put("N", "N");
        mapLow.put("M", "M");

        List<String> result = new ArrayList<>();
        for (String temp : words) {
            int f = 0;
            boolean can = true;
            for (int i = 0; i < temp.length(); i++) {
                if (temp.length() == 1) {
                    break;
                }
                String one = temp.substring(i, i + 1);
                if (f == 0) {
                    if (mapHigh.containsValue(one)) {
                        f = 1;
                    }
                    if (mapMid.containsValue(one)) {
                        f = 2;
                    }
                    if (mapLow.containsValue(one)) {
                        f = 3;
                    }
                    continue;
                }

                if (f == 1) {
                    if (!mapHigh.containsValue(one)) {
                        can = false;
                        break;
                    }
                }

                if (f == 2) {
                    if (!mapMid.containsValue(one)) {
                        can = false;
                        break;
                    }
                }

                if (f == 3) {
                    if (!mapLow.containsValue(one)) {
                        can = false;
                        break;
                    }
                }

            }
            if (can) {
                result.add(temp);
            }
        }
        return result.toArray(new String[result.size()]);

    }

}
