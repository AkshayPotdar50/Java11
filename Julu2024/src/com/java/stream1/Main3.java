package com.java.stream1;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Person{
    private String name;
    private List<String> hobbies;

    public Person(String name, List<String> hobbies) {
        this.name = name;
        this.hobbies = hobbies;
    }

    public String getName() {
        return name;
    }

    public List<String> getHobbies() {
        return hobbies;
    }
}

public class Main3 {

    /*Problem 3: Filter, FlatMap, Peek, Collect, and Counting
Given: A list of Person objects, each with a name and a list of hobbies.

Task: Find the total number of unique hobbies of all people whose names start with the letter "A".
Operations: filter, flatMap, peek, distinct, collect, counting*/
    public static void main(String[] args) {
        List<Person> persons= Arrays.asList(
                new Person("Alice", Arrays.asList("Reading", "Swimming", "Cooking")),
                new Person("Alex", Arrays.asList("Cooking", "Cycling", "Painting")),
                new Person("Bob", Arrays.asList("Gaming", "Reading")),
                new Person("Anna", Arrays.asList("Swimming", "Gardening", "Painting"))
        );

        long honbbiesCount= persons.stream().filter(person -> person.getName().startsWith("A"))
                .peek(person -> System.out.println(person.getName())).flatMap(person -> person.getHobbies().stream().distinct()).count();
        System.out.println(honbbiesCount);

    }


}
