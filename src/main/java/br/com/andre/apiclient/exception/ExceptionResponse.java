package br.com.andre.apiclient.exception;

import org.springframework.validation.FieldError;

public class ExceptionResponse {
    public String field;
    public String message;

    public ExceptionResponse (FieldError fieldError) {
        this.field = fieldError.getField();
        this.message = fieldError.getDefaultMessage();
    }
}
