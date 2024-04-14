package com.amaap.merchantsguide.service.validator;

public class TransactionValidator {
    public static boolean validateTransaction(String unit, String metal, int credits) {
        return unit.isEmpty() || metal.isEmpty() || credits < 0;
    }
}
