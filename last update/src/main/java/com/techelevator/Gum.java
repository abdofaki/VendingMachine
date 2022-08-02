package com.techelevator;

import java.math.BigDecimal;

public  class Gum extends Beverages{

    public Gum(String name, BigDecimal price) {
        super(name, price);
    }


    public String makeSound() {

       return "Chew Chew, Yum!";


    }
}
