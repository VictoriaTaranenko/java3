package com.geekbrains.java3.lesson4.thread;

public class SynchCounterApp {
    public static void main(String[] args) {
        SynchCounter synchCounter = new SynchCounter();

        Thread incThread = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                synchCounter.inc();
                try {
                    Thread.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread decThread = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                synchCounter.dec();
                try {
                    Thread.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        try {
            incThread.start();
            decThread.start();
            incThread.join();
            decThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Значение счетчика: " + synchCounter.value());
    }
}
