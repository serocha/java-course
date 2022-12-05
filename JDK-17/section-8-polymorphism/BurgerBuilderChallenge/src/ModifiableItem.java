public class ModifiableItem extends Item {

    private String size;
    private double smallPrice;
    private double largePrice;

    public ModifiableItem(String type, double price, double smallPrice, double largePrice) {
        this(type, price, Main.REGULAR, smallPrice, largePrice);
    }

    public ModifiableItem(String type, double price, String size, double smallPrice, double largePrice) {
        super(type, price);
        this.size = size;
        this.smallPrice = smallPrice;
        this.largePrice = largePrice;
    }

    public void setSize(String size) {
        this.size = size;
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

    @Override
    public double getPrice() {
        return switch(size) {
            case Main.SMALL -> smallPrice;
            case Main.REGULAR -> super.getPrice();
            case Main.LARGE -> largePrice;
            default -> {
                System.out.println("Wrong size in getPrice() of " + this.getClass().getSimpleName());
                yield -1;
            }
        };
    }

    @Override
    public String printTicket() {
        return size + " " + Main.MODIFIED_FORMAT.formatted(getType(), getPrice());
    }
}
