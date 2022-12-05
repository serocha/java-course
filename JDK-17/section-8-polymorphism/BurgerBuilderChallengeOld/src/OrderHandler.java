public class OrderHandler {

    private Item side;
    private Item drink;

    private final AddOnHandler addOnHandler = new AddOnHandler();
    private final DrinkItemHandler drinkHandler = new DrinkItemHandler();
    private final SideItemHandler sideHandler = new SideItemHandler();

    public OrderHandler() {
        this.side = sideHandler.getSide("Fries");
        this.drink = drinkHandler.getDrink("Fountain Drink");
    }

    public Item getSide() {
        return side;
    }

    public Item getDrink() {
        return drink;
    }

    public void setSide(String type) {
        side = sideHandler.getSide(type);
    }

    public void setSide(String type, String size) {
        side = sideHandler.getSide(type).;
    }

    public void setDrink(String type) {
        drink = drinkHandler.getDrink(type);
    }

    public void setDrink(String type, String size) {
        drink = drinkHandler.getDrink(type, size);
    }

    public void viewTotal() {
        if (side instanceof ModifiableItem) {
            System.out.printf("""
                    %-3s%-30s%.2f
                    """, side.getSize(), side.getType(), side.getPrice());
        } else {
            System.out.printf("""
                    %-33s%.2f
                    """, side.getType(), side.getPrice());
        }

        if (drink instanceof ModifiableItem) {
            System.out.printf("""
                    %-3s%-30s%.2f
                    """, drink.getSize(), drink.getType(), drink.getPrice());
        } else {
            System.out.printf("""
                    %-33s%.2f
                    """, drink.getType(), drink.getPrice());
        }
    }
}
