package com.zex.ecommerce.infra.exceptions;

import org.springframework.http.HttpStatus;

public record ExceptionMessage(String message, HttpStatus httpStatus) {
}
