public class Burger extends Item {

    private final int maxToppings;
    final String includedToppings; // unused for now, could print if desired
    private String toppings;

    public Burger(String type, double price, int maxToppings) {
        this(type, price, maxToppings, null);
    }
    public Burger(String type, double price, int maxToppings, String includedToppings) {
        super(type, price);
        this.maxToppings = maxToppings;
        this.includedToppings = includedToppings;
        toppings = "";
    }

    public void addTopping(String type) {
        if (toppings.split("/").length == maxToppings && !toppings.isBlank()) {
            System.out.println("Max toppings. Please remove a topping before adding another.");
        } else if (toppings.isBlank()) {
            toppings = type;
        } else {
            toppings = toppings + "/" + type;
        }
    }

    public void removeTopping(String type) {
        if (toppings.contains("/" + type)) {
            toppings = toppings.replaceAll("/" + type, "");
        } else {
            toppings = toppings.replaceAll(type, "");
        }
    }

    public double getTotalPrice() {
        double totalPrice = super.getPrice();
        String[] toppings = this.toppings.split("/");
        for (String topping : toppings) {
            if (!topping.isBlank() && !super.getType().contains(Main.DELUXE)) {
                totalPrice += toppingPrice(topping);
            }
        }
        return totalPrice;
    }

    public String printTicket() {

        StringBuilder withToppings = new StringBuilder(Main.BURGER_FORMAT.formatted(super.getType(), super.getPrice()));
        String[] toppings = this.toppings.split("/");
        for (String topping : toppings) {
            if (!topping.isBlank()) {
                String newLine;
                if (super.getType().contains(Main.DELUXE)) {
                    newLine = Main.ADD_ON_FORMAT.formatted(topping, 0.0);
                } else {
                    newLine = Main.ADD_ON_FORMAT.formatted(topping, toppingPrice(topping));
                }
                withToppings.append(newLine);
            }
        }
        return withToppings.toString();
    }

    public double toppingPrice(String type) {
        return switch(type) {
            case Main.EXTRA_CHEESE, Main.ADD_RING -> 0.5;
            case Main.ADD_EGG, Main.ADD_CHILE, Main.ADD_AVO -> 1;
            case Main.ADD_BACON -> 1.5;
            case Main.GLUTEN_FREE -> 2;
            case Main.EXTRA_PATTY -> 4;
            default -> 0;
        };
    }
}


