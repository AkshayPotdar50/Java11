package com.java.stream1;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/*Problem 1: Filter, Map, Collect, and Joining
Given: A list of Employee objects, each with name, department, and salary.

Task: Use Streams to create a comma-separated string of names of employees whose salary is greater than 50,000.
Operations: filter, map, collect, joinin*/

class Employee{
    private String name;
    private String department;
    private long salary;

    public Employee(String name, String department, long salary) {
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public long getSalary() {
        return salary;
    }
}

public class Main1 {

    public static void main(String[] args) {
        List<Employee> employees= Arrays.asList(
                new Employee("Alice", "Engineering", 70000),
                new Employee("Bob", "Marketing", 45000),
                new Employee("Charlie", "Engineering", 55000),
                new Employee("David", "Marketing", 52000)
        );

         String names=employees.stream().filter(emp->emp.getSalary()>50000).map(Employee::getName).collect(Collectors.joining(","));
        System.out.println(names);


    }
}
