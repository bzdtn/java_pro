package com.bezditnyi.homework.lesson1.task3;

import java.io.*;
import java.lang.reflect.Field;

/**
 * @author Viktor Bezditnyi
 */
public class Employee implements Externalizable{
//    private static final long serialVersionUID = 1L;
    @Save
    private String name;
    @Save
    private String title;
    @Save
    private long id;
//  @Save
    private int experience;
    @Save
    private boolean isWorking;

    public Employee(String name, String title, long id, int experience, boolean isWorking) {
        this.name = name;
        this.title = title;
        this.id = id;
        this.experience = experience;
        this.isWorking = isWorking;
    }

    public Employee() {
        this("", "", 0L, 0, false);
    }

    @Override
    public String toString() {
        return "Employee: " +
                name + ", " +
                title +
                ", id=" + id +
                ", experience " + experience + " year(s)" +
                (isWorking ? ", still working": ", fired");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Employee employee = (Employee) o;

        if (id != employee.id) return false;
//        if (!name.equals(employee.name)) return false;
        return name.equals(employee.name) && title.equals(employee.title);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + title.hashCode();
        result = 31 * result + (int) (id ^ (id >>> 32));
        return result;
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        Field[] fields = this.getClass().getDeclaredFields();
        for (Field f: fields){
            if (f.isAnnotationPresent(Save.class)){
                try {
                    out.writeObject(f.get(this));
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        Field[] fields = this.getClass().getDeclaredFields();
        for (Field f: fields) {
            if (f.isAnnotationPresent(Save.class)) {
                try {
                    f.set(this, in.readObject());
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
