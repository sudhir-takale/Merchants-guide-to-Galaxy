package com.amaap.merchantsguide.domain.model.valueobject;

public class GalacticTranslation {
    private int id;
    private String galacticUnit;
    private char romanNumeral;

    public GalacticTranslation(String galacticUnit, char romanNumeral) {
        this.galacticUnit = galacticUnit;
        this.romanNumeral = romanNumeral;
    }

    public String getGalacticUnit() {
        return galacticUnit;
    }

    public char getRomanNumeral() {
        return romanNumeral;
    }


}
