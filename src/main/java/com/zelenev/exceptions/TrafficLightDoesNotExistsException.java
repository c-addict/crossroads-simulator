package com.zelenev.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class TrafficLightDoesNotExistsException extends RuntimeException{

    public TrafficLightDoesNotExistsException(String message) {
        super(message);
    }
}
