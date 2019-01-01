package com.eric.leetcode.generic;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class GenericEraseTest {

    public void genericEraseTest() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
//        list.add("hello"); // 编译不过
        Class<? extends List> arrayListClass = list.getClass();
        try {
            Method addMethod = arrayListClass.getMethod("add", Object.class);
            addMethod.invoke(list, "我爱北京天安门");
        } catch (NoSuchMethodException
                | IllegalAccessException
                | InvocationTargetException e) {
            e.printStackTrace();
        }
        System.out.println(list);
    }


    public static void main(String args[]) {
        System.out.println("main start");
        GenericEraseTest genericEraseTest = new GenericEraseTest();
        genericEraseTest.genericEraseTest();
        System.out.println("main finish");
    }
}
