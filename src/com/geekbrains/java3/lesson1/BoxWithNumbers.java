package com.geekbrains.java3.lesson1;

public class BoxWithNumbers<N extends Number> {

    private N[] array;

    public N[] getNumbers() {
        return array;
    }

    public void setNumbers(N[] array) {
        this.array = array;
    }

    public BoxWithNumbers(N... array) {
        this.array = array;
    }

    // среднее
    public double avg() {
        double d = 0.0;
        for (int i = 0; i < array.length; i++) {
            d += array[i].doubleValue(); // суммируем числа
        }
        return d / array.length; // делим на их количество
    }

    // сравниваем коробки
    public boolean equalsByAvg(BoxWithNumbers<N> anotherBox) {
        // return this.avg() == anotherBox.avg(); // если сравниваем числа так делать не правильно
        return Math.abs(this.avg() - anotherBox.avg()) < 0.0001;
    }

    // можно сравнивать коробки любого типа (integer & Double)
    public boolean equalsByAvgL(BoxWithNumbers<?> anotherBox) {
        return Math.abs(this.avg() - anotherBox.avg()) < 0.0001;
    }
}



