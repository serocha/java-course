package com.udemy;

import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public class Basket {

    private final String name;
    private Map<StockItem, Integer> list;

    public Basket(String name) {
        this.name = name;
        this.list = new TreeMap<>(); // change from HashMap to TreeMap to preserve order, performance cost
    }

    public String getName() {
        return name;
    }

    public int addToBasket(StockItem item, int quantity) {
        if (item != null && quantity > 0) {
            int inBasket = list.getOrDefault(item, 0);
            list.put(item, inBasket + quantity);
            return inBasket;
        }
        return 0;
    }

    public int removeFromBasket(StockItem item, int quantity) {
        if (item != null && quantity > 0) {
            if (list.get(item) > 0 && quantity <= list.get(item)) {
                int inBasket = list.get(item);
                list.put(item, inBasket - quantity);
            }
        }
        return 0;
    }

    public void clearBasket() {
        if (list.isEmpty()) {
            return;
        }
        list = new TreeMap<>();
    }

    public Map<StockItem, Integer> Items() {
        return Collections.unmodifiableMap(list);
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder("\nShopping basket %s contains %d ".formatted(name, list.size()) +
                (list.size() == 1 ? "item" : "items") + "\n");
        double totalCost = 0.0;
        for (Map.Entry<StockItem, Integer> item : list.entrySet()) {
            totalCost += item.getKey().getPrice() * item.getValue();
            s.append("%s each, quantity: %d\n".formatted(item.getKey(), item.getValue()));
        }
        return s + "Total cost $%,.2f".formatted(totalCost);
    }
}
