package com.amaap.merchantsguide.config;

import java.util.HashMap;
import java.util.Map;

public class ConfigValidator {
    private final Map<String, Character> units = new HashMap<>();
    private final Map<Integer, String> transaction = new HashMap<>();
    private final Map<Integer, String> metals = new HashMap<>();

    public ConfigValidator() {
        loadData();
    }

    private void loadData() {

     units.put("glob", 'I');
     units.put("prok", 'V');
     units.put("pish", 'X');
     units.put("tegj", 'L');

     transaction.put(1,"glob glob");
     transaction.put(2,"glob prok");
     transaction.put(3,"pish pish");

     metals.put(1,"Silver");
     metals.put(2, "Gold");
     metals.put(3, "Iron");

    }

    public Map<String, Character> getUnits() {
        return units;
    }

    public Map<Integer, String> getTransaction() {
        return transaction;
    }

    public Map<Integer, String> getMetals() {
        return metals;
    }

}
