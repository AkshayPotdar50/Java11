package com.java.three;

//What fundamental issue is demonstrated by this Java code?

public class ConcurrencyIssueExample {
    private int regularInt = 5;

    public synchronized int addAndGet(int value) {
        regularInt += value;
        return regularInt;
    }

    public synchronized int getAndAdd(int value) {
        int temp = regularInt;
        regularInt += value;
        return temp;
    }

    public synchronized int get() {
        return regularInt;
    }

    public static void main(String[] args) {
        ConcurrencyIssueExample example = new ConcurrencyIssueExample();

        new Thread(() -> System.out.println(example.addAndGet(10))).start();
        new Thread(() -> System.out.println(example.getAndAdd(5))).start();

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(example.get());
    }
}