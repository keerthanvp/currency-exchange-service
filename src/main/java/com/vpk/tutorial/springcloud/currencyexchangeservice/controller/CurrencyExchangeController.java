package com.vpk.tutorial.springcloud.currencyexchangeservice.controller;

import com.vpk.tutorial.springcloud.currencyexchangeservice.model.CurrencyExchange;
import com.vpk.tutorial.springcloud.currencyexchangeservice.service.CurrencyExchangeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyExchangeController {

    @Autowired
    private Environment environment;

    @Autowired
    private CurrencyExchangeService currencyExchangeService;

    private static final Logger logger = LoggerFactory.getLogger(CurrencyExchangeController.class);

    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public CurrencyExchange retrieve(@PathVariable String from, @PathVariable String to) {
        logger.info("currency exchange {} - {}", from, to);
        CurrencyExchange currencyExchange = currencyExchangeService.retrieve(from, to);
        currencyExchange.setEnvironment(environment.getProperty("local.server.port"));
        return currencyExchange;
    }

}
