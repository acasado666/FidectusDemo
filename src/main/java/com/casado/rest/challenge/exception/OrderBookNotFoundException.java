package com.casado.rest.challenge.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class OrderBookNotFoundException extends Exception {
    public OrderBookNotFoundException() {
        super("Order Book not found.");
    }

    public OrderBookNotFoundException(String message) {
        super(message);
    }
}
