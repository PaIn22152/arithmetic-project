package com.payne;

import com.payne.leetCode.P_44_WildcardMatching;
import com.payne.leetCode.P_504_Base7;
import com.payne.leetCode.P_7_ReverseInteger;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

        int num = -2147483648;
        P_7_ReverseInteger p_7_reverseInteger = new P_7_ReverseInteger();
        System.out.println(p_7_reverseInteger.reverse(num));

//        System.out.println(" MAX_VALUE ="+Integer.MAX_VALUE);
//        System.out.println(" MIN_VALUE ="+Integer.MIN_VALUE);

    }


    public static class User {

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
