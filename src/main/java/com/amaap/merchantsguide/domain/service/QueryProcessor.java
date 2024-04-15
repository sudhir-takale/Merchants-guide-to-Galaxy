package com.amaap.merchantsguide.domain.service;

import com.amaap.merchantsguide.domain.model.valueobject.RomanNumeral;


public class QueryProcessor {


    public static int convertToNumber(String romanNumeral) {

        int result = 0;
        int prevValue = 0;

        for (int i = romanNumeral.length() - 1; i >= 0; i--) {
            char currentChar = romanNumeral.charAt(i);
            RomanNumeral currentNumeral = RomanNumeral.valueOf(String.valueOf(currentChar));
            int currentValue = currentNumeral.getValue();

            if (currentValue < prevValue) {
                result -= currentValue;
            } else {
                result += currentValue;
            }

            prevValue = currentValue;
        }

        return result;
    }


    public static void processQuery(String query, String romanValue, double credits) {
        int number = convertToNumber(romanValue);
        int totalCredits = (int) (number * credits);
        System.out.println(query + " is " + totalCredits + " Credits");
    }

    public static void processInvalidQuery(String query) {
        System.out.println("I have no idea what you are talking about");
    }

    public static void processQueryWithoutMetal(String query, String romanValue) {
        int credit = convertToNumber(romanValue);
        System.out.println(query + " " + credit);

    }
}
