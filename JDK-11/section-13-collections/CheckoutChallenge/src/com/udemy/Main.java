package com.udemy;

import java.util.Map;

/*      A simple shopping app that handles baskets, reserving items, and stock levels
 *
 *      Built upon code from a previous assignment, so there's a lot that could be trimmed down
 *      Would require a refactor to clean up access to StockItems and what not
 */
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

        Basket myBasket = new Basket("My Basket");
        Basket yourBasket = new Basket("Another Basket");

        putInBasket(myBasket, "toilet paper", 5);
        removeFromBasket(myBasket, "toilet paper", 4);
        putInBasket(myBasket, "apple", 50);
        putInBasket(myBasket, "cows", 2);
        putInBasket(myBasket, "chicken", 3);

        putInBasket(yourBasket, "mop", 4);
        putInBasket(myBasket, "mop", 1);
        removeFromBasket(yourBasket, "mop", 1);
        putInBasket(myBasket, "mop", 1);

        checkout(yourBasket);
        checkout(myBasket);

        System.out.println(stockList);
    }

    public static int putInBasket(Basket basket, String item, int quantity) {
        // retrieve item first
        StockItem stockItem = stockList.get(item);
        if (stockItem == null) {
            System.out.println(item + " is not carried by this store");
            return 0;
        }
        if (stockList.reserveStock(item, quantity) != 0) {
            basket.addToBasket(stockItem, quantity);
            System.out.println(quantity + " " + item + " added to " + basket.getName());
            return quantity;
        }
        if (stockItem.quantityInStock() - stockItem.quantityReserved() == 0) {
            System.out.println("There are not enough " + item + "s in stock");
        } else {
            System.out.println("Uh oh, attempt to put " + quantity + " " + item + " in basket failed");
        }
        return 0;
    }

    public static int removeFromBasket(Basket basket, String item, int quantity) {
        StockItem stockItem = stockList.get(item);
        if (stockItem == null) {
            System.out.println(item + " is not in basket");
            return 0;
        }
        if (stockList.freeUpStock(item, quantity) != 0) {
            basket.removeFromBasket(stockItem, quantity);
            System.out.println(quantity + " " + item + " removed from " + basket.getName());
            return quantity;
        }
        return 0;
    }

    public static void checkout(Basket basket) {
        double totalPrice = 0;
        System.out.println();
        for (Map.Entry<StockItem, Integer> item : basket.Items().entrySet()) {
            String name = item.getKey().getName();
            int amount = item.getValue();
            System.out.println("Purchasing " + amount + " " + name);
            stockList.sellStock(name, amount);
            stockList.freeUpStock(name, amount);
            totalPrice += stockList.get(name).getPrice() * amount;
        }
        System.out.printf("Checked out %s for $%,.2f\n", basket.getName(), totalPrice);
        basket.clearBasket();
    }
}
