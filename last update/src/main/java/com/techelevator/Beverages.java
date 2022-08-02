package com.techelevator;

import java.math.BigDecimal;

public abstract class Beverages {
    private String name;
    private BigDecimal price;


    public Beverages(String name, BigDecimal price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public String toString() {
        String display = name +" "+price;
        return display;
    }

    public abstract String makeSound();
}
