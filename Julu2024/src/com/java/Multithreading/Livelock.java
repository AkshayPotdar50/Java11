package com.java.Multithreading;

public class Livelock {

    static class Spoon{
        private Dinner owner;

        public Spoon(Dinner d){
            owner=d;
        }
        public synchronized void use(){
            System.out.printf("%s has eaten!", owner.name);
        }
    }

    static class Dinner{
        private String name;
        private boolean isHungry;

        public Dinner(String n){
            name=n;
            isHungry=true;
        }

        public void eatWith(Spoon spoon, Dinner spouse){
            while(isHungry){
                if(spoon.owner !=this){
                    try{
                        Thread.sleep(1);
                    }catch (InterruptedException e){
                        continue;
                    }
                }

                if(spouse.isHungry){
                    System.out.printf("%s: you eat first, dear %s!%n", name, spouse.name);
                    spoon.owner=spouse;
                    continue;
                }

                spoon.use();
                isHungry=false;
                System.out.printf("%s: i am no longer hungry.%n",name);
                spoon.owner=spouse;
            }
        }
    }

    public static void main(String[] args) {
        final Dinner husband= new Dinner("Husband");
        final Dinner wife = new Dinner("Wife");

        final Spoon spoon = new Spoon(husband);

        new Thread(()->husband.eatWith(spoon, wife)).start();
        new Thread(()->wife.eatWith(spoon, husband)).start();
    }
}
