package com.bezditnyi.homework.lesson1.task3;

import java.io.*;
import java.lang.reflect.Field;
/**
 * @author Viktor Bezditnyi
 */
public class Main {
    public static void main(String[] args) {
        String path = "src/resources/lesson1/employee.dat";
        Employee worker = new Employee("Adam Smith", "Carpenter", 123L, 2, true);

        System.out.println(worker);
        try
                (FileOutputStream fos = new FileOutputStream(path);
                ObjectOutputStream oos = new ObjectOutputStream(fos))
        {
            oos.writeObject(worker);
        } catch (IOException e){
            e.printStackTrace();
        }

        try
                (FileInputStream fis = new FileInputStream(path);
                 ObjectInputStream ois = new ObjectInputStream(fis))
        {
            worker = (Employee) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(worker);
    }
}
