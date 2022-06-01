package com.victoria.java3.homework1;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static <T> ArrayList<T> convertsTheArrayToArrayList(T[] arr) {
        return new ArrayList<>(Arrays.asList(arr));
    }


    public<T> T[] swapsTwoArrayElements(int one, int two,T[] arr) {
        T temp = arr[one];
        arr[one] = arr[two];
        arr[two] = temp;
        return arr;
    }
}

