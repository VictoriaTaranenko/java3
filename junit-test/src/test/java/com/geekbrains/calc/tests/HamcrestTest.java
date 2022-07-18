package com.geekbrains.calc.tests;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;

public class HamcrestTest {
    @Test
    public void hamcrestTest() {
        String a = "Java";
        String b = " Java  ";
        MatcherAssert.assertThat(a, Matchers.equalToIgnoringWhiteSpace(b));

        MatcherAssert.assertThat(new Integer[]{1,2,3,4},Matchers.arrayContainingInAnyOrder(2,4,1,3));
    }
}
