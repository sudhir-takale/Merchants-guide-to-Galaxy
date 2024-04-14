package com.amaap.merchantsguide.controller;

import com.amaap.merchantsguide.controller.dto.HttpStatus;
import com.amaap.merchantsguide.controller.dto.Response;
import com.amaap.merchantsguide.service.FileProcessingService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

public class InputProcessingControllerTest {

    @Test
    void shouldBeAbleToReadInputFile() throws FileNotFoundException {
        // arrange
        InputProcessingController inputController = new InputProcessingController(new FileProcessingService());
        Response expectedResponse = new Response(HttpStatus.OK, "File has been processed successfully!");

        // act
        Response actualResponse = inputController.readInputFile("D:\\Tasks\\Merchant-Guide\\src\\test\\java\\com\\amaap\\merchantsguide\\resources\\GalacticTransactions.txt");

        // assert
        Assertions.assertEquals(expectedResponse, actualResponse);


    }


}
