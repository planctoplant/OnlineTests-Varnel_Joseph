package com.acquisio.basic.java.question05;

class Fruit extends Item {
    private String color;

    Fruit(String name, String color, int quantity, double price) {
        super(name, quantity, price);
        this.color = color;
    }

    public String getColor() {
        return color;
    }
    
    public String genericStockPrint() {
        return String.format("%s [%s] : %d units", this.getName(), this.getColor(), this.getQuantity());
    }
}
