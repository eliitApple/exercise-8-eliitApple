package com.serenitydojo;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;


public class WhenWorkingWithMaps
{
    @Test
    public void creatingAMap() {
        // good practise is to use generics, K,V
        Map<String, Integer> numberOfBallsByColor = new HashMap<>();

        numberOfBallsByColor.put("red", 3);
        numberOfBallsByColor.put("green", 6);
        numberOfBallsByColor.put("blue", 5);

        Integer numberOfRedBalls = numberOfBallsByColor.get("red");
        System.out.println("There are " + numberOfRedBalls + " red balls");
    }

    @Test
    public void creatingAMapMoreConcisely() {
        Map<String,Integer> numberOfBallsByColor = Map.of("red", 3, "green", 6, "blue", 5);

        Map<String, Integer> moreColors = new HashMap<>();
        moreColors.put("yellow", 10);
        moreColors.put("ulo", 0);
        moreColors.putAll(numberOfBallsByColor);

        System.out.println("number of colors for white balls: " + moreColors.getOrDefault("white", 0));

        System.out.println(moreColors.containsKey("ulo"));

        moreColors.put("yellow", 20);
        moreColors.put("pink", 15);
        System.out.println(moreColors.get("yellow"));

        System.out.println(moreColors.getOrDefault("pink", 0));

        // replace doesn't update if the pink balls exists
        moreColors.replace("pink", 15);

        System.out.println(moreColors.getOrDefault("pink", 0));

    }


    @Test
    public void iteratingOverMapKeys() {
        // crates constant map, can't be change, immutable, if removal is needed treemap or hashmap is needed
        Map<String,Integer> numberOfBallsByColor = Map.of("red", 3, "green", 6, "blue", 5);

        System.out.println(numberOfBallsByColor.keySet());
        // Maps do not have order generally it's a new Hash Set

        for(String key: numberOfBallsByColor.keySet()) {
            Integer numberOfTennisBalls = numberOfBallsByColor.get(key);
            System.out.println(key +  " => " +  numberOfTennisBalls);
        }

        // print map
        printMap(numberOfBallsByColor);

        Map<String, Integer> modifiedMap = new HashMap<>();
        modifiedMap.putAll(numberOfBallsByColor);

        modifiedMap.clear();

        printMap(modifiedMap);


    }

    private static void printMap(Map<String, Integer> numberOfBallsByColor) {
        for(Map.Entry<String, Integer> entry : numberOfBallsByColor.entrySet()) {
            System.out.println("lala " + entry.getKey() + " -> " + entry.getValue());
        }
    }


}
