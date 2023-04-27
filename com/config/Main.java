package com.config;

import org.json.simple.*;
import org.json.simple.parser.*;

import java.io.FileReader;
import java.util.Arrays;

public class Main {
    private static int[] shuffledCardNumbers = new int[0];

    public static void main(String[] args) {
        JSONParser parser = new JSONParser();
        int[] cardNumbers = new int[0];
        try {
            Object obj = parser.parse(new FileReader("com/config/data.json"));
            JSONObject jsonObject = (JSONObject) obj;
            JSONObject cards = (JSONObject) jsonObject.get("cards");
            int numCards = cards.size();
            cardNumbers = new int[numCards];
            int index = 0;
            for (Object key : cards.keySet()) {
                cardNumbers[index++] = Integer.parseInt((String) key);
            }
            shuffledCardNumbers = Shuffle.generate(cardNumbers);
            for (int cardNumber : shuffledCardNumbers) {
                JSONObject cardObj = (JSONObject) cards.get(String.valueOf(cardNumber));
                String color = (String) cardObj.get("color");
                String value = (String) cardObj.get("value");
                boolean stackable = (Boolean) cardObj.get("stackable");
                System.out.println("Card " + cardNumber + " - color: " + color + ", value: " + value + ", stackable: " + stackable);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(Arrays.toString(getShuffledCardNumbers()));
    }

    public static int[] getShuffledCardNumbers() {
        return shuffledCardNumbers;
    }
}
