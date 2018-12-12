package com.payne.study;

import com.payne.beans.SingletonTest;
import com.payne.beans.Student;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.net.URL;

/**
 * Project    arithmetic-project-git
 * Path       com.payne.study
 * Date       2018/09/19 - 10:24
 * Author     Payne.
 * About      类描述：
 */

public class ReflectRelate {


    public static void test() throws Exception {

        studentTest();

        //singleTest();

        //loaderTest();

    }

    private static void loaderTest() throws Exception {
        ClassLoader loader = ReflectRelate.class.getClassLoader();
        ClassLoader tem = loader;
        while (tem != null) {
            System.out.println(" tem = " + tem);
            tem = tem.getParent();
        }

        URL[] urls = sun.misc.Launcher.getBootstrapClassPath().getURLs();
        for (int i = 0; i < urls.length; i++) {
            System.out.println(urls[i].toExternalForm());
        }

        System.out.println(System.getProperty("sun.boot.class.path"));


    }

    private static void studentTest() throws Exception {
//        ClassLoader loader = ClassLoader.getSystemClassLoader();
        ClassLoader loader = ReflectRelate.class.getClassLoader();
        ClassLoader tem = loader;
        while (tem != null) {
            System.out.println(" tem = " + tem);
            tem = tem.getParent();
        }


        Class cls = loader.loadClass("com.payne.beans.Student");
        System.out.println(" cls = " + cls.toString());

        Object obj = cls.newInstance();
        System.out.println(" obj = " + obj.toString());

        Constructor con = cls.getDeclaredConstructor(int.class);
        System.out.println(" con = " + con.toString());

        Student student = (Student) con.newInstance(10);
        student.name = "xk";
        System.out.println(" student: " + student.toString());

        Method sayhi = cls.getMethod("sayHi");
        sayhi.invoke(student);
        sayhi.invoke(cls.getDeclaredConstructor(String.class).newInstance("430"));

        Method explain = cls.getMethod("explain");
        explain.invoke(null);


        Method init = cls.getDeclaredMethod("init", String.class);
        init.setAccessible(true);
        init.invoke(null, "ggg");

        Object obj2 = cls.newInstance();
        System.out.println(obj2.toString());
        Field field = cls.getDeclaredField("ic");
        field.setAccessible(true);
        field.set(obj2, 10);
        System.out.println(obj2.toString());

        Method getFinal = cls.getDeclaredMethod("getFinalString");
        getFinal.setAccessible(true);
        int f = (int) getFinal.invoke(null);
        System.out.println(" final = " + f);
        System.out.println(obj2.toString());


        //反射破坏final
        Field field2 = cls.getDeclaredField("finalString");
        field2.setAccessible(true);

        Field modifiersField = Field.class.getDeclaredField("modifiers");
        modifiersField.setAccessible(true);
        modifiersField.setInt(field2, field2.getModifiers() & ~Modifier.FINAL);

        field2.set(null, 9);

        Method getFinal2 = cls.getDeclaredMethod("getFinalString");
        getFinal2.setAccessible(true);
        int f2 = (int) getFinal2.invoke(null);
        System.out.println(" final = " + f2);
        System.out.println(field2.get("finalString"));
        System.out.println(obj2.toString());
        //System.out.println(field.get("ic"));


    }


    /**
     * 反射破坏单例模式
     */
    private static void singleTest() throws Exception {
        Class cls = Class.forName("com.payne.beans.SingletonTest");
        Constructor con = cls.getDeclaredConstructor();
        con.setAccessible(true);


        System.out.println(SingletonTest.getInstance().getS());


        // 通过反射获取实例
        Field field1 = cls.getDeclaredField("isFirst");
        field1.setAccessible(true);
        field1.set(null, true);
        SingletonTest singetonTest1 = (SingletonTest) con.newInstance();

        Field field = cls.getDeclaredField("isFirst");
        field.setAccessible(true);
        field.set(null, true);
        SingletonTest singetonTest2 = (SingletonTest) con.newInstance();
        System.out.println("singetonTest1.getS() = " + singetonTest1.getS() + "; singetonTest2.getS() = " + singetonTest2.getS());
        System.out.println(SingletonTest.getInstance().getS());

        singetonTest1.setS(100);
        System.out.println("singetonTest1.getS() = " + singetonTest1.getS() + "; singetonTest2.getS() = " + singetonTest2.getS());
        System.out.println(SingletonTest.getInstance().getS());

        singetonTest2.setS(200);
        System.out.println("singetonTest1.getS() = " + singetonTest1.getS() + "; singetonTest2.getS() = " + singetonTest2.getS());
        System.out.println(SingletonTest.getInstance().getS());

        SingletonTest.getInstance().setS(300);
        System.out.println("singetonTest1.getS() = " + singetonTest1.getS() + "; singetonTest2.getS() = " + singetonTest2.getS());
        System.out.println(SingletonTest.getInstance().getS());


        System.out.println(Integer.class);
        System.out.println(int.class);
    }

}
