package com.geekbrains.reflection;

public class MyTest {

    @MyAnno(priority = 71)
    public static void test1() {
        System.out.println(1);
    }
    @MyAnno(priority = 31)
    public static void test2() {
        System.out.println(2);
    }
    @MyAnno(priority = 15)
    public static void test3() {
        System.out.println(3);
    }
}
