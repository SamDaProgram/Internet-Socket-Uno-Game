package com.config;

import java.util.Random;
public class Shuffle {
    public static int[] generate(int[] identifiers) {
        int length = identifiers.length; // Length of the array
        int[] numbers = identifiers;

        Random random = new Random();
        for (int i = length - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);
            if (j != i) {
                numbers[i] ^= numbers[j];
                numbers[j] ^= numbers[i];
                numbers[i] ^= numbers[j];
            }
        }
        return numbers;
    }
}