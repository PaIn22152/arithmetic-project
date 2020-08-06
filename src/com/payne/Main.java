package com.payne;

import com.payne.leetCode.contest.Weekly_179;
import com.payne.leetCode.contest.weekly_165.P_1275;
import com.payne.leetCode.interview.Random1;
import com.payne.leetCode.interview.Random2;
import com.payne.leetCode.interview.Random3;
import com.payne.utils.PrintHelper;

import java.text.SimpleDateFormat;

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


        Random3 random3 = new Random3();
        int[][] tt =
                {
                        {1, 2, 3},
                        {4, 5, 6},
                        {7, 8, 9}
                };
        random3.findDiagonalOrder(tt);

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


    }


}
