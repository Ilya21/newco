package com.andreitop.newco.exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.time.Instant;

@Getter
@Setter
class DtoApiError {

    private HttpStatus status;
    private String message;
    private String details;
    private String timestamp;

    DtoApiError(HttpStatus status, String message) {
        this.status = status;
        this.message = status.getReasonPhrase();
        this.details = message;
        this.timestamp = Instant.now().toString();
    }
}

