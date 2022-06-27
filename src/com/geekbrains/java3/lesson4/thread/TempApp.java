package com.geekbrains.java3.lesson4.thread;

public class TempApp {
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(1);
            }
        }).start();

        // в лямбды можно сворачивать анноним внутрен классы, созданы по функциональному интерфейсу(интерфейс с одним методом)
        new Thread(() -> {
            System.out.println(1);
        }).start();

        doDoSomething((a,b,c) -> System.out.println(a + b + c));


    }

    public static void doDoSomething(MyInt mi) {

    }
}
