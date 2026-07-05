package com.cognizant.spring_learn;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Country {

    private static final Logger LOGGER = LoggerFactory.getLogger(Country.class);

    private String code;
    private String name;
    private String capital;
    private String currency;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        LOGGER.info("Setting country code: {}", code);
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        LOGGER.info("Setting country name: {}", name);
        this.name = name;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        LOGGER.info("Setting capital: {}", capital);
        this.capital = capital;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        LOGGER.info("Setting currency: {}", currency);
        this.currency = currency;
    }

    @Override
    public String toString() {
        return "Country [code=" + code + ", name=" + name + ", capital=" + capital + ", currency=" + currency + "]";
    }
}