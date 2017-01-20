package com.acquisio.basic.java.question05;


import java.util.ArrayList;
import java.util.List;

class Inventory {

    private List<Item> items = new ArrayList<>();

    public void add(Item item) {
        items.add(item);
    }

    public Item getFirst() {
        if (items.size() > 0) {
            return items.get(0);
        }
        return null;
    }

    public Item getLast() {
        int size = items.size();
        if (size > 0) {
            return items.get(size - 1);
        }
        return null;
    }


    public boolean remove(Item item) {
        return items.remove(item);
    }

    public Item findFirst(String name) {
        for (Item item : items) {
            if (item.getName().equals(name)) {
                return item;
            }
        }
        return null;
    }
    
    public List<Item> getItems() {
        return items;
    }
}
