package com.vpk.tutorial.springcloud.currencyexchangeservice.service;

import com.vpk.tutorial.springcloud.currencyexchangeservice.model.CurrencyExchange;

public interface CurrencyExchangeService {
    CurrencyExchange retrieve(String from, String to);
}
