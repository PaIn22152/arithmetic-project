package com.payne;

import com.payne.leetCode.contest.weekly_114.P_955_DeleteColumnsToMakeSortedII;
import com.payne.utils.PrintHelper;

public class Main {

    public static void main(String[] args) {
        /*P_12_Integer2Roman p12 = new P_12_Integer2Roman();
        String s = p12.intToRoman(1900);
        System.out.println(" s = " + s);

        P_13_Roman2Integer p13 = new P_13_Roman2Integer();
        int I = p13.romanToInt(s);
        System.out.println(" I = " + I);

        Long t1 = System.currentTimeMillis();
        P_5_LongestPalindromicSubstring p5 = new P_5_LongestPalindromicSubstring();
        //String input = "aaaaaaaaaaaaaaaaaabcaaaaaaaaaaaaaaaaa";
        String input = "abba";
        String s = p5.longestPalindrome(input + input + input + input);
        Long t2 = System.currentTimeMillis();
        System.out.println("input length = " + input.length() + "; s = " + s + ";  time = " + (t2 - t1));

        P_728_SelfDividingNumbers p728 = new P_728_SelfDividingNumbers();
        List<Integer> list = p728.selfDividingNumbers(1, 22);
        System.out.print("");

        P_557_ReverseWords p557 = new P_557_ReverseWords();
        String s = p557.reverseWords("Let's take LeetCode contest");
        System.out.println(" s = " + s);*/

        /*P_44_WildcardMatching p44 = new P_44_WildcardMatching();
        boolean match = p44.isMatch("ab", "?*");
        System.out.println(" match = " + match);*/


       /* HashMap<String ,String> map=new HashMap<>();
        map.put("1","11");
        map.put("2","22");
        map.put("3","33");
        map.put("4","44");
        map.get("1");*/


        /*Long l = (long) (1000 * 60 * 60 * 24 * 30);
        Long l2 = (long) (1000 * 60 * 60 * 24);
        Long l3 = l2 * 30;
        System.out.println(" l = " + l);
        System.out.println(" l2 = " + l2);
        System.out.println(" l3 = " + l3);


        //初始化数据
        List<User> userList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            User user = new User();
            user.setUserName("lilongsheng" + i);
            userList.add(user);
        }

        //命令式方式实现
        List<String> newUserNameList1 = new ArrayList<>();
        for (int i = 0; i < userList.size(); i++) {
            User user = userList.get(i);
            newUserNameList1.add(user.getUserName());
        }


        //函数式方式实现 java 8 funcational
        List<String> newUserNameList2 = userList.stream()
                .map(p -> p.getUserName())
                .collect(Collectors.toList());*/


//        P_44_WildcardMatching p_44_wildcardMatching=new P_44_WildcardMatching();
//        System.out.println(p_44_wildcardMatching.isMatch("abc","*abc*bbb"));
//        System.out.println(p_44_wildcardMatching.isMatch("abcc","a**b"));
//        System.out.println(p_44_wildcardMatching.isMatch("abc","a*"));

        /*int num = 100;
        P_504_Base7 p_504_base7 = new P_504_Base7();
        System.out.println(num + " = " + p_504_base7.convertToBase7(num));*/

//        int num = -2147483648;
//        P_7_ReverseInteger p_7_reverseInteger = new P_7_ReverseInteger();
//        System.out.println(p_7_reverseInteger.reverse(num));

//        System.out.println(" MAX_VALUE ="+Integer.MAX_VALUE);
//        System.out.println(" MIN_VALUE ="+Integer.MIN_VALUE);


        char[][] board = {
                {'X', 'X', 'X', 'X'},
                {'X', 'O', 'O', 'X'},
                {'X', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'X'},
                {'X', 'O', 'X', 'X'},
        };

//        P_130_SurroundedRegions p_130_surroundedRegions = new P_130_SurroundedRegions();
//        p_130_surroundedRegions.solve(board);


//        P_402_RemoveKDigits p_402_removeKDigits=new P_402_RemoveKDigits();
//        System.out.println(p_402_removeKDigits.removeKdigits("10",1));


//        long lastTime = System.currentTimeMillis();
//        P_440_K_th_Smallest_in_Lexicographical_Order p_440 = new P_440_K_th_Smallest_in_Lexicographical_Order();
//        System.out.println(p_440.findKthNumber(1001, 99));//9649407
//        System.out.println(System.currentTimeMillis() - lastTime);

//        P_413_ArithmeticSlices p413 = new P_413_ArithmeticSlices();
//        int[] ints = {1, 2, 3, 4};
//        System.out.println(p413.numberOfArithmeticSlices(ints));

//        P_479LargestPalindromeProduct p479=new P_479LargestPalindromeProduct();
//        System.out.println(p479.isPalindrome("sdkds"));

//        P_859_BuddyStrings p859=new P_859_BuddyStrings();
//        System.out.println(p859.buddyStrings("acccccb","bccccca"));


//        try {
//            ReflectRelate.test();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        Pattern.quote(".");


//        File oldFile=new File("C:\\Users\\AF-USER-1\\Desktop\\cacheFiles\\bsdiff\\new2.jar");
//        File newFile=new File("C:\\Users\\AF-USER-1\\Desktop\\cacheFiles\\bsdiff\\new3.jar");
//        File patchFile=new File("C:\\Users\\AF-USER-1\\Desktop\\cacheFiles\\bsdiff\\patch23.patch");
//        try {
//            BSDiff.bsdiff(oldFile,newFile,patchFile);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        File newFile2=new File("C:\\Users\\AF-USER-1\\Desktop\\cacheFiles\\bsdiff\\out.jar");
//        try {
//            BSPatch.patchFast(oldFile,newFile2,patchFile,1024);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }


        //Test.Test();

//        P_6_ZigZagConversion p6=new P_6_ZigZagConversion();
//        String s="PAYPALISHIRING";
//        System.out.println(p6.convert(s,3));

//        PrintHelper.println("start");
//        P_5_LongestPalindromicSubstring p5=new P_5_LongestPalindromicSubstring();
//        String s="";
//
//        PrintHelper.println(p5.longestPalindrome(s));


//        Z_ValidBracket z = new Z_ValidBracket();
//        String s = "([)]";
//        PrintHelper.println(z.checkValid(s) + "");


//        P_14_LongestCommonPrefix p14=new P_14_LongestCommonPrefix();
//        String[] ss={"a","b"};
//        PrintHelper.println(p14.longestCommonPrefix(ss));


//        P_45_JumpGameII p45 = new P_45_JumpGameII();
//        int[] is = new int[]{4,4,1,1,2,3,1,1,1,3,1,2,5,1};
//        p45.jump(is);

//        int[] is= StringConvertor.string2IntArray("getInstance");
//        PrintHelper.println(is);

//        int[] is2={90,129,42,64,58,97,90,13,94,92,26,39,51};
//        String s= StringConvertor.intArray2String(is2);
//        PrintHelper.println(s);


//        P_949_LargestTimeforGivenDigits p949=new P_949_LargestTimeforGivenDigits();
//        int[] is={2,2,2,2};
//        PrintHelper.println( p949.largestTimeFromDigits(is));


//        P_953_VerifyingAnAlienDictionary p953=new P_953_VerifyingAnAlienDictionary();
//        String[] words={"hello","leetcode"};
//        String order="hlabcdefgijkmnopqrstuvwxyz";
//        PrintHelper.println(p953.isAlienSorted(words,order));

//        P_954_ArrayOfDoubledPairs p954=new P_954_ArrayOfDoubledPairs();
//        int[] is={7,-15,-15,23,-3,80,-35,40,68,22,44,98,20,0,-34,8,40,41,16,46,16,49,-6,-11,35,-15,-74,72,-8,60,40,-2,0,-6,34,14,-16,-92,54,14,-68,82,-30,50,22,25,16,70,-1,-96,11,45,54,40,92,-35,29,80,46,-30,27,7,-70,-37,41,-46,-98,1,-33,-24,-86,-70,80,-43,98,-49,30,0,27,2,82,36,0,-48,3,-100,58,32,90,-22,-50,-12,36,6,-3,-66,72,8,49,-30};
//        PrintHelper.println(p954.canReorderDoubled(is));

        P_955_DeleteColumnsToMakeSortedII p955=new P_955_DeleteColumnsToMakeSortedII();
        String[] ss={"ca","bb","ac"};
        PrintHelper.println(p955.minDeletionSize(ss));


    }






    private static void t() throws Throwable {
        User u = new User();
        throw u;
    }


    public static class User extends Throwable {

        /**
         * 主键
         */
        private Integer id;
        /**
         * 用户名
         */
        private String userName;
        /**
         * 用户密码
         */
        private String userPassword;
        /**
         * 年龄
         */
        private Integer age;
        /**
         * 电话
         */
        private String phone;

        /*其它属性*/

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public String getUserPassword() {
            return userPassword;
        }

        public void setUserPassword(String userPassword) {
            this.userPassword = userPassword;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }
    }


}
