package com.geekbrains.java3.lesson1;

public class SimpleBox implements Comparable<SimpleBox> {
    private int n;

    public SimpleBox(int n) {
        this.n = n;
    }

    @Override
    public int compareTo(SimpleBox o) {
        return this.n - o.n;
    }
}
