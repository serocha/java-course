public class ModifiableItem extends Item {

    private String size;
    private double smallPrice;
    private double largePrice;

    public ModifiableItem(String type, double price, double smallPrice, double largePrice) {
        this(type, price, "Reg", smallPrice, largePrice);
    }

    public ModifiableItem(String type, double price, String size, double smallPrice, double largePrice) {
        super(type, price);
        this.size = size;
        this.smallPrice = smallPrice;
        // this.getPrice = regular price
        this.largePrice = largePrice;
    }

    public String getSize() {
        return size;
    }

    public void setSmallPrice(double smallPrice) {
        this.smallPrice = smallPrice;
    }

    public void setLargePrice(double largePrice) {
        this.largePrice = largePrice;
    }

    public void setSize(String size) {
        this.size = size;
    }

    @Override
    public double getPrice() {
        return switch (size.toUpperCase()) {
            case "SM" -> smallPrice;
            case "REG" -> super.getPrice();
            case "LG" -> largePrice;
            default -> {
                System.out.println("Something went wrong.");
                yield -1;
            }
        };
    }
}
