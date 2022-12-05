public class Burger extends Item {

    private String[] toppings = new String[3];

    public Burger(String type, double price) {
        super(type, price);
    }

    public String[] getToppings() {
        return toppings;
    }

    public void addToppings(String topping) {
        for (int i = 0; i < toppings.length; i++) {
            if (toppings[i].isEmpty() || toppings[i].isBlank()) {
                toppings[i] = topping;
                break;
            }
        }

    }
}
