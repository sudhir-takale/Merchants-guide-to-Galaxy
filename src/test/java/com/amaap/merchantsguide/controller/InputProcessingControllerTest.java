package com.amaap.merchantsguide.controller;

import com.amaap.merchantsguide.controller.dto.HttpStatus;
import com.amaap.merchantsguide.controller.dto.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class InputProcessingControllerTest {

    @Test
    void shouldBeAbleToReadInputFile() {
        // arrange
        InputProcessingController inputController = new InputProcessingController();
        Response expectedResponse = new Response(HttpStatus.OK, "File has been processed successfully!");

        // act
        Response actualResponse = inputController.readInputFile("GalacticTransactions.txt");

        // assert
        Assertions.assertEquals(expectedResponse, actualResponse);


    }


}
