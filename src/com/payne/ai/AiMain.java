package com.payne.ai;

import java.util.Scanner;

/**
 * Project    arithmetic-project-git
 * Path       com.payne.ai
 * Date       2018/12/21 - 11:01
 * Author     Payne.
 * About      类描述：
 */

public class AiMain {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String str;
        while (true){
            str=sc.next();
            str=str.replace("吗","");
            str=str.replace("？","！");
            str=str.replace("？","！");
            System.out.println(str);
        }
    }
}
