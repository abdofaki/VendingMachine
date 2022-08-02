package com.techelevator;

import java.math.BigDecimal;

public class Candy extends Beverages{

    public Candy(String name, BigDecimal price) {
        super(name, price);
    }

    public String makeSound(){

        return "Munch Munch, Yum";

    }
}
