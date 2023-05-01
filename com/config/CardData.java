package com.config;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.io.IOException;
import org.json.simple.parser.ParseException;


public class CardData {
    protected static String[] colors;
    protected static String[] values;
    protected static boolean[] stackableFlags;
    protected static int[] cardNumbers;

    public static void init() throws IOException, ParseException, Exception {
        JSONParser parser = new JSONParser();
        try (FileReader reader = new FileReader("com/config/data.json")) {
            Object obj = parser.parse(reader);
            JSONObject jsonObject = (JSONObject) obj;
            JSONObject cards = (JSONObject) jsonObject.get("cards");
            int numCards = cards.size();
            cardNumbers = new int[numCards];
            int index = 0;
            for (Object key : cards.keySet()) {
                cardNumbers[index++] = Integer.parseInt((String) key);
            }

            colors = new String[numCards];
            values = new String[numCards];
            stackableFlags = new boolean[numCards];

            for (int cardNumber : cardNumbers) {
                JSONObject cardObj = (JSONObject) cards.get(String.valueOf(cardNumber));
                colors[cardNumber] = (String) cardObj.get("color");
                values[cardNumber] = (String) cardObj.get("value");
                stackableFlags[cardNumber] = (Boolean) cardObj.get("stackable");
            }
        } catch (IOException e) {
            throw new IOException("Error reading the file: " + e.getMessage());
        } catch (ParseException e) {
            throw new ParseException(e.getPosition(), "Error parsing the JSON file: " + e.getMessage());
        } catch (Exception e) {
            throw new Exception("An error occurred during initialization: " + e.getMessage());
        }
    }


    public static String getColor(int cardNumber) throws Exception {
        try {
            init();
        } catch (IOException e) {
            System.err.println(Presets.ERRORPRESET+"reading the JSON configuration file: " + e.getMessage());
        } catch (ParseException e) {
            System.err.println(Presets.ERRORPRESET+"unable to parse JSON configuration file: " + e.getMessage());
        } catch (Exception e) {
            System.err.println(Presets.ERRORPRESET+"An error occurred during agent initialization: " + e.getMessage());
        }
        if (cardNumber < 0 || cardNumber >= colors.length) {
            throw new IllegalArgumentException("Invalid card number");
        }
        return colors[cardNumber];
    }

    public static int[] getAll() throws Exception {
        try {
            init();
        } catch (IOException e) {
            System.err.println(Presets.ERRORPRESET+"reading the JSON configuration file: " + e.getMessage());
        } catch (ParseException e) {
            System.err.println(Presets.ERRORPRESET+"unable to parse JSON configuration file: " + e.getMessage());
        } catch (Exception e) {
            System.err.println(Presets.ERRORPRESET+"An error occurred during agent initialization: " + e.getMessage());
        }

        return cardNumbers;
    }

    public static String getValue(int cardNumber) throws IllegalArgumentException {
        try {
            init();
        } catch (IOException e) {
            System.err.println(Presets.ERRORPRESET+"reading the JSON configuration file: " + e.getMessage());
        } catch (ParseException e) {
            System.err.println(Presets.ERRORPRESET+"unable to parse JSON configuration file: " + e.getMessage());
        } catch (Exception e) {
            System.err.println(Presets.ERRORPRESET+"An error occurred during agent initialization: " + e.getMessage());
        }
        if (cardNumber < 0 || cardNumber >= values.length) {
            throw new IllegalArgumentException("Invalid card number");
        }
        return values[cardNumber];
    }

    public static boolean isStackable(int cardNumber) throws IllegalArgumentException {
        try {
            init();
        } catch (IOException e) {
            System.err.println(Presets.ERRORPRESET+"reading the JSON configuration file: " + e.getMessage());
        } catch (ParseException e) {
            System.err.println(Presets.ERRORPRESET+"unable to parse JSON configuration file: " + e.getMessage());
        } catch (Exception e) {
            System.err.println(Presets.ERRORPRESET+"An error occurred during agent initialization: " + e.getMessage());
        }
        if (cardNumber < 0 || cardNumber >= stackableFlags.length) {
            throw new IllegalArgumentException("Invalid card number");
        }
        return stackableFlags[cardNumber];
    }


}