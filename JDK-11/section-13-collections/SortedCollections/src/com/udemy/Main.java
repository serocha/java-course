package com.udemy;

import java.util.Map;

public class Main {
    private static StockList stockList = new StockList();

    public static void main(String[] args) {
        StockItem temp;

        temp = new StockItem("apple", 0.99, 200);
        stockList.addStock(temp);
        temp = new StockItem("bread", 2.89, 100);
        stockList.addStock(temp);
        temp = new StockItem("chicken", 4.49, 50);
        stockList.addStock(temp);
        temp = new StockItem("chips", 3.49, 24);
        stockList.addStock(temp);
        temp = new StockItem("coffee", 7.99, 15);
        stockList.addStock(temp);
        temp = new StockItem("cookies", 6.49, 20);
        stockList.addStock(temp);
        temp = new StockItem("eggs", 2.99, 77);
        stockList.addStock(temp);
        temp = new StockItem("mop", 10.49, 4);
        stockList.addStock(temp);
        temp = new StockItem("pasta", 1.49, 80);
        stockList.addStock(temp);
        temp = new StockItem("pasta", 0.99, 7); // overwrite price
        stockList.addStock(temp);
        temp = new StockItem("toilet paper", 5.99, 35);
        stockList.addStock(temp);
        // LinkedHashMap preserves the order the objects were put in
        System.out.println(stockList);

        Basket billsBasket = new Basket("Bill");
        sellItem(billsBasket, "toilet paper", 1);
        System.out.println(billsBasket);
        sellItem(billsBasket, "mop", 1);
        sellItem(billsBasket, "mop", 10);
        sellItem(billsBasket, "spanner", 2);
        sellItem(billsBasket, "eggs", 4);
        sellItem(billsBasket, "coffee", 2);
        sellItem(billsBasket, "apple", 20);
        System.out.println(billsBasket);
        System.out.println(stockList);

        //temp = new StockItem("pen", 0.99);
        //stockList.Items().put(temp.getName(), temp); trigger UnsupportedOperationException

        // note that we only made StockList.Items() return an unmodifiable, not the Item objects themselves
        stockList.Items().get("mop").adjustStock(400);
        System.out.println(stockList);
        stockList.get("mop").adjustStock(-300);
        System.out.println(stockList);

        // added PriceList() to get a new Map reference so the actual Item objects are not exposed
        for (Map.Entry<String, Double> price : stockList.PriceList().entrySet()) {
            System.out.println(price.getKey() + " costs $" + price.getValue());
        }
    }

    public static int sellItem(Basket basket, String item, int quantity) {
        // retrieve item first
        StockItem stockItem = stockList.get(item);
        if (stockItem == null) {
            System.out.println(item + " is not carried by this store");
            return 0;
        }
        if (stockList.sellStock(item, quantity) != 0) {
            basket.addToBasket(stockItem, quantity);
            return quantity;
        }
        if (quantity > stockItem.quantityInStock()) {
            System.out.println("There are not enough " + item + "s in stock");
        } else {
            System.out.println("Transaction for " + quantity + " " + item + " failed");
        }
        return 0;
    }
}
