package com.amaap.merchantsguide.service.dto;

public class GalacticTranslationDto {
    private String galacticUnit;
    private char romanNumeral;

    public GalacticTranslationDto(String galacticUnit, char romanNumeral) {
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
