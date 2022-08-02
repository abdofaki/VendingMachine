package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.*;

public class Inventory {

    public Map<String, List<Beverages>> fileImporter() {
        File inventoryFile = new File("/Users/abdo/Desktop/practice/capstone-1/vendingmachine.csv");

        Map<String, List<Beverages>> vendingMachineInventory = new TreeMap<>();

        try (Scanner stockImporter = new Scanner(inventoryFile)) {
            while (stockImporter.hasNextLine()) {
                String line = stockImporter.nextLine();
                if (!line.isEmpty()) {
                    String[] stockImporterArray = line.split("\\|");

                    if (stockImporterArray[0].contains("A")) {
                        List<Beverages> productArray = new ArrayList<>();
                        for (int i = 0; i < 6; i++) {
                            Chips temp = new Chips(stockImporterArray[1],
                                    new BigDecimal(stockImporterArray[2]));
                            productArray.add(temp);
                        }
                        vendingMachineInventory.put(stockImporterArray[0], productArray);

                    } else if (stockImporterArray[0].contains("B")) {
                        List<Beverages> productArray = new ArrayList<>();
                        for (int i = 0; i < 6; i++) {
                            Candy temp = new Candy(stockImporterArray[1],
                                    new BigDecimal(stockImporterArray[2]));
                            productArray.add(temp);
                        }
                        vendingMachineInventory.put(stockImporterArray[0], productArray);

                    } else if (stockImporterArray[0].contains("C")) {
                        List<Beverages> productArray = new ArrayList<>();
                        for (int i = 0; i < 6; i++) {

                            Drink temp = new Drink(stockImporterArray[1],
                                    new BigDecimal(stockImporterArray[2]));
                            productArray.add(temp);
                        }
                        vendingMachineInventory.put(stockImporterArray[0], productArray);

                    } else {
                        List<Beverages> productArray = new ArrayList<>();

                        for (int i = 0; i < 6; i++) {
                            Gum temp = new Gum(stockImporterArray[1],
                                    new BigDecimal(stockImporterArray[2]));
                            productArray.add(temp);
                        }
                        vendingMachineInventory.put(stockImporterArray[0], productArray);
                    }
                }
            }
            return vendingMachineInventory;

        } catch (FileNotFoundException e) {
            System.out.println("Your file does not exist");
            System.exit(1);
            return vendingMachineInventory;
        }
    }

   }


