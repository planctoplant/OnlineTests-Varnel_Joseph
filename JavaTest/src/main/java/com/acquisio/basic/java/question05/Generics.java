package com.acquisio.basic.java.question05;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * QUESTION 5: Generics
 * Here is a design of a class that acts as stock of vehicules:
 * Vegetable, Fruit, and Motorcycle.
 * <p>
 * Provide a version of this class that uses generics.
 * Feel free to add any additional fields.
 * Make sure that the method stockInventory() is working properly
 * by uncommenting lines.
 *
 * IMPORTANT: Add all missing javadoc that you think is necessary.
 */
public class Generics {
    public static void main(String[] args) {
        Generics instance = new Generics();
        instance.stockInventory();
    }
    
    private class Stock {
        private Map<Class, Inventory> stockMapHash = new HashMap<Class, Inventory>();
        
        public void add(Inventory inventoryType, Class Typename) {
            stockMapHash.put(Typename, inventoryType);
        }
        
        public void printStock() {
            Iterator iterator = stockMapHash.keySet().iterator();
            while(iterator.hasNext() ) {
              Object key   = iterator.next();
              Inventory value = stockMapHash.get(key);
              
              for(Item inventoryItem : value.getItems()) {
                //System.out.println(Class key.toString() inventoryItem.genericStockPrint());  
                System.out.println(inventoryItem.genericStockPrint() );
              }
              
            }
        }

    }
    
    private void stockInventory() {
        Stock currentStock = new Stock();
        currentStock.add(getFruitInventory(), Fruit.class);
        currentStock.add(getVegetableInventory(), Vegetable.class);
        currentStock.printStock();
        
        // TODO: The following code should work with generics.
        //Inventory fruitInventory = getFruitInventory();
        //Fruit apple = (Fruit) fruitInventory.findFirst("Apple");
        //System.out.println(String.format("Apple [%s] : %d units", apple.getColor(), apple.getQuantity()));
        //Inventory vegetableInventory = getVegetableInventory();
        //Vegetable salad = (Vegetable) vegetableInventory.findFirst("Salad");
        //System.out.println(String.format("Salad [%s] : %d units", salad.getType(), salad.getQuantity()));
    }

    private Inventory getVegetableInventory() {
        Inventory vegetableInventory = new Inventory();
        vegetableInventory.add(new Vegetable("Salad", "Iceberg", "Québec", 19, 1.39d));
        vegetableInventory.add(new Vegetable("Salad", "Boston", "Québec", 18, 1.39d));
        vegetableInventory.add(new Vegetable("Salad", "Iceberg", "USA", 17, 1.39d));
        return vegetableInventory;
    }

    private Inventory getFruitInventory() {
        Inventory fruitInventory = new Inventory();
        fruitInventory.add(new Fruit("Apple", "red", 50, 0.99d));
        fruitInventory.add(new Fruit("Apple", "green", 45, 1.29d));
        fruitInventory.add(new Fruit("Banana", "yellow", 150, 0.49d));
        fruitInventory.add(new Fruit("Pineapple", "yellow", 10, 8.99d));
        return fruitInventory;
    }

    public void printStockInventory() {
        this.stockInventory();
    }
}
