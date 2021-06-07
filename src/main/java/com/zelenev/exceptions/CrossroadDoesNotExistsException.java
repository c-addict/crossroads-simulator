package com.zelenev.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class CrossroadDoesNotExistsException extends RuntimeException {

    public CrossroadDoesNotExistsException(String message) {
        super(message);
    }
}
