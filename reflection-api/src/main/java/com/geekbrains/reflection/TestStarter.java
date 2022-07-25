package com.geekbrains.reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Comparator;
import java.util.LinkedList;

public class TestStarter {
    public static void start(Class<?> clazz) {
        Method[] methods = clazz.getDeclaredMethods();
        Method before = null;
        Method after = null;
        LinkedList<Method> sortedMethods = new LinkedList<>();
        for (Method m : methods) {
            m.setAccessible(true);
            if (m.isAnnotationPresent(BeforeSuite.class)) {
                before = m;
            }
            if (m.isAnnotationPresent(Test.class)) {
                sortedMethods.add(m);
            }
            if (m.isAnnotationPresent(AfterSuite.class)) {
                after = m;
            }
        }
        sortedMethods.sort(new Comparator<Method>() {
            @Override
            public int compare(Method o1, Method o2) {
                return  o2.getAnnotation(Test.class).priority() - o1.getAnnotation(Test.class).priority();
            }
        });

        sortedMethods.addFirst(before);
        sortedMethods.addLast(after);
        sortedMethods.forEach(System.out::println);
        Object o;
        try {
            o = clazz.newInstance();
            invokeMethods(sortedMethods, o);
        } catch (InstantiationException  | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public static void invokeMethods(LinkedList <Method> methods, Object o) {
        methods.forEach(m -> {
            try {
                m.invoke(o);
            } catch (IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
        });
    }

    public static void main(String[] args) {
        start(Tests.class);
    }

}
