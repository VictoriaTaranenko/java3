package com.geekbrains.java3.lesson3;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class MainApp {
    public static void main(String[] args) {
//        File file = new File("1/2/3/4");
//        file.mkdirs();

//        try(FileOutputStream out = new FileOutputStream("out.txt")) {
//           out.write(new byte[] {65,66,67,68,69});
//            out.write(65);
//            out.write(66);
//            out.write(67);
//            out.write("Hello world!".getBytes());
//        } catch(IOException e) {
//            e.printStackTrace();
//        }

        // чтение в консоли
//        try(FileInputStream in = new FileInputStream("out.txt")) {
//            int x;
//            while((x = in.read()) != -1) {
//                System.out.print((char)x);
//            }
//
//        } catch(IOException e) {
//            e.printStackTrace();
//        }
        

//        try (FileInputStream in = new FileInputStream("out.txt")) {
//            long time = System.currentTimeMillis();
//            int x;
//            while ((x = in.read()) != -1) {
////                System.out.print((char)x);
//            }
//            System.out.println(System.currentTimeMillis() - time);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        try (InputStream in = new BufferedInputStream(new FileInputStream("out.txt"))) {
//            long time = System.currentTimeMillis();
//            int x;
//            while ((x = in.read()) != -1) {
////                System.out.print((char)x);
//            }
//            System.out.println(System.currentTimeMillis() - time);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

//        try (InputStream in = new FileInputStream("out.txt")) {
//            long time = System.currentTimeMillis();
//            byte[] buf = new byte[256];
//            while (in.read(buf) > 0) {
////                System.out.print((char)x);
//            }
//            System.out.println(System.currentTimeMillis() - time);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        try(InputStreamReader in = new InputStreamReader(new FileInputStream("out.txt"), StandardCharsets.UTF_8)) {
            int x;
            while((x = in.read()) != -1) {
                System.out.print((char)x);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
