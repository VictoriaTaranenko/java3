package com.geekbrains.calc.tests;

import com.geekbrains.calc.Calculator;
import org.junit.*;

public class CalcTest {
    private Calculator calculator;

    @Before // будет выполняться перед каждым тестом
    public void init() {
        System.out.println("init");
        calculator = new Calculator();
    }
    @After // после каждого теста делаем завершающую операцию
    public void shutdown() {
        System.out.println("shutdown");
    }

    @Test
    @Ignore("ok")
    public void calcAddTest() {
        //Calculator calculator = new Calculator();
        Assert.assertEquals(4,calculator.add(2,2));
    }



    @Test(timeout = 1500L)
    public void calcSubTest() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //Calculator calculator = new Calculator();
        Assert.assertEquals(1,calculator.sub(3,2));
    }

    @Test
    public void calcMulTest() {
        //Calculator calculator = new Calculator();
        Assert.assertEquals(6,calculator.mul(3,2));
    }

    @Test
    public void calcDivTest() {
        //Calculator calculator = new Calculator();
        Assert.assertEquals(3,calculator.div(6,2));
    }
    @Test(expected = ArithmeticException.class)
    public void calcDivByZeroTest() {
        calculator.div(6,0);

    }
}
