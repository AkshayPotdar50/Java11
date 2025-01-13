package com.java.java8;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class Collections1 {
    public static void main(String[] args) {
        //concurrent collections
        CopyOnWriteArrayList<Integer> coral=new CopyOnWriteArrayList<>();
        ConcurrentHashMap<Integer, String> cohasma= new ConcurrentHashMap<>();

        //List iNTERFACE
        List<Integer> list1= new ArrayList<>();
        Scanner s = new Scanner(System.in);
        String input = s.nextLine().replaceAll("[\\[\\]\"]", "");
        String[] inputArray = input.split(",");
        System.out.print(ArrayChallange(inputArray));
        s.close();
    }

    public static String ArrayChallange(String[] StrArr){
        Map<String, Integer> cardValues = new HashMap<>();
        cardValues.put("two", 2);
        cardValues.put("three", 3);
        cardValues.put("four", 4);
        cardValues.put("five", 5);
        cardValues.put("six", 6);
        cardValues.put("seven", 7);
        cardValues.put("eight", 8);
        cardValues.put("nine", 9);
        cardValues.put("ten", 10);
        cardValues.put("jack", 10);
        cardValues.put("queen", 10);
        cardValues.put("king", 10);
        cardValues.put("ace", 11);

        int totalValue= Arrays.stream(StrArr)
                .mapToInt(cardValues::get)
                .sum();

        long aceCount=Arrays.stream(StrArr)
                .filter("ace"::equals).count();


        String heighestCard=Arrays.stream(StrArr)
                .max(Comparator.comparingInt(cardValues::get)).orElse("");

        // Adjust total value if it exceeds 21 and there are aces
        while (totalValue > 21 && aceCount > 0) {
            totalValue -= 10;
            aceCount--;
        }

        // Determine output based on total value
        String varOcg;
        if (totalValue == 21) {
            varOcg = "blackjack " + heighestCard;
        } else if (totalValue > 21) {
            varOcg = "above " + heighestCard;
        } else {
            varOcg = "below " + heighestCard;
        }

        return varOcg;
    }

}
