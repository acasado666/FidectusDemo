package com.casado.rest.challenge.controller;

import com.casado.rest.challenge.entity.FinancialInstrument;
import com.casado.rest.challenge.service.FinancialInstrumentService;
import com.casado.rest.challenge.service.OrderBookService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
//@RequestMapping("/v1/api")
@Api
public class FinancialInstrumentController {

    @Autowired
    FinancialInstrumentService financialInstrumentService;

    @Autowired
    OrderBookService orderBookService;

    // Premise 1_AUTHOR -> N_BOOKS

    //----------------------------------------
    //  GET all
    //----------------------------------------
    @GetMapping(value = "/financialInstrument")
    @ApiOperation(value = "Return all authors.")
    @ApiResponse(code = 200, message = "Financial Instruments successfully retrieved.")
    @ResponseStatus(HttpStatus.OK)
    public List<FinancialInstrument> getFinancialInstruments() {
        return financialInstrumentService.getFinancialInstruments();
    }

    //----------------------------------------
    //  POST
    //----------------------------------------
    @ApiOperation(value = "Create an financial instrument.")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Financial instrument successfully created.")
    })
    @PostMapping(value = "/financialInstrument", consumes = MediaType.APPLICATION_JSON_VALUE)
    public FinancialInstrument createAuthor(@RequestBody FinancialInstrument author) {
        return financialInstrumentService.createFinancialInstrument(author);
    }

    //----------------------------------------
    //  GET by id
    //----------------------------------------
    @GetMapping(value = "/financialInstrument/{financialInstrumentId}")
    @ApiOperation(value = "Giving an id, returns the author.")
    @ApiResponses(value = {
            @ApiResponse(code = 202, message = "Financial Instrument successfully retrieved."),
            @ApiResponse(code = 404, message = "The Financial Instrument does not exists.")
    })
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Optional<FinancialInstrument> getFinancialInstrumentById(@PathVariable(value = "financialInstrumentId") Long financialInstrumentId) {
        Optional<FinancialInstrument> financialInstrumentById = financialInstrumentService.getFinancialInstrumentById(financialInstrumentId);
        return financialInstrumentById;
    }

    @GetMapping(value = "/financialInstrument2/{financialInstrumentId}")
    @ApiOperation(value = "Giving an id, returns the financial Instrument.")
    @ApiResponses(value = {
            @ApiResponse(code = 202, message = "FinancialInstrument successfully retrieved."),
            @ApiResponse(code = 404, message = "The Financial Instrument does not exists.")
    })
    @ResponseStatus(HttpStatus.ACCEPTED)
    public FinancialInstrument getFinancialInstrument(@PathVariable(value = "financialInstrumentId") Long financialInstrumentId) {
        FinancialInstrument authorById = financialInstrumentService.getFinancialInstrument(financialInstrumentId);
        return authorById;
    }

    //----------------------------------------
    //  PUT updates content
    //----------------------------------------
    @PutMapping(value = "/financialInstrument", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Updates financial instrument.")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Financial instrument successfully updated.")
    })
    public FinancialInstrument updateFinancialInstrument(@PathVariable(value = "authorId") Long authorId, @RequestBody FinancialInstrument financialInstrument) {
        return financialInstrumentService.updateFinancialInstrumentById(authorId, financialInstrument);
    }

    //----------------------------------------
    // DELETE content
    //----------------------------------------
    @DeleteMapping(value = "/financialInstrument/{financialInstrumentId}")
    @ApiOperation(value = "Deletes an financial instrument.")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Financial instrument successfully deleted.")
    })
    public ResponseEntity<Object> deleteFinancialInstrumentById(@PathVariable(value = "financialInstrumentId") long financialInstrumentId) {
        return financialInstrumentService.deleteFinancialInstrumentById(financialInstrumentId);
    }

}
