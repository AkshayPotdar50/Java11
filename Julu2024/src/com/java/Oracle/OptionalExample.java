package com.java.Oracle;

import java.util.Optional;

public class OptionalExample {
    public static void main(String[] args) {
        // Create an Optional that can contain a String value or be empty (null equivalent)
        String name = null;  // You can change this to null to see how Optional handles it
        Optional<String> optionalName = Optional.ofNullable(name);

        // Use the isPresent() method to check if the value is present
        if (optionalName.isPresent()) {
            System.out.println("Name is present: " + optionalName.get());
        } else {
            System.out.println("Name is not present.");
        }

        // Using ifPresent() to perform an action only if the value is present
        optionalName.ifPresent(n -> System.out.println("Name in uppercase: " + n.toUpperCase()));

        // Using orElse() to provide a default value if the value is absent (null)
        String defaultName = optionalName.orElse("Default Name");
        System.out.println("Name (or default): " + defaultName);

        // Using orElseThrow() to throw an exception if the value is absent
        try {
            String nameOrException = optionalName.orElseThrow(() -> new IllegalArgumentException("Name is missing!"));
            System.out.println("Name: " + nameOrException);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
