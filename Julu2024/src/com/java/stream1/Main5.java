package com.java.stream1;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

/*Problem 5: GroupingBy, Counting, and Max (Optional)
Given: A list of Transaction objects, each with a transactionId, category, and amount.

Task: Group transactions by category and find the category with the most transactions.
Operations: collect, groupingBy, counting, max*/
class Transaction{
    private int transactionId;
    private String catogary;
    private long amount;

    public Transaction(int transactionId, String catogary, long amount) {
        this.transactionId = transactionId;
        this.catogary = catogary;
        this.amount = amount;
    }

    public int getTransactionId() {
        return transactionId;
    }

    public String getCatogary() {
        return catogary;
    }

    public long getAmount() {
        return amount;
    }
}

public class Main5 {
    public static void main(String[] args) {
        List<Transaction> transcations= Arrays.asList(
                new Transaction(1, "grocery", 1250),
                new Transaction(2, "barberShop", 450),
                new Transaction(3, "spa", 350),
                new Transaction(4, "medical",1480),
                new Transaction(5, "grocery", 1150),
                new Transaction(6, "grocery", 10)

        );

        Map<String,Long> transactionCount=transcations.stream()
                .collect(Collectors.groupingBy(Transaction::getCatogary, Collectors.counting()));

        Optional<Map.Entry<String, Long>> maxCatogary=transactionCount.entrySet().stream().max(Map.Entry.comparingByValue());

        maxCatogary.ifPresent(category->System.out.println(category.getKey()+" "+category.getValue()));


    }

}
