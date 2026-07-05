package com.cognizant.spring_learn;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Country {

    private static final Logger LOGGER = LoggerFactory.getLogger(Country.class);

    private String name;
    private String capital;
    private String currency;

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
        return "Country [name=" + name + ", capital=" + capital + ", currency=" + currency + "]";
    }
}