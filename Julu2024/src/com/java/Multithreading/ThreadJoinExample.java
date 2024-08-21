package com.java.Multithreading;

public class ThreadJoinExample {

    public static void main(String[] args) {
        Thread thread1 = new Thread(()->{
            try{
                Thread.sleep(2000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        });

        Thread thread2 = new Thread(()->{
            try{
                thread1.join();
                System.out.println("thread 2 finished after thread 1");
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        });

        thread1.start();
        thread2.start();
    }

}
