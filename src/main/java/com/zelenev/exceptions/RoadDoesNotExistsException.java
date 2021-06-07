package com.zelenev.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class RoadDoesNotExistsException extends RuntimeException{

    public RoadDoesNotExistsException(String message) {
        super(message);
    }
}
