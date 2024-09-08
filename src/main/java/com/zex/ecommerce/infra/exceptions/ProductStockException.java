package com.zex.ecommerce.infra.exceptions;

public class ProductStockException extends RuntimeException{

    public ProductStockException(String message) {
        super(message);
    }
}
