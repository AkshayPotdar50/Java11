package com.java.serialization;

class Parent {
    static void display() {
        System.out.println("Static method in Parent");
    }
}

class Child extends Parent {
    static void display() {
        System.out.println("Static method in Child");
    }
}

public class MethodHidingExample {
    public static void main(String[] args) {
        Parent obj1 = new Parent();
        Parent obj2 = new Child();

        obj1.display(); // Output: Static method in Parent
        obj2.display(); // Output: Static method in Parent (method hiding)
    }
}

