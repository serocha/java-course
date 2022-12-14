package com.udemy;

public class StockItem implements Comparable<StockItem> {
    private final String name;
    private double price;
    private int quantityStock;
    private int reservedStock;

    public StockItem(String name, double price) {
        this(name, price, 0);
    }

    public StockItem(String name, double price, int quantityStock) {
        this.name = name;
        this.price = price;
        this.quantityStock = quantityStock;
        this.reservedStock = 0;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int quantityInStock() {
        return quantityStock;
    }

    public int quantityReserved() {
        return reservedStock;
    }

    public void setPrice(double price) {
        if (price > 0.0) {
            this.price = price;
        }
    }

    protected void reserveStock(int quantity) {
        if (quantity > 0 && quantity <= (this.quantityStock - this.reservedStock)) {
            this.reservedStock += quantity;
        }
    }

    protected void freeStock(int quantity) {
        if (quantity > 0 && (this.reservedStock >= quantity)) {
            this.reservedStock -= quantity;
        }
    }

    protected void adjustStock(int quantity) {
        int newQuantity = this.quantityStock + quantity;
        if (newQuantity >= 0) {
            this.quantityStock = newQuantity;
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }

        if (obj == null || this.getClass() != obj.getClass()) {
            return false;
        }

        String objName = ((StockItem) obj).getName();
        return this.name.equals(objName);
    }

    @Override
    public int hashCode() {
        return this.name.hashCode() + 32;
    }

    @Override
    public int compareTo(StockItem item) {
        if (this == item) {
            return 0;
        }
        if (item != null) {
            return this.name.compareTo(item.getName()); // compareTo of the Strings
        }

        throw new NullPointerException(); // if it makes it this far, you're trying to compare a null
    }

    @Override
    public String toString() {
        return this.name + ": $" + this.price;
    }
}
