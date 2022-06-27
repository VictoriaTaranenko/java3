package com.geekbrains.java3.lesson4.thread;

public class SynchCounter {
    private int c;

    public int value() {
        return c;
    }

    public SynchCounter() {
        c = 0;
    }

    public synchronized void inc() {
        c++;
    }

    public synchronized void dec() {
        c--;
    }
}
