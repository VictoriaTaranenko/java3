package com.geekbrains.homework.tests;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class SliceTests {
    @Parameterized.Parameters
    public static Collection<Object[]> params() {
        return Arrays.asList(new Object[][]{
                {new int[] {1,2,3,4,3,2,4,1,1},new int[] {1,1}},
                {new int[] {4,1,2,3,4,5,5,1,1}, new int[]{5,5,1,1}}
        });

    }
    private int[] in;
    private int[] out;

    public SliceTests(int[] in, int[] out) {
        this.in = in;
        this.out = out;
    }

    @Test
    public void sliceTest(){
        Assert.assertArrayEquals(out,ArrayProcessing.sliceArray(in));
    }
}
