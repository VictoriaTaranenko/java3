package com.geekbrains.java3.lesson4;

import java.util.concurrent.*;

public class TempApp {
    public static void main(String[] args) {
//        ExecutorService service = Executors.newFixedThreadPool(4); // указываем сколько потоков будет работать(4)
//        for (int i = 1; i <= 10; i++) {
//            final int INDEX = i;
//            service.execute(() -> {
//                System.out.println(INDEX + " -start");
//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                System.out.println(INDEX + " -end");
//            });
//        }
//        service.shutdown();


//        ExecutorService service = Executors.newFixedThreadPool(4, new ThreadFactory() {
//            @Override
//            public Thread newThread(Runnable r) {
//                Thread t = new Thread(r);
//                t.setPriority(10);
//                t.setDaemon(true);
//                return t;
//            }
//
//        });
//        for (int i = 1; i <= 10; i++) {
//            final int INDEX = i;
//            service.execute(() -> {
//                System.out.println(INDEX + " -start");
//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                System.out.println(INDEX + " -end");
//            });
//        }
//        service.shutdown();
//

//        ExecutorService ser = Executors.newSingleThreadExecutor(); // один постоянно работающий поток
//        for (int i = 1; i <= 10; i++) {
//            final int INDEX = i;
//            ser.execute(() -> {
//                System.out.println(INDEX + " -start");
//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                System.out.println(INDEX + " -end");
//            });
//        }
//        ser.shutdown();


//        ExecutorService service = Executors.newFixedThreadPool(4);
//        Future f = service.submit(() -> {
//            System.out.println(1);
//            try {
//                Thread.sleep(3000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            System.out.println(2);
//        });
//        service.shutdown();
//        System.out.println(f.isDone());

//        ExecutorService service = Executors.newFixedThreadPool(4);
//        Future<String> f = service.submit(new Callable<String>() {
//            @Override
//            public String call() throws Exception {
//                return "java";
//            }
//        });
//        service.shutdown();
//        try {
//            System.out.println("main > " +  f.get());
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } catch (ExecutionException e) {
//            e.printStackTrace();
//        }


        FutureTask<String> ft = new FutureTask<>(new Callable<String>() {
            @Override
            public String call() throws Exception {
                System.out.println(Thread.currentThread().getName());
                return "A";
            }
        });
        new Thread(ft).start();
        try {
            System.out.println(ft.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }


    }
}
