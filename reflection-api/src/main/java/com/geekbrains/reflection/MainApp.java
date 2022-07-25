package com.geekbrains.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class MainApp {
    public static void main(String[] args) throws Exception {
       // получить ссылку на класс
        Class c1 = Cat.class;

        Cat cat = new Cat("Barsik","White",10);
        Class c2 = cat.getClass();

        Class c3 = Class.forName("com.geekbrains.reflection.Cat");

        System.out.println(int[].class.getName());
        System.out.println(int[][].class.getName());
        System.out.println(c1.getName()); // полное имя класса с покетом
        System.out.println(c1.getSimpleName()); // только имя класса

        // модификаторы доступа класса
        int mods = c1.getModifiers();
        System.out.println(Modifier.isPublic(mods));
        System.out.println(Modifier.isStatic(mods));
        System.out.println(Modifier.isFinal(mods));

        // поля
        Field[] declFields = c1.getDeclaredFields(); // все поля
        Field[] fields = c1.getFields(); // только public поля
        for(Field f: declFields) {
            System.out.println(f);
        }
        System.out.println("_____________________");
        for(Field f: fields) {
            System.out.println(f);
        }

        //  у кота запросить возраст
        Field f = c1.getDeclaredField("age");
        System.out.println(f.get(cat));

        // у кота запрашиваем имя private поля
        Field f1 = c1.getDeclaredField("name");
        f1.setAccessible(true);
        System.out.println(f1.get(cat));

        // метод
        Method m = c1.getDeclaredMethod("info");
        m.invoke(cat);

        // ссылка на конструктор
        Constructor con = c1.getConstructor(String.class, String.class, int.class);
        Cat cat123 = (Cat)con.newInstance("A","B",5);
        cat123.info();
    }
}
