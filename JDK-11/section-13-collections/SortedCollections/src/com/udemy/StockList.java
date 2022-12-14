package com.udemy;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class StockList {

    private final Map<String, StockItem> list;

    public StockList() {
        this.list = new LinkedHashMap<>();
    }

    public int addStock(StockItem item) {
        if (item != null) {
            // check if it was in stock
            StockItem inStock = list.getOrDefault(item.getName(), item); // either way it gets an item
            // if it was in the map, adjust the quantity instead
            if (inStock != item) {
                item.adjustStock(inStock.quantityInStock());
            }

            list.put(item.getName(), item);
            return item.quantityInStock();
        }
        return 0; // nothing added
    }

    public int sellStock(String item, int quantity) {
        StockItem inStock = list.getOrDefault(item, null);
        if ((inStock != null) && (inStock.quantityInStock() > quantity) && (quantity > 0)) {
            inStock.adjustStock(-quantity); // deduct stock
            return quantity;
        }
        return 0;
    }

    public StockItem get(String key) {
        return list.get(key);
    }

    public Map<String, StockItem> Items() {
        return Collections.unmodifiableMap(list);
        // return a map with read-only access, faster than returning a new copy
    }

    public Map<String, Double> PriceList() {
        Map<String, Double> prices = new HashMap<>();
        for (Map.Entry<String, StockItem> item : list.entrySet()) {
            prices.put(item.getKey(), item.getValue().getPrice());
        }
        return Collections.unmodifiableMap(prices);
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder("\nStock List\n");
        double totalCost = 0.0;

        for (Map.Entry<String, StockItem> item : list.entrySet()) {
            StockItem stockItem = item.getValue();
            double itemValue = stockItem.getPrice() * stockItem.quantityInStock();
            s.append("""
                    %s. There are %d in stock. Value of items: $%,.2f
                    """.formatted(stockItem, stockItem.quantityInStock(), itemValue));
            totalCost += itemValue;
        }
        return s + "Total stock value: $%,.2f".formatted(totalCost);
    }
}
