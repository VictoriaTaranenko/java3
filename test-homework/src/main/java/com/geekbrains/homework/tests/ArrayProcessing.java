package com.geekbrains.homework.tests;

import java.util.Arrays;

public class ArrayProcessing {

    public static int[] sliceArray(int[] in) {
        for (int i = in.length - 1; i >= 0; i--) {
            if (in[i] == 4) {
                return Arrays.copyOfRange(in, i + 1, in.length);
            }
        }
        throw new RuntimeException("4 not found");
    }

    public static boolean has1and4(int[] in) {
        boolean has1 = false;
        boolean has4 = false;
        for (int i = 0; i < in.length; i++) {
            if (in[i] == 1) {
                has1 = true;
            } else if (in[i] == 4) {
                has4 = true;
            }
        }
        return has1 & has4;
    }
}
