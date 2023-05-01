package com.main;
import com.config.*;
public class Agent {
    public static void main(String[] args) throws Exception {
        int[] shuffle = Shuffle.generate(CardData.getAll());
        for (int number: shuffle) {
            System.out.println("Color: "+ CardData.getColor(number)+ " | Value: "+ CardData.getValue(number));
        }
    }
}