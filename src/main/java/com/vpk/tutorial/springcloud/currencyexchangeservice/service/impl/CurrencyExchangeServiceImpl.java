package com.vpk.tutorial.springcloud.currencyexchangeservice.service.impl;

import com.vpk.tutorial.springcloud.currencyexchangeservice.exception.CurrencyExchangeNotFoundException;
import com.vpk.tutorial.springcloud.currencyexchangeservice.model.CurrencyExchange;
import com.vpk.tutorial.springcloud.currencyexchangeservice.repository.CurrencyExchangeRepository;
import com.vpk.tutorial.springcloud.currencyexchangeservice.service.CurrencyExchangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CurrencyExchangeServiceImpl implements CurrencyExchangeService {

    @Autowired
    private CurrencyExchangeRepository repository;

    @Override
    public CurrencyExchange retrieve(String from, String to) {
        CurrencyExchange currencyExchange = repository.findByFromAndTo(from, to);
        if (currencyExchange==null)
            throw new CurrencyExchangeNotFoundException("Currency from: "+from+" to: "+to+" not found");
        return currencyExchange;
    }
}
