package com.bezditnyi.homework.lesson1.task2v2;

import com.bezditnyi.homework.lesson1.task2.*;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author Viktor Bezditnyi
 */
public class Main {
    public static void main (String[] args) {
        TextContainer tc = new TextContainer("Zebra, Elephant");
//        SaveTo saveTo = TextContainer.class.getAnnotation(SaveTo.class);
        String path = TextContainer.class.getAnnotation(SaveTo.class).path();
        Method[] methods = Container.class.getMethods();
        for (Method m: methods) {
            if(m.isAnnotationPresent(Saver.class)){
                try {
                    m.invoke(tc, path);
                } catch (IllegalAccessException | InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
