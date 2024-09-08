package com.zex.ecommerce.infra.exceptions;


import org.springframework.validation.FieldError;

public record ValidationMessageError(String field, String message) {

    public ValidationMessageError(FieldError fieldError) {
        this(fieldError.getField(), fieldError.getDefaultMessage());
    }
}
