package com.java.stream1;

/*Problem 4: Reduce, Map, Filter, and Collect (averagingInt)
Given: A list of Student objects, each with name and score.

Task: Calculate the average score of students who scored above 80.
Operations: filter, map, collect, averagingInt*/

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Student {
    private String name;
    private int score;

    // Constructor
    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    // Getter
    public int getScore() {
        return score;
    }
}


public class Main4 {

    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
                new Student("Alice", 90),
                new Student("Bob", 75),
                new Student("Charlie", 85),
                new Student("David", 60),
                new Student("Eve", 95)
        );

        double averageScore=students.stream()
                .map(Student::getScore)
                .filter(score -> score >80)
                .collect(Collectors.averagingInt(score->score));

        System.out.println(averageScore);
    }

}
