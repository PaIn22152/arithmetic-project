package com.payne.beans;

/**
 * Project    arithmetic-project-git
 * Path       com.payne.beans
 * Date       2018/09/19 - 11:05
 * Author     Payne.
 * About      类描述：
 */

public class SingletonTest {

    private static SingletonTest singleton = null;
    private int s = 0;
    private static boolean isFirst = true;

    private SingletonTest() throws Exception {
        System.out.println(" SingletonTest() isFirst = " + isFirst);
        if (isFirst) {
            isFirst = false;
        } else {
            throw new Exception("不允许多次构造该类");
        }
    }

    public static synchronized SingletonTest getInstance() {
        if (null == singleton) {
            synchronized (SingletonTest.class) {
                if (null == singleton) {
                    try {
                        singleton = new SingletonTest();
                        System.out.println(" SingletonTest getInstance() new SingletonTest()");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        System.out.println(" SingletonTest getInstance() ");
        return singleton;
    }

    public int getS() {
        return s;
    }

    public void setS(int s) {
        this.s = s;
    }
}
