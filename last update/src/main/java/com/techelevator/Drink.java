package com.techelevator;

import java.math.BigDecimal;

public class Drink extends Beverages{
    public Drink(String name, BigDecimal price) {
        super(name, price);
    }
  @Override
  public String makeSound(){

        return "Glug Glug, Yum!";

  }
}
