package com.eric.leetcode.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectTest {

    public void reflectTest() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class<?> IntClass = Class.forName("java.lang.Integer");
        Field[] fields = IntClass.getDeclaredFields();

        for (Field field : fields) {
            System.out.println("field : " + field);
        }
        Integer s = 250;
        Method toString = IntClass.getDeclaredMethod("toString");
        System.out.println(toString.invoke(s));
    }

    public static void main(String args[]) {
        System.out.println("main start");
        ReflectTest reflectTest = new ReflectTest();
        try {
            reflectTest.reflectTest();
        } catch (ClassNotFoundException
                | NoSuchMethodException
                | InvocationTargetException
                | IllegalAccessException e) {
            e.printStackTrace();
        }
        System.out.println("main finish");
    }
}
