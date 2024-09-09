package com.telefonica.pruebatecnicaedgr.prueba_tecnica_edgr.controlleradvices;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.telefonica.pruebatecnicaedgr.prueba_tecnica_edgr.exceptions.CustomHttpException;

@RestControllerAdvice
public class GlobalExceptionsHandler {
    @ExceptionHandler(CustomHttpException.class)
    public ResponseEntity<Object> handleCustomHttpException(CustomHttpException ex) {
        return new ResponseEntity<>(new ErrorResponse(ex.getStatusCode().value(), ex.getMessage()), ex.getStatusCode());
    }
}

class ErrorResponse {
    private final int statusCode;
    private final String message;

    public ErrorResponse(int statusCode, String message) {
        this.statusCode = statusCode;
        this.message = message;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public String getMessage() {
        return message;
    }
}