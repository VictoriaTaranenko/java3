package com.geekbrains.reflection;

@HTable(name = "users")
public class User {
    @HField
    int id;

    @HField
    String name;

    @HField
    int age;

    @HField
    int salary;

    @HField
    String email;

    @HField
    String phone;

    @HField
    String address;

    String unknown;

    public User(int id, String name, int age, int salary, String email, String phone, String address, String unknown) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.unknown = unknown;
    }
}


