package com.geekbrains.reflection;

public class Cat {
    private String name;
    String color;
    public int age;

    public Cat(String name, String color, int age) {
        this.name = name;
        this.color = color;
        this.age = age;
    }

    public void info(){
        System.out.println(name + " " + color + " " + age);
    }

    private void meow(){
        System.out.println(name + " : meow");
    }
}
