package com.footballdata.responses;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class Success extends ResponseEntity<ResultMessage> {
    public Success() {
        super(new ResultMessage("Succesfully Imported"), HttpStatus.CREATED);
    }
}