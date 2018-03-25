package com.footballdata.responses;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class NotFound extends ResponseEntity<ResultMessage> {
    public NotFound() {
        super(new ResultMessage("League not found."), HttpStatus.NOT_FOUND);
    }
}
