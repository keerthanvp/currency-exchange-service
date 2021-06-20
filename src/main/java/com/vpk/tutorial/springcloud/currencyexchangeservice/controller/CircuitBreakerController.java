package com.vpk.tutorial.springcloud.currencyexchangeservice.controller;

import io.github.resilience4j.retry.annotation.Retry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CircuitBreakerController {

    private static final Logger logger = LoggerFactory.getLogger(CircuitBreakerController.class);

    @GetMapping("/sample-api")
    @Retry(name = "sample-api", fallbackMethod = "sampleAPIFallback")
    public String sampleAPI(){
        logger.info("Sample API call received");
        ResponseEntity<String> responseEntity = new RestTemplate()
                .getForEntity("http://localhost:8000/dummy-url",String.class);
        return responseEntity.getBody();
    }

    private String sampleAPIFallback(Exception e){
        return "Fallback response for Sample API";
    }
}
