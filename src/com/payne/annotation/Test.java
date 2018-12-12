package com.payne.annotation;

/**
 * Project    arithmetic-project-git
 * Path       com.payne.annotation
 * Date       2018/11/13 - 10:02
 * Author     Payne.
 * About      类描述：
 */

@TestAnno(id = 8)
public class Test {

    @SuppressWarnings({"","deprecation"})
    public void main(){
        f1();
        f2();
    }

    @Deprecated
    public void f1(){

    }

    public void f2(){

    }
}
