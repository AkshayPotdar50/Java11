package com.java.serialization;

import java.io.*;

class Person implements Serializable {
    private static final long serialVersionUID = 1L; // To ensure compatibility during serialization
    private String name;
    private int age;

    // Constructor
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Getters
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    // Override toString for readable output
    @Override
    public String toString() {
        return "Person{name='" + name + "', age=" + age + "}";
    }
}

public class SerializationDemo {
    public static void main(String[] args) {
        // Create a Person object
        Person person = new Person("Alice", 30);
        System.out.println("Before Serialization: " + person);

        String filename = "person.ser"; // File to store serialized object

        // Serialize the object
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(person);
            System.out.println("Serialization successful!");
        } catch (IOException e) {
            System.err.println("Serialization failed: " + e.getMessage());
        }

        // Deserialize the object
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            Person deserializedPerson = (Person) ois.readObject();
            System.out.println("After Deserialization: " + deserializedPerson);
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Deserialization failed: " + e.getMessage());
        }
    }
}
