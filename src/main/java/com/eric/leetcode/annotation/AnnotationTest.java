package com.eric.leetcode.annotation;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class AnnotationTest {

    @Test(value = 250)
    private void printValue(int value) {
        System.out.println("value :" + value);
    }

    public void annotationTest() {
        printValue(1000);
        printValueWithAnnotation(AnnotationTest.this);
    }

    private void printValueWithAnnotation(Object object) {
        Class<?> clazz = object.getClass();
        Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(Test.class)) {
                Test test = method.getAnnotation(Test.class);
                try {
                    method.invoke(object, test.value());
                } catch (IllegalAccessException
                        | InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String args[]) {
        System.out.println("main start");
        AnnotationTest annotationTest = new AnnotationTest();
        annotationTest.annotationTest();
        System.out.println("main finish");
    }
}