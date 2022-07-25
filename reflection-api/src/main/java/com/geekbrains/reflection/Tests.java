package com.geekbrains.reflection;

public class Tests {
    @Test(priority = 10)
    public void test10() {
        System.out.println("2");
    }

    @Test(priority = 1)
    public void test1() {
        System.out.println("3");
    }

    @Test(priority = 5)
    public void test5() {
        System.out.println("3");
    }

    @BeforeSuite
    public void test2() {
        System.out.println("1");
    }

    @AfterSuite
    public void test3() {
        System.out.println("4");
    }

}
