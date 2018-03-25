package com.footballdata.responses;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class AlreadyExists extends ResponseEntity<ResultMessage> {
    public AlreadyExists() {
        super(new ResultMessage("League Already Imported"), HttpStatus.CONFLICT);
    }
}