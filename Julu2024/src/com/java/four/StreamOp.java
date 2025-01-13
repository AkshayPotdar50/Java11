package com.java.four;


import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;

class User{
    public int id;
    public String name;

}

public class StreamOp {

    public static void main(String[] args) {


        //1.FILTER
        List<Integer> number1= Arrays.asList(1, 3, 4, 7, 2, 8);
        List<Integer> even=number1.stream().filter(i->i%2 ==0).toList();
        List<Integer> odd=number1.stream().filter(i->i%2 !=0).toList();



        //2.map
        List<String> names = List.of("Alice", "Bob", "Charlie");
        List<Integer> nameLengths = names.stream()
                .map(String::length)
                .toList();

        //data extraction map
     /*   List<User> users = // assume populated;
                List<String> usernames = users.stream()
                        .map(User::getUsername)
                        .collect(Collectors.toList());


           List<Order> orders = // assume populated;
            List<Invoice> invoices = orders.stream()
            .map(order -> new Invoice(order.getId(), calculateTotal(order)))
            .collect(Collectors.toList());




               */

        int[] numbers = {1, 2, 3, 4};
        int[] squares = Arrays.stream(numbers)
                .map(n -> n * n)
                .toArray();

        IntStream intStream = IntStream.range(1, 5);
        DoubleStream doubleStream = intStream.mapToDouble(n -> n * 2.5);

        int[] numbers2 = {1, 2, 3, 4};
        int sumOfSquares = Arrays.stream(numbers)
                .map(n -> n * n)
                .sum();



        //3.Flatmap
        List<List<String>> namesNested=Arrays.asList(
                Arrays.asList("john", "jane"),
                Arrays.asList("jack","ellie")
        );


        //4.sorted
        List<String> names2 = List.of("Alice", "Bob", "Charlie");
        List<String> sortedNames = names.stream()
                .sorted() // Natural order
                .toList();


        List<String> names3 = List.of("Alice", "Bob", "Charlie");
        List<String> sortedByLength = names.stream()
                .sorted(Comparator.comparingInt(String::length))
                .toList();

        //object sorting
        /*List<User> users = // assume populated;
                List<User> sortedUsers = users.stream()
                        .sorted(Comparator.comparing(User::getUsername))
                        .collect(Collectors.toList());


                        //multi level sorting
         List<User> users = // assume populated;
          List<User> sortedUsers = users.stream()
                              .sorted(Comparator.comparing(User::getAge)
                                                .thenComparing(User::getUsername))
                              .collect(Collectors.toList());

*/





        //PEEK

        List<String> names4 = List.of("Alice", "Bob", "Charlie");
        List<String> upperCaseNames = names.stream()
                .peek(name -> System.out.println("Before transformation: " + name))
                .map(String::toUpperCase)
                .peek(name -> System.out.println("After transformation: " + name))
                .toList();

        //LOGGING
        /*List<Order> orders = // assume populated;
       orders.stream()
      .peek(order -> System.out.println("Processing order: " + order.getId()))
      .filter(order -> order.getTotal() > 100)
      .collect(Collectors.toList());


*/

        AtomicInteger counter = new AtomicInteger(0);
        List<String> names5 = List.of("Alice", "Bob", "Charlie");
        names.stream()
                .peek(name -> counter.incrementAndGet())
                .toList();
        System.out.println("Total names processed: " + counter.get());




        List<String> names7 = List.of("Alice", "Bob", "Charlie");
        Set<String> nameSet = new HashSet<>();
        names.stream().forEach(nameSet::add);



        List<Integer> numbers6 = List.of(1, 2, 3, 4, 5);
        int sum = numbers6.stream()
                .reduce(0, Integer::sum);
// Output: 15

        List<String> words = List.of("Java", "Stream", "Reduce");
        String result = words.stream()
                .reduce("", (a, b) -> a + " " + b);
// Output: " Java Stream Reduce"


        List<Integer> numbers9 = List.of(7, 3, 5, 2, 8);
        int min = numbers9.stream()
                .reduce(Integer.MAX_VALUE, Integer::min);
// Output: 2

        













    }
}
