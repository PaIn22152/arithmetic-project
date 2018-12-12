package com.payne.beans;

import com.sun.deploy.util.SyncAccess;

/**
 * Project    arithmetic-project-git
 * Path       com.payne.beans
 * Date       2018/09/19 - 10:25
 * Author     Payne.
 * About      类描述：
 */

public final class Student{
    private int age;
    public String name;
    private int ic;

    private static final int finalString = 1;

    public static int getFinalString() {
        return finalString;
    }

    public Student(){
        System.out.println(" Student() ");
    }

    public Student(String name){
        this.name=name;
        System.out.println(" Student(String name) ");
    }

    public Student(int ic){
        this.ic=ic;
        System.out.println(" Student(int ic) ");
    }

    public int getAge() {
        System.out.println(" getAge() ");
        return age;
    }

    public void setAge(int age) {
        System.out.println(" setAge(int age) ");
        this.age = age;
    }

    public void sayHi(){
        System.out.println(" hi,my name is "+name);
    }

    public static void explain(){
        System.out.println(" I'm a student ");
    }

    private static void init(String s){
        System.out.println(" init  s = "+s);
    }

    @Override
    public String toString() {
        return "name = "+name+" ; age = "+age+" ; ic = "+ic+";   finalString = "+finalString;
    }

    @Override
    public int hashCode() {
        return ic;
        //return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return this.ic==((Student)obj).ic;
       // return super.equals(obj);
    }
}
