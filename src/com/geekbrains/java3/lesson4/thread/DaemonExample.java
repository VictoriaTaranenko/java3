package com.geekbrains.java3.lesson4.thread;

public class DaemonExample {
    public static void main(String[] args) {
        Thread tTimer = new Thread(() -> {
            int time = 0;
            while(true) {
                try {
                    Thread.sleep(1000);
                    time++;
                    System.out.println("time: " + time);
                } catch(InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        tTimer.setDaemon(true); // если не указываем, то поток Daemon будет работать бесконечно
        tTimer.start();
        System.out.println("main -> sleep ");
        try {
            Thread.sleep(5000);
        } catch(InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("main -> end ");
    }
}
