package com.geekbrains.java3.homework1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Box<T extends Fruit>  {
    private List<T> fruits;


    public Box(T... fruits) {
        this.fruits = new ArrayList<>(Arrays.asList(fruits));
    }

    public float getWeight() {
        float w = 0.0f;
        for (int i = 0; i < fruits.size(); i++) {
            w += fruits.get(i).getWeight();
        }
        return w;
    }

    public boolean compare(Box<?> another) {
        return (this.getWeight() - another.getWeight()) < 0.0001f;
    }


    }

