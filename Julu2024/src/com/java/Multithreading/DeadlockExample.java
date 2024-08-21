package com.java.Multithreading;

public class DeadlockExample {

    private final Object lock1= new Object();
    private final Object lock2 = new Object();


    public void method1(){
        synchronized (lock1){
            System.out.println("lock1 acquired , waiting for lock2");
            synchronized (lock2){
                System.out.println("lock2 acquired");
            }
        }
    }

    public void method2(){
        synchronized (lock2){
            System.out.println("lock2 acquired , waiting for lock1");
            synchronized (lock1){
                System.out.println("lock1 acquired");
            }
        }
    }

    public static void main(String[] args) {
        DeadlockExample example= new DeadlockExample();
        new Thread(example::method1).start();
        new Thread(example::method2).start();

    }
}
