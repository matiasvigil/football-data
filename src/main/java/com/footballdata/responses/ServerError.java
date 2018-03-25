package com.footballdata.responses;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ServerError extends ResponseEntity<ResultMessage> {
    public ServerError() {
        super(new ResultMessage("Server Error"), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}