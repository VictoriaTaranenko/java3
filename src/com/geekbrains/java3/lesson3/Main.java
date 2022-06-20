package com.geekbrains.java3.lesson3;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("cat.ser"))) {
            Cat outCat = new Cat("White", 5);
            Toy greenToy = new Toy("Green");
            outCat.setToy(greenToy);
            out.writeObject(outCat);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("cat.ser"))) {
            Cat inCat = (Cat) in.readObject();
            System.out.println(" > " + inCat);// прочитанный из файла код
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }


//    если мало обьектов и мало полей в нем
//        try (PrintWriter out = new PrintWriter("cat.txt")) {
//            out.println(cat.getColor());
//            out.println(cat.getAge());
//        } catch(IOException e) {
//            e.printStackTrace();
//        }
//        try(BufferedReader in = new BufferedReader(new FileReader("cat.txt"))) {
//            String inColor = in.readLine();
//            int inAge = Integer.parseInt(in.readLine());
//            Cat readedCat = new Cat(inColor, inAge);
//            System.out.println(readedCat);
//        } catch(IOException e) {
//            e.printStackTrace();
//        }

    }
}
