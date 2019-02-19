package com.payne.leetCode.contest.weekly_123;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * Project    arithmetic-project-git
 * Path       com.payne.leetCode.contest.weekly_123
 * Date       2019/02/13 - 15:13
 * Author     Payne.
 * About      类描述：
 */

public class P_990 {

    /**
     * https://leetcode.com/contest/weekly-contest-123/problems/satisfiability-of-equality-equations/
     */

    private static final String EQUAL = "==";
    private static final String UNEQUAL = "!=";

    public boolean equationsPossible(String[] equations) {
        List<String> unequals = new ArrayList<>();
        for (int i = 0; i < equations.length; i++) {
            String symbol = equations[i].substring(1, 3);
            if (UNEQUAL.equals(symbol)) {
                unequals.add(equations[i]);
            }else {
                String e1 = equations[i].substring(0, 1);
                String e2 = equations[i].substring(3, 4);
            }

        }
        for(int i=0;i<unequals.size();i++){

        }
        return true;
    }


    static class Box{
        private Map<String,String> map;
        Box(){
            map=new HashMap<>();
        }
        void add(String s){
            map.put(s,s);
        }
        void add(Map<String,String> map){
            this.map.putAll(map);
        }
        boolean contain(String s){
            return map.containsKey(s);
        }

        static Box combine(Box b1,Box b2){
            Box box=new Box();
            box.add(b1.map);
            box.add(b2.map);
            return box;
        }
    }


}
