package com.telefonica.pruebatecnicaedgr.prueba_tecnica_edgr.exceptions;

import org.springframework.http.HttpStatus;

public class CustomHttpException extends RuntimeException{
    private final HttpStatus statusCode;
    private final String message;
    
    public CustomHttpException(HttpStatus statusCode, String message) {
        super(message);
        this.statusCode = statusCode;
        this.message = message;
    }

    public HttpStatus getStatusCode() {
        return statusCode;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
