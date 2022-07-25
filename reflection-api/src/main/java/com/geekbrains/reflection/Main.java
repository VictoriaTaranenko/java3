package com.geekbrains.reflection;

import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) throws Exception {
        Class c = MyTest.class;
        Method[] methods = c.getDeclaredMethods();
        for(Method m: methods) {
            if(m.isAnnotationPresent(MyAnno.class)) {
                int p = m.getAnnotation(MyAnno.class).priority();
                System.out.println("p: " + p);
                m.invoke(null);
            }
        }
    }
}
