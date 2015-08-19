package com.bezditnyi.homework.lesson1.task1;

import java.lang.annotation.Annotation;
import java.lang.reflect.Modifier;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author Viktor Bezditnyi
 */
public class Main {
    public static void main(String[] args){

        //static method of SomeClass
        Method[] methods = SomeClass.class.getMethods();
        for(Method m: methods){
            if(m.isAnnotationPresent(Test.class)){
                Test ta = m.getAnnotation(Test.class);
                try {
                    System.out.println("Method \'" + m.getName() + "\' of class \'" + m.getDeclaringClass().getName() + "\'");
                    m.invoke(null, ta.a(), ta.b());
                } catch (IllegalAccessException | InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }

        //non-static and static methods of OtherClass, object is used
        OtherClass sc = new OtherClass();
        methods = sc.getClass().getMethods();
        for(Method m: methods){
            if(m.isAnnotationPresent(Test.class)){
                Test ta = m.getAnnotation(Test.class);
                try {
                    System.out.print("Method \'" + m.getName() + "\'");
                    if(!Modifier.isStatic(m.getModifiers())) {
                        System.out.print(" of object");
                    }
                    System.out.println(" of class \'" + m.getDeclaringClass().getName() + "\'");
                    m.invoke(sc, ta.a(), ta.b());
                } catch (IllegalAccessException | InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }

        //get the annotation values example
//        Class<?>[] paramTypes = {int.class, int.class};
//        try {
//            Annotation annotation = sc
//                    .getClass()
//                    .getMethod("testA", paramTypes)
//                    .getAnnotation(Test.class);
//            if (annotation != null){
//                System.out.println("Get annotation valeus:");
//                System.out.println(Test.class.getMethod("a", (Class[]) null).invoke(annotation, (Class[]) null));
//                System.out.println(Test.class.getMethod("b", (Class[])null).invoke(annotation, (Class[])null));
//            }
//        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
//            e.printStackTrace();
//        }
    }
}
