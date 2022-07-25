package com.geekbrains.reflection;

@HTable(name = "cats")
public class Cats {
    @HField
    int id;

    @HField
    String name;

    @HField
    String color;

    public Cats(int id, String name, String color) {
        this.id = id;
        this.name = name;
        this.color = color;
    }

    public void info() {
        System.out.println("Cat: " + id + " " + name + " " + color);
    }
}
