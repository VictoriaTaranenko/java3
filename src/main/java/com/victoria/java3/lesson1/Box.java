package com.victoria.java3.lesson1;

public class Box {  // хотим хранить любой обьект
    private Object obj;

    public Object getObj() {
        return obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }

    public Box(Object obj) {
        this.obj = obj;
    }
}
