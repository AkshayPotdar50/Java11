package com.java.Multithreading;

public class ThreadInterruptionExample implements Runnable{
    @Override
    public void run() {
        try{
            while(!Thread.currentThread().isInterrupted()){
                System.out.println("Working...");
                Thread.sleep(1000);
            }
        }catch (InterruptedException e){
            System.out.println("Thread was interrupted");
        }

    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread= new Thread(new ThreadInterruptionExample());
        thread.start();
        Thread.sleep(3000);
        thread.interrupt();
    }
}
