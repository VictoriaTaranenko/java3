package com.geekbrains.java3.lesson1;

public class BoxGen<T> { // обобщенный класс
    private T obj;

    public T getObj() {
        return obj;
    }

    public void setObj(T obj) {
        this.obj = obj;
    }

    public BoxGen(T obj) {
        this.obj = obj;
    }

}
