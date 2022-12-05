public class AddOnHandler {
    // could be better handled using arrays maybe records
    private final Item extraCheese = new Item("Extra Cheese", 1);
    private final Item extraPatty = new Item("Extra Patty", 4);
    private final Item bacon = new Item("Add Bacon", 1.5);
    private final Item onionRing = new Item("Add Onion Ring", 0.75);
    private final Item egg = new Item("Add Egg", 1.25);
    private final Item bbq = new Item("Add BBQ Sauce", 0);
    private final Item chile = new Item("Add Chile", 1);

    public Item getTopping(String type) {
        return switch (type.toUpperCase()) {
            case "EXTRA CHEESE" -> extraCheese;
            case "EXTRA PATTY" -> extraPatty;
            case "BACON" -> bacon;
            case "ONION RING" -> onionRing;
            case "EGG" -> egg;
            case "BBQ" -> bbq;
            case "CHILE" -> chile;
            default -> {
                System.out.println("Invalid topping.");
                yield null;
            }
        };
    }
}
