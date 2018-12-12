package com.payne.annotation;

import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.RoundEnvironment;

import javax.lang.model.element.TypeElement;

/**
 * Project    arithmetic-project-git
 * Path       com.payne.annotation
 * Date       2018/11/13 - 10:42
 * Author     Payne.
 * About      类描述：
 */

//@AutoService(Processor.class)
public class MyProcessor extends AbstractProcessor {
    @Override
    public synchronized void init(ProcessingEnvironment env){
        // 主要做一些初始化操作
    }


    @Override
    public boolean process(Set<? extends TypeElement> annoations, RoundEnvironment env) {
        //具体处理注解的逻辑，控制代码的生成
       // processAnnotations();
        return false;
    }


//    @Override
//    public Set<String> getSupportedAnnotationTypes() {
//        // 支持处理的注解类型, 在这里就是@Route
//
//    }
//
//    @Override
//    public SourceVersion getSupportedSourceVersion() {
//        //java版本 如：jdk1.6or jdk1.7
//    }
}
