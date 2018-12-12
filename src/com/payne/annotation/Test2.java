package com.payne.annotation;

/**
 * Project    arithmetic-project-git
 * Path       com.payne.annotation
 * Date       2018/11/13 - 10:13
 * Author     Payne.
 * About      类描述：
 */

public class Test2 {

    public static void test(){
        boolean hasAnno=Test.class.isAnnotationPresent(TestAnno.class);
        if(hasAnno){
            TestAnno anno=Test.class.getAnnotation(TestAnno.class);
            int id = anno.id();
            String msg=anno.msg();
        }
    }
}
