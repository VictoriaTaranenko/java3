package com.geekbrains.calc.tests;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class AnotherParametrizedTest {
    @Parameterized.Parameters
    public static Collection<Object[]> params() {
        return Arrays.asList(new Object[][]{
                {new int[]{1,2,3},6,true},
                {new int[]{2,2,4},8,false},
                {new int[]{11,12,3},26,true}

        });
    }
    private int[] arr;
    private int sum;
    private boolean notUsed;

    public AnotherParametrizedTest(int[] arr, int sum, boolean notUsed) {
        this.arr = arr;
        this.sum = sum;
        this.notUsed = notUsed;
    }

    @Test
    public void somethingTest() {
        Assert.assertEquals(sum,Arrays.stream(arr).sum());
    }
}

