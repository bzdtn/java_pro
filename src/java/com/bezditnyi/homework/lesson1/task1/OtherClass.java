package com.bezditnyi.homework.lesson1.task1;

/**
 * @author Viktor Bezditnyi
 */
public class OtherClass {
    @Test(a=3, b=6)
    public void testA(int a, int b){
        System.out.println("" + a + b);
    }

    @Test(a=3, b=6)
    public static void testB(int a, int b){
        System.out.println(a+b);
    }

}
