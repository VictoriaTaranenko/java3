package com.geekbrains.homework.tests;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class Has1And4Tests {
    @Parameterized.Parameters
    public static Collection<Object[]> params() {
        return Arrays.asList(new Object[][]{
                {new int[] {1,1,1,4,4,1,4,4}, true},
                {new int[] {1,1,1,1,1,1}, false},
                {new int[] {4,4,4,4}, false},
                {new int[] {1,4,4,1,1,4,3}, false}
        });

    }
    private int[] in;
    private boolean result;

    public Has1And4Tests(int[] in, boolean result) {
        this.in = in;
        this.result = result;
    }

    @Test
    public void sliceTest(){
        Assert.assertEquals(result,ArrayProcessing.has1and4(in));
    }
}


