package com.geekbrains.java3.lesson3;

import java.io.Serializable;

public class Cat implements Serializable {
    private static final long serialVersionUID = -2291720489029987678L;
    private String color;
    private int age;
    private Toy toy;

    public Toy getToy() {
        return toy;
    }

    public void setToy(Toy toy) {
        this.toy = toy;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Cat(String color, int age) {
        this.color = color;
        this.age = age;
    }

    @Override
    public String toString() {
        return String.format("Cat [%s %d Toy color : %s]", color, age, toy.getColor());
    }
}
