package com.geekbrains.java3.lesson4.thread;

public class RunnableExampleClass implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            System.out.println(i);
            try {
                Thread.sleep(500);
            } catch(InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Thread t = new Thread(new RunnableExampleClass());
        t.start();
    }
}
