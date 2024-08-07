package com.java.Collections.Builder;

public class BuilderPatternExample {
    public static void main(String[] args) {
        House house = new House.HouseBuilder()
                .buildFoundation("Concrete")
                .buildStructure("Wood and Brick")
                .buildRoof("Tiles")
                .buildInterior("Modern")
                .build();

        System.out.println(house);
    }
}

