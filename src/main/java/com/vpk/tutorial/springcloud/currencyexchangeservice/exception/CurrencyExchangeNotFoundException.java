package com.vpk.tutorial.springcloud.currencyexchangeservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CurrencyExchangeNotFoundException extends RuntimeException{
    public CurrencyExchangeNotFoundException(String message) {
        super(message);
    }

    public CurrencyExchangeNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
