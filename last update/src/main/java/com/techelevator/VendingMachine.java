package com.techelevator;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class VendingMachine {
    BigDecimal balance = new BigDecimal(0.00).setScale(2);
    List<Beverages> purchaseList = new ArrayList<>();
    Map<String, List<Beverages>> inventory = new TreeMap<>();
    LogWriter writer = new LogWriter();

    public VendingMachine(Map<String, List<Beverages>> inventory) {
        this.inventory = inventory;
    }

    public void displayInventory() {
        for (Map.Entry<String, List<Beverages>> entry : inventory.entrySet()) {
            String key = entry.getKey();
            List value = entry.getValue();
            if (value.size()-1 == 0) {
                System.out.println(key +" "+value+ " Out of stock");
            } else {
                System.out.println(key + " " + value.subList(0, 1) + " " + (value.size() - 1));
            }

        }
    }

    public void feedMoney(int addMoney) {
        String typeOfTransaction = "FEED MONEY:";
        if (addMoney == 1) {
            balance = balance.add(new BigDecimal(1.00));
            writer.writer(typeOfTransaction, new BigDecimal(1.00).setScale(2), balance);

        } else if (addMoney == 2) {
            balance = balance.add(new BigDecimal(2.00));
           writer.writer(typeOfTransaction, new BigDecimal(2.00).setScale(2), balance);
        } else if (addMoney == 3) {
            balance = balance.add(new BigDecimal(5.00));
            writer.writer(typeOfTransaction, new BigDecimal(5.00).setScale(2), balance);
        } else if (addMoney == 4) {
            balance = balance.add(new BigDecimal(10.00));
            writer.writer(typeOfTransaction, new BigDecimal(10.00).setScale(2), balance);
        }
        //System.out.println("Your balance is " + balance);
    }

    public void completeTransaction() {
        Change thisChange = new Change();
        thisChange.giveChange(balance);
        writer.writer("GIVE CHANGE:", balance, new BigDecimal(0.00).setScale(2));
        while (purchaseList.size() > 0) {
            Beverages purchases = purchaseList.remove(0);
            System.out.println(purchases.makeSound());

        }
        System.exit(0);
    }



    public void purchase(String guestSelection) {
        if (! inventory.containsKey(guestSelection)) {
            System.out.println("Sorry that product does not exist, please choose a valid product");
        }
        try {
        if (inventory.containsKey(guestSelection)) {


            if (inventory.get(guestSelection).size() - 1 == 0) {
                System.out.println("Sorry "+"("+ guestSelection+")"+" is out of stock");
            }
            if (inventory.get(guestSelection).size()-1 >  0) {
                if (balance.compareTo(inventory.get(guestSelection).get(0).getPrice()) >= 0) {
                    balance = balance.subtract(inventory.get(guestSelection).get(0).getPrice());
                    Beverages p = inventory.get(guestSelection).remove(0);
                    purchaseList.add(p);
                    Beverages cost = inventory.get(guestSelection).get(1);
                    BigDecimal costOne = cost.getPrice();
                    Beverages nameOne = inventory.get(guestSelection).get(0);
                    String productOne = nameOne.getName() + " " + guestSelection;
                    writer.writer(productOne, costOne, balance);
                } else {
                    System.out.println("Sorry, you don't have enough money to buy the item ! ");
                }
            }
        }
            }catch (IndexOutOfBoundsException e){
                e.getMessage();
            }

        //System.out.println("Your balance is " + balance);
    }


}
