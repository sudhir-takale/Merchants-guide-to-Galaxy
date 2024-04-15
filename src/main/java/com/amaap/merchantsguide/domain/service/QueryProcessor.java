package com.amaap.merchantsguide.domain.service;

import com.amaap.merchantsguide.domain.model.valueobject.RomanNumeral;


public class QueryProcessor {


    public int convertToNumber(String romanNumeral) {

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

}
