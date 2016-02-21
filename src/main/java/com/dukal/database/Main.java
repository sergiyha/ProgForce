package com.dukal.database;

/**
 * Created by dukal on 21.02.2016.
 */
public class Main {
    public static void main(String[] args) {

        Thread myFirstThread = new Thread(new Runnable() {                         //первый поток - первый магазин
            public void run() {
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Shops shop_1 = new Shops();
                shop_1.setNewProduct("hammer", 100, 1, 1);
                shop_1.setNewProduct("pliers", 115, 1, 1);
                shop_1.setNewProduct("screwdriver", 50, 1, 1);
                shop_1.setNewProduct("apple", 10, 1, 2);
                shop_1.setNewProduct("orange", 5, 1, 2);
                shop_1.setNewProduct("coconut", 30, 1, 2);

                shop_1.changeStatusOfSomeoneCategory(1);

                shop_1.incrementAvailableProductPrice();

                System.out.println("Thread 1 has done its job");


            }
        });
        myFirstThread.start();


        Thread mySecondThread = new Thread(new Runnable() {                         //второй поток - второй магазин
            public void run() {
                try {
                    Thread.sleep(0);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Shops shop_2 = new Shops();

                shop_2.setNewProduct("horse", 1000, 1, 3);
                shop_2.setNewProduct("rabbit", 100, 1, 3);
                shop_2.setNewProduct("cow", 1000, 1, 3);
                shop_2.setNewProduct("beef", 60, 1, 4);
                shop_2.setNewProduct("mutton", 70, 1, 4);
                shop_2.setNewProduct("chicken", 60, 1, 4);

                shop_2.changeStatusOfSomeoneCategory(3);

                shop_2.incrementAvailableProductPrice();

                System.out.println("Thread 2 has done its work");

            }
        });
        mySecondThread.start();

        for (int i = 1; i <= 10; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(i);
        }

        try {
            mySecondThread.join();
            myFirstThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Main thread has done its work ");
    }

}
