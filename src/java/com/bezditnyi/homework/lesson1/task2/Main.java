package com.bezditnyi.homework.lesson1.task2;

import java.io.File;
import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author Viktor Bezditnyi
 */
public class Main {
    public static void main (String[] args) {
        Container container = new Container("Zebra, Crocodile");
        SaveTo saveTo = Container.class.getAnnotation(SaveTo.class);
        String path = saveTo.path();

        Method[] methods = Container.class.getMethods();
        for (Method m: methods) {
            if(m.isAnnotationPresent(Saver.class)){
                try {
                    m.invoke(container, path);
                } catch (IllegalAccessException | InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
