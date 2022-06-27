package com.geekbrains.java3.lesson4.thread;

public class AnonymousExampleClass {
    public static void main(String[] args) {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println(i);
                    try {
                        Thread.sleep(1000);
                    } catch(InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        t.start();
        try {
            t.join(); // main поток ждет пока поток t закончит свою работу
        } catch(InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("End");
    }
}
