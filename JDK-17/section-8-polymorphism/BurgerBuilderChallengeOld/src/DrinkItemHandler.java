public class DrinkItemHandler {

    public Item getDrink(String type) {
        return switch (type.toUpperCase()) {
            case "LEMONADE SLUSH" -> new ModifiableItem("Lemonade Slush", 2.5, 1.75, 3);
            case "MILKSHAKE" -> new ModifiableItem("Milkshake", 3.5, 3, 4);
            case "HORCHATA" -> new Item("Horchata", 4);
            case "COFFEE" -> new ModifiableItem("Coffee", 1.75, 1.25, 2.25);
            default -> new ModifiableItem("Fountain Drink", 1.5, 1.0, 2);
        };
    }

    public Item getDrink(String type, String size) {
        return switch (type.toUpperCase()) {
            case "LEMONADE SLUSH" -> new ModifiableItem("Lemonade Slush", 2.5, size, 1.75, 3);
            case "MILKSHAKE" -> new ModifiableItem("Milkshake", 3.5, size, 3, 4);
            case "COFFEE" -> new ModifiableItem("Coffee", 1.75, size, 1.25, 2.25);
            default -> new ModifiableItem("Fountain Drink", 1.5, size, 1.0, 2);
        };
    }
}
