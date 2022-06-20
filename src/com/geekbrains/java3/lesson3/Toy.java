package com.geekbrains.java3.lesson3;

import java.io.Serializable;

public class Toy implements Serializable {
    private String color;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Toy(String color) {
        this.color = color;
    }
}
