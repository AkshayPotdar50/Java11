package com.java.two;

import java.util.concurrent.TimeUnit;

public class TrafficSignalController {

    private static final int RED_LIGHT_DURATION=10;
    private static final int YELLOW_LIGHT_DURATION=2;
    private static final int GREEN_LIGHT_DURATION=5;

    public static void main(String[] args) {
        while(true){
            displaySignal("RED", RED_LIGHT_DURATION);
            displaySignal("YELLOW",YELLOW_LIGHT_DURATION);
            displaySignal("GREEN", GREEN_LIGHT_DURATION);
            displaySignal("YELLOW", YELLOW_LIGHT_DURATION);

        }
    }

    private static void displaySignal(String signal, int duration){
        System.out.println("traffic light is now "+signal);
        try{
            TimeUnit.SECONDS.sleep(duration);
        }catch (InterruptedException e){
            System.out.println("thread interrupted"+e.getMessage());
        }
    }
}
