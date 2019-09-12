package com.wipro.price.Exception;

public class PriceNotFoundException extends Throwable {
    public PriceNotFoundException(String errorMessage) {
        super(errorMessage);
    }
}
