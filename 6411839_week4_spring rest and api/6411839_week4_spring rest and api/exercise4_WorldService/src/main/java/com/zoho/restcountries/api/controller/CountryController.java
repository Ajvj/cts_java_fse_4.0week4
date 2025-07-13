package com.zoho.restcountries.api.controller;

import com.zoho.restcountries.api.model.Country;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/countries")
public class CountryController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CountryController.class);

    // POST: Add a country
    @PostMapping
    public Country addCountry(@RequestBody @Valid Country country) {
        LOGGER.info("Start addCountry()");
        LOGGER.info("Country Code: {}", country.getCode());
        LOGGER.info("Country Name: {}", country.getName());
        return country;
    }

    // GET: Help message for browser access
    @GetMapping
    public String handleGet() {
        return "Use POST /countries with a JSON payload to add a country.";
    }
}

