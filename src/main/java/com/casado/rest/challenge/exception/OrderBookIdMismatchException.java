package com.casado.rest.challenge.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class OrderBookIdMismatchException extends Exception {
    public OrderBookIdMismatchException() {
        super("The received id does not match with the Order Book id in the body.");
    }
}
