package com.casado.rest.challenge.controller;

import com.casado.rest.challenge.entity.OrderBook;
import com.casado.rest.challenge.exception.OrderBookIdMismatchException;
import com.casado.rest.challenge.exception.OrderBookNotFoundException;
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

@RestController
//@RequestMapping("/v1/api")
@Api
public class OrderBookController {

    @Autowired
    FinancialInstrumentService financialInstrumentService;

    @Autowired
    OrderBookService orderBookService;

    // Premise 1_AUTHOR -> N_BOOKS
    // Premise 1_AUTHORaD -> N_BOOKS
    // Premise 1_AUTHOR -> N_BOOKS
    // Premise 1_AUTHOR -> N_BOOKS
    // Premise 1_AUTHOR -> N_BOOKS
    // Premise 1_AUTHOR -> N_BOOKS
    // Premise 1_AUTHOR -> N_BOOKS



    //----------------------------------------
    //  GET all
    //----------------------------------------
    @GetMapping(value = "/getAllOrderBooks")
    @ApiOperation(value = "Return all order books.")
    @ApiResponse(code = 200, message = "Order Books successfully retrieved.")
    @ResponseStatus(HttpStatus.OK)
    public List<OrderBook> getOrderBooks() {
        return orderBookService.getAllBooks();
    }

    //----------------------------------------
    //  POST
    //----------------------------------------
    @ApiOperation(value = "Create a orde Book.")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "OrderBook successfully created.")
    })
    @PostMapping(value = "/{financialInstrumentId}/orderBook", consumes = MediaType.APPLICATION_JSON_VALUE)
    public OrderBook createOrderBook(@PathVariable(value = "financialInstrumentId") Long financialInstrumentId, @RequestBody OrderBook orderBook) {
        return orderBookService.createBook(financialInstrumentId, orderBook);
    }

    //----------------------------------------
    //  GET by id
    //----------------------------------------
    @GetMapping(value = "/ordeBook/{bookId}")
    @ApiOperation(value = "Giving an id, returns the book.")
    @ApiResponses(value = {
            @ApiResponse(code = 202, message = "OrderBook successfully retrieved."),
            @ApiResponse(code = 404, message = "The book does not exists.")
    })
    @ResponseStatus(HttpStatus.ACCEPTED)
    public OrderBook getOrderBookById(@PathVariable(value = "bookId") Long orderBookId) throws OrderBookNotFoundException {
        return orderBookService.getBookById(orderBookId).orElseThrow(OrderBookNotFoundException::new);
    }

    //----------------------------------------
    //  PUT updates content
    //----------------------------------------
    @PutMapping(value = "/ordeBook", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Updates financial instrument.")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Financial instrument successfully updated.")
    })
    public OrderBook updateOrderBook(@PathVariable(value = "bookId") Long bookId, @RequestBody OrderBook orderBook)
            throws OrderBookNotFoundException, OrderBookIdMismatchException {

        if (orderBook.getId() != bookId) {
            throw new OrderBookIdMismatchException();
        }
        orderBookService.getBookById(bookId).orElseThrow(OrderBookNotFoundException::new);
        return orderBookService.updateBookById(bookId, orderBook);
    }

    //----------------------------------------
    // DELETE content
    //----------------------------------------
    @DeleteMapping(value = "/ordeBook/{bookId}")
    @ApiOperation(value = "Deletes an financial instrument.")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Financial instrument successfully deleted.")
    })
    public ResponseEntity<Object> deleteOrderBookById(@PathVariable(value = "bookId") long orderBookId) {
        return orderBookService.deleteBookById(orderBookId);
    }
}
