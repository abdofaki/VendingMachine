package com.techelevator;

import java.math.BigDecimal;

public class Chips extends Beverages{
    public Chips(String name, BigDecimal price) {
        super(name, price);
    }

    public String makeSound(){

        return "Crunch Crunch, Yum!";

    }
}
