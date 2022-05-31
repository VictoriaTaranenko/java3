package com.geekbrains.java3.lesson1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainApp {
    public static void main(String[] args) {
        Box box1i = new Box(5);
        Box box2i = new Box(10);

        // .... после создания есть 5000 строк кода

        box1i.setObj("Java");

        // ....
        if (box1i.getObj() instanceof Integer && box2i.getObj() instanceof Integer) {
            int sum = (Integer) box1i.getObj() + (Integer) box2i.getObj();
            System.out.println("sum : " + sum);
        }

        BoxGen<Integer> bgi1 = new BoxGen<>(5);
        BoxGen<Integer> bgi2 = new BoxGen<>(15);

        int sum = bgi1.getObj() + bgi2.getObj();

        BoxGen<String> bgs1 = new BoxGen<>("A");
        BoxGen<String> bgs2 = new BoxGen<>("B");

        BoxWithNumbers<Integer> bwni1 = new BoxWithNumbers<>(1,2,3);
        BoxWithNumbers<Float> bwnf1 = new BoxWithNumbers<>(1.0f,2.0f,3.0f);
        System.out.println(bwni1.avg());
        System.out.println(bwnf1.avg());

        BoxWithNumbers<Integer> bwni2 = new BoxWithNumbers<>(1,2,3);
        BoxWithNumbers<Integer> bwnf2 = new BoxWithNumbers<>(1,4,1);
        System.out.println(bwni2.equalsByAvg(bwnf2));

        List<Integer> li = new ArrayList<>(Arrays.asList(1,2,3,4));
        printListWithNumbers(li);

    }

    // из листа достать первый попавшийся обьект
    public static <T> T getFirstObj(List<T> list) {
        return list.get(0);
    }
    // обобщенные методы
    public static void printListWithNumbers(List<? extends Number> list) {
        for (Number n : list) {
            System.out.println(n);
        }
    }
}


