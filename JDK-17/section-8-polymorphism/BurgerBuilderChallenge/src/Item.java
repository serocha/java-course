public class Item {

    private final String type;
    private double price;

    public Item(String type, double price) {
        this.type = type;
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public String getType() {
        return type;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setSize(String size) {
        // placeholder for override (must be a better way)
    }

    public String getSize() {
        return "";
    }

    public String printTicket() {
        return Main.ITEM_FORMAT.formatted(getType(), getPrice());
    }
}
