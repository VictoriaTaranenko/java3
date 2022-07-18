package com.geekbrains.calc.tests;

import com.geekbrains.calc.Calculator;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class CalcParametrizedAddTest {
    @Parameterized.Parameters
    public static Collection<Object> params() {
        return Arrays.asList(new Object[][]{
                {1,2,3},
                {4,1,9},
                {7,8,15},
                {8,1,16},
                {1,8,17},
                {16,8,24},
                {20,1,28}
        });
    }

    private int n1, n2, res;
    private Calculator calculator;

    public CalcParametrizedAddTest(int n1, int n2, int res) {
        this.n1 = n1;
        this.n2 = n2;
        this.res = res;
    }

    @Before // будет выполняться перед каждым тестом
    public void init() {
        System.out.println("init");
        calculator = new Calculator();
    }

    @Test
    public void calcAddTest() {
        Assert.assertEquals(res,calculator.add(n1,n2));
    }

}
