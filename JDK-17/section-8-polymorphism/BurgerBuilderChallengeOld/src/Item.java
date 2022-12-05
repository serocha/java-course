public class Item {

    private final String type;
    private double price;

    public Item(String type, double price) {
        this.type = type;
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public double getPrice() {
        return price;
    }

    protected void setPrice(double price) {
        this.price = price;
    }

    public String getSize() {
        return "Reg";
    }

    public void setSmallPrice(double smallPrice) {

    }

    public void setLargePrice(double largePrice) {

    }
}
