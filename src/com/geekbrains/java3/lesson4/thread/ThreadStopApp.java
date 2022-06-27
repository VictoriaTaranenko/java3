package com.geekbrains.java3.lesson4.thread;

public class ThreadStopApp {
    public static void main(String[] args) {
        correct();
    }

    public static void correct() {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                boolean inter = false;
                while (true) {
                    if (Thread.currentThread().isInterrupted() || inter) { // если кто-то попытался наш поток остановить, тогда мы выходим из этого цикла и потихоньку останавливаемся
                        break;
                    }
                    System.out.println("tick");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        inter = true;
                    }
                }
            }
        });
        t.start();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t.interrupt(); // останавливаем поток
    }
}
