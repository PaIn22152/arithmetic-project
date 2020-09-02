package com.payne;

import com.payne.leetCode.contest.DW_18;
import com.payne.leetCode.contest.Weekly_197;
import com.payne.leetCode.daily.*;
import com.payne.leetCode.p_s.P_130_SurroundedRegions;
import com.payne.leetCode.p_s.P_26_RemoveDuplicatesfromSortedArray;
import com.payne.leetCode.p_s.P_763;
import com.payne.leetCode.p_s.P_805;
import com.payne.leetCode.p_s.P_array;
import com.payne.leetCode.solutions.P_16;
import com.payne.leetCode.contest.Weekly_179;
import com.payne.leetCode.contest.weekly_165.P_1275;
import com.payne.leetCode.interview.Random1;
import com.payne.leetCode.interview.Random2;
import com.payne.leetCode.interview.Random3;
import com.payne.leetCode.p_s.P_148;
import com.payne.utils.PrintHelper;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static int roundToTimesOfFour(int value) {
        return (value + 3) & (~3);
    }

    private static void test() {


//            String s="she1.2.1";
//            PrintHelper.println(StringConvertor.string2IntArray(s));


        //StringEncryptUtil.main();

//            PrintHelper.start();
//            P_967 p_957=new P_967();
//            PrintHelper.println(p_957.numsSameConsecDiff2(9,3));
//            PrintHelper.end();

//            P_10 p10=new P_10();
//            PrintHelper.println(p10.isMatch("abcd","a..d"));

        //int[] is= IntegerArrayCreator.getRandomArray(4);
//            int[] is = {3, 2, 1, 4};
//            PrintHelper.println(is);
//
//            P_969 p969 = new P_969();
//            PrintHelper.println(p969.pancakeSort(is));
//
//            PrintHelper.println(is);


        //2147483647
        //PrintHelper.println(Integer.MAX_VALUE);


//            P_970 p970=new P_970();
//            PrintHelper.println(p970.powerfulIntegers(1,1,2));

//            Stack<String> s=new Stack<>();
//            s.add("1");
//            s.push("2");
//            s.add("3");
//            s.push("4");
//            PrintHelper.println(s);
//            PrintHelper.println(s.peek());
//            PrintHelper.println(s);
//            s.pop();
//            PrintHelper.println(s);

//            ArrayDeque<String> s=new ArrayDeque<>();
//            s.add("1");
//            s.addFirst("2");
//            s.addLast("3");
//            s.push("4");
//            s.add("5");
//
//            PrintHelper.println(s);
//            PrintHelper.println(s.peek());
//            PrintHelper.println(s);
//            PrintHelper.println(s.pop());
//            PrintHelper.println(s);
//            PrintHelper.println(s.poll());
//            PrintHelper.println(s);


//            PriorityQueue<String> pq = new PriorityQueue<>();
//            pq.add("abc");
//            pq.add("abb");
//            pq.add("aaa");
//            PrintHelper.println(pq);
//            PrintHelper.println(pq.peek());
//            PrintHelper.println(pq);
//            PrintHelper.println(pq.poll());
//            PrintHelper.println(pq);
//            PrintHelper.println(pq.poll());
//            PrintHelper.println(pq);

//            LinkedList<String> linkedList = new LinkedList<>();
//            linkedList.addLast("1");
//            linkedList.addLast("2");
//            linkedList.addLast("3");
//            PrintHelper.println(linkedList);
//
//            PrintHelper.println(linkedList.offerFirst("4"));
//
//            PrintHelper.println(linkedList.getFirst());
//            PrintHelper.println(linkedList);
//
//            PrintHelper.println(linkedList.removeFirst());
//            PrintHelper.println(linkedList);
//
//            PrintHelper.println(linkedList.removeFirstOccurrence("3") + "");
//            PrintHelper.println(linkedList);


//           Integer[] is={5,4,1,2,3};
//           PrintHelper.println(is);
//            Arrays.sort(is, new Comparator<Integer>() {
//                @Override
//                public int compare(Integer o1, Integer o2) {
//                    return o2-o1;
//                }
//
//                @Override
//                public boolean equals(Object obj) {
//                    return false;
//                }
//            });
//            PrintHelper.println(is);
//
//
//            String[] ss={"bc","ab","abc","bb"};
//            PrintHelper.println(ss);
//            Arrays.sort(ss);
//            PrintHelper.println(ss);
//
//            ArrayList<Integer> list=new ArrayList<>();
//            list.add(6);
//            list.add(5);
//            list.add(1);
//            list.add(2);
//            PrintHelper.println(list);
//            //Collections.sort(list);
//            //PrintHelper.println(list);
//
//            Collections.sort(list, (o1, o2) -> o2-o1);
//            PrintHelper.println(list);


//            P_978 p_978=new P_978();
//            int[] A ={0,1,1,0,1,0,1,1,0,0};
//            PrintHelper.println(p_978.maxTurbulenceSize(A));

//            P_989 p_989=new P_989();
//            int[] i={2,7,4,0,0};
//            int K=181;
//            PrintHelper.println(p_989.addToArrayForm(i,K));

//        P_990 p_990=new P_990();
//        String[] ss={"c==g","f!=a","f==b","b==c","h==i"};
//        PrintHelper.println(p_990.equationsPossible(ss));

//        P_996 p_996=new P_996();
//        int[] a={1,17,8};
//        PrintHelper.println(p_996.numSquarefulPerms(a));

//        P_78 p_78=new P_78();
//        int[] nums={1,2,3};
//        PrintHelper.println(p_78.subsets(nums));

//        P_1030 p_1030=new P_1030();
//        int[][] ints = p_1030.allCellsDistOrder(1, 2, 0, 0);
//
//        PrintHelper.println(ints);


//        int[][] cost={{518,518},{71,971},{121,862},{967,607},{138,754},
//                {513,337},{499,873},{337,387},{647,917},{76,417}};
//        P_1029 p_1029=new P_1029();
//        int i = p_1029.twoCitySchedCost(cost);

//        P_5232 p_5232=new P_5232();
//        p_5232.balancedString("WWEQERQWQWWRWWERQWEQ");
//        p_5232.balancedString("WQWRQQQW");

//        P_5230 p_5230 = new P_5230();
//        int[][] is = {{1, 1}, {2, 2}, {3, 4}, {4, 5}, {5, 6}, {7, 7}};
//        p_5230.checkStraightLine(is);

//        PrintHelper.start();
//        P_62 p_62 = new P_62();
//        PrintHelper.println(p_62.uniquePaths(51, 9));
//        PrintHelper.end();


//        PrintHelper.println(Hex2Dec.convert("0xzz"));

//        P_54 p_54=new P_54();
//        int[][] m={{1,2,3},{4,5,6},{7,8,9},{1,2,3}};
//        PrintHelper.println(p_54.spiralOrder(m));

//        P_88 p_88=new P_88();
//        int[] i1={1,2,3,0,0,0};
//        int[] i2={2,5,6};
//        p_88.merge(i1,3,i2,3);


//        P_997 p_997=new P_997();
//        int[][] ii={{1,2}};
//        PrintHelper.println(p_997.findJudge(2,ii));

//        P_1006 p_1006=new P_1006();
//        p_1006.clumsy(10);

//        FileUtil.del("C:\\Users\\AF-USER-1\\Desktop\\cacheFiles\\cleaner\\rtr.txt");


//        P_1238 p_1238=new P_1238();
//        p_1238.getValidNumber(7,3);

//        P_1266 p_1266=new P_1266();
//        int[][] is={{3,2},{-2,2}};
//        int t= p_1266.minTimeToVisitAllPoints(is);
//        System.out.println("t = "+t);


//        P_1268 p_1268=new P_1268();
//        String[] strings={"m"};
//        p_1268.suggestedProducts(strings,"abcdef");

//        P_1275 p_1275=new P_1275();
//        int[][] input={{0,0},{2,0},{1,1},{2,1},{2,2}};
//        p_1275.tictactoe(input);

//        Weekly_179 weekly_179=new Weekly_179();
//        int[] is={2,1,3,5,4};
//        weekly_179.numTimesAllBlue(is);

//        Random1 random1 = new Random1();
//        int[][] tt =
//                {
//                        {1, 2, 7},
//                        {3, 6, 7}
//                };
//        random1.numBusesToDestination(tt,1,6);

//        Random2 random2 = new Random2();
//        int[] t = {2, 5, 3, 4, 1};
//        random2.numTeams(t);
//        random2.knightProbability(8,30,6,4);


//        Random3 random3 = new Random3();
//        int[][] tt =
//                {
//                        {1, 2, 3},
//                        {4, 5, 6},
//                        {7, 8, 9}
//                };
//        random3.findDiagonalOrder(tt);


//        P_148 p_148=new P_148();
//        List<Integer> list=new ArrayList<>();
//        list.add(1);
//        list.add(4);
//        list.add(2);
//        list.add(3);
//        list.add(6);
//        list.add(2);
//        List<Integer> sort = p_148.sort(list);

//        D_696 d_696 = new D_696();
////        int i=d_696.countBinarySubstrings(s);
//        int i = d_696.countBinarySubstrings("001100");
//        d();
//
//        List<Integer> list = new ArrayList<>();
//        list.add(0);
//        list.add(1);
//        list.add(2);
//        list.add(2);
//        List<Integer> list1 = list.subList(0, 3);
//        d();
//        List<Integer> list2 = list.subList(1, 2);
//        d();
//
//        boolean b1 = list.get(2) == list.get(3);
//        d();
//        boolean b2 = list.get(2).equals(list.get(3));
//        d();


        P_130_SurroundedRegions p130 = new P_130_SurroundedRegions();
        char[][] cc = {
                {'O', 'X', 'O', 'O', 'O', 'O', 'O', 'O', 'O'},
                {'O', 'O', 'O', 'X', 'O', 'O', 'O', 'O', 'X'},
                {'O', 'X', 'O', 'X', 'O', 'O', 'O', 'O', 'X'},
                {'O', 'O', 'O', 'O', 'X', 'O', 'O', 'O', 'O'},
                {'X', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'X'},
                {'X', 'X', 'O', 'O', 'X', 'O', 'X', 'O', 'X'},
                {'O', 'O', 'O', 'X', 'O', 'O', 'O', 'O', 'O'},
                {'O', 'O', 'O', 'X', 'O', 'O', 'O', 'O', 'O'},
                {'O', 'O', 'O', 'O', 'O', 'X', 'X', 'O', 'O'}};
//        char[][] cc={{'X','X','X','X'},{'X','O','O','X'},{'X','X','O','X'},{'X','O','X','X'}};
//        char[][] cc = {
//                {'X', 'O', 'X', 'O', 'X', 'O'},
//                {'O', 'X', 'O', 'X', 'O', 'X'},
//                {'X', 'O', 'X', 'O', 'X', 'O'},
//                {'O', 'X', 'O', 'X', 'O', 'X'}};
//        p130.solve(cc);
//        d();


//        P_763 p_763=new P_763();
//        p_763.partitionLabels3("ababcbacadefegdehijhklij");


//        P_26_RemoveDuplicatesfromSortedArray p26=new P_26_RemoveDuplicatesfromSortedArray();
//        int[] i={0,0,0,1,1,1,2,2,3,3,4};
//        p26.removeDuplicates(i);


//        D_43 d_43 = new D_43();
//        String s1 = "81234134134523452344523452345234523345234523445234523452334134523452344523452345234523452345341345234523445234523452345232";
//        String s2 = "812341345234523445234523452345234544523452345234523345234523445234544523452345234523345234523445234523452334134523452344523452345234234523341345234523445234523452342";
////        String sss = d_43.multiply(s1, s2);
//        String sss = d_43.multiply3("32", "123");

//        P_805 p_805=new P_805();
//        int[] a={10,29,13,53,33,48,76,70,5,5};
//        boolean b=p_805.splitArraySameAverage(a);

//        Weekly_197 weekly_197=new Weekly_197();
//        int i=weekly_197.numSub("0110111");

//        D_647 d_647=new D_647();
//        int i=d_647.countSubstrings3("abcccaa");//11
//        int i=d_647.countSubstrings3("cabbaf");//8
//        int i=d_647.countSubstrings2("abc");


//        D_529 d_529 = new D_529();
//        char[][] b = {
//                {'E', 'E', 'E', 'E', 'E'},
//                {'E', 'E', 'M', 'E', 'E'},
//                {'E', 'E', 'E', 'E', 'E'},
//                {'E', 'E', 'E', 'E', 'E'}};
////        char[][] b = {
////                {'1', '2', '3',},
////                {'4', '5', '6',}};
//        int[] p = {3, 0};
//        d_529.updateBoard(b, p);

//        D_679 d_679 = new D_679();
//
////        boolean b=d_679.judgePoint24(new int[]{1, 2, 1, 2});
//        boolean b=d_679.judgePoint24(new int[]{1, 3, 4, 6});

//        D_201 d_201=new D_201();
//        int i=d_201.rangeBitwiseAnd(2147483646,2147483647);

//        P_array p_array=new P_array();
//        int i=p_array.pivotIndex(new int[]{1,7,3,6,5,6});

//        D_491 d_491=new D_491();
//        d_491.findSubsequences(new int[]{1,3,5,7});

//        D_17 d_17=new D_17();
////        d_17.letterCombinations("2379");
//        d_17.letterCombinations("23");

        //[["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
//        List<List<String>> input=new ArrayList<>();
//
//        List<String> l1=new ArrayList<>();
//        l1.add("JFK");
//        l1.add("SFO");
//        input.add(l1);
//
//        List<String> l2=new ArrayList<>();
//        l2.add("JFK");
//        l2.add("ATL");
//        input.add(l2);
//
//        List<String> l3=new ArrayList<>();
//        l3.add("SFO");
//        l3.add("ATL");
//        input.add(l3);
//
//        List<String> l4=new ArrayList<>();
//        l4.add("ATL");
//        l4.add("JFK");
//        input.add(l4);
//
//        List<String> l5=new ArrayList<>();
//        l5.add("ATL");
//        l5.add("SFO");
//        input.add(l5);
//
//        D_332 d_332=new D_332();
//        List<String> itinerary = d_332.findItinerary(input);


//        D_486 d_486 = new D_486();
//        int[] is = new int[]{1, 5, 2};
//        d_486.PredictTheWinner(is);

        D_O_20 d_o_20=new D_O_20();
        boolean b=d_o_20.isNumber("1");
        d();
    }

    public static void d() {

    }

    public static boolean B = true;


    private static String getDay() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH");
        return simpleDateFormat.format(new java.util.Date());
    }

    private static void t(Object o) {
        PrintHelper.println(o instanceof Boolean);
    }

    public static void main(String[] args) {

        test();

//        DW_18 dw_18 = new DW_18();
//        int[] i = {28, -21, 30, 33, 24, 15, 46, 21, 8, -9, -2, -31,
//                0, 27, -2, 33, -4, 31, 38, 5, -20, -45, -18};
//        dw_18.arrayRankTransform(i);


    }


}
