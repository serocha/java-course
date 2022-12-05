public class Meal {

    private Burger burger;
    private Item side;
    private Item drink;

    public Meal() {
        this(Main.CHEESEBURGER, Main.FRIES, Main.FOUNTAIN);
    }

    public Meal (String burger, String side, String drink) {
        this.burger = burgerHandler(burger);
        this.side = itemHandler(side);
        this.drink = itemHandler(drink);
    }
    /*
    public Meal(Burger burger, Item side, Item drink) {
        this.burger = burger;
        this.side = side;
        this.drink = drink;
    }*/

    public void removeBurger() {
        burger = null;
    }

    public void removeSide() {
        side = null;
    }

    public void removeDrink() {
        drink = null;
    }

    public void addBurger(String type) {
        if (burger == null) {
            burger = burgerHandler(type);
        } else {
            System.out.println("Please remove the current burger first");
        }
    }

    public void addTopping(String type) {
        burger.addTopping(type);
    }

    public void removeTopping(String type) {
        burger.removeTopping(type);
    }

    public void addSide(String type) {
        addSide(type, Main.REGULAR);
    }

    public void addSide(String type, String size) {
        if (side == null) {
            side= itemHandler(type);
            if (side instanceof ModifiableItem) {
                side.setSize(size);
            }
        } else {
            System.out.println("Please remove the current side first");
        }
    }

    public void addDrink(String type) {
        addDrink(type, Main.REGULAR);
    }

    public void addDrink(String type, String size) {
        if (drink == null) {
            drink = itemHandler(type);
            if (drink instanceof ModifiableItem) {
                drink.setSize(size);
            }
        } else {
            System.out.println("Please remove the current drink first");
        }
    }

    public double getPrice() {
        double total = burger.getTotalPrice();
        if (burger.getType() != Main.DELUXE) {
            total += side.getPrice() + drink.getPrice();
        }
        return total;
    }

    public String printTicket() {
        return burger.printTicket() +
                (burger.getType() == Main.DELUXE ?
                        Main.DELUXE_FORMAT.formatted(side.getSize() + " " + side.getType()) : side.printTicket()) +
                (burger.getType() == Main.DELUXE ?
                        Main.DELUXE_FORMAT.formatted(drink.getSize() + " " + drink.getType()) : drink.printTicket()) +
                Main.TOTAL_FORMAT.formatted("TOTAL:", getPrice());
    }

    public boolean isReadyForCheckout() {
        if (burger == null) {
            System.out.println("Please choose a burger.");
            return false;
        } else if (side == null) {
            System.out.println("Please choose a side.");
            return false;
        } else if (drink == null) {
            System.out.println("Please choose a drink.");
            return false;
        }
        return true;
    }

    public Burger burgerHandler(String type) {
        return switch(type) {
            case Main.CHEESEBURGER -> new Burger(Main.CHEESEBURGER, 8, 3, "Cheese");
            case Main.DOUBLE_CHEESE -> new Burger(Main.DOUBLE_CHEESE, 11.5, 3, "Cheese/Extra Patty");
            case Main.SOUTHWEST -> new Burger(Main.SOUTHWEST, 9, 3, "Green Chile");
            case Main.CALI -> new Burger(Main.CALI, 9.5, 3, "Avocado/Bacon/Aioli");
            case Main.DELUXE -> new Burger(Main.DELUXE, 17.5, 5);
            default -> {
                System.out.println("Invalid burger type entered into createBurger()");
                yield null;
            }
        };
    }

    public Item itemHandler(String type) {
        return switch(type) {
            case Main.FRIES -> new ModifiableItem(Main.FRIES, 2, 1.75, 2.5);
            case Main.SWEET_POTATO -> new ModifiableItem(Main.SWEET_POTATO, 2.5,  2, 2.75);
            case Main.ONION_RINGS -> new ModifiableItem(Main.ONION_RINGS, 2.75, 2.25, 3);
            case Main.SIDE_SALAD -> new Item(Main.SIDE_SALAD, 3);

            case Main.FOUNTAIN -> new ModifiableItem(Main.FOUNTAIN, 1.5, 1, 1.75);
            case Main.TEA -> new ModifiableItem(Main.TEA, 1.25, 1, 1.5);
            case Main.SWEET_TEA -> new ModifiableItem(Main.SWEET_TEA, 1.25, 1, 1.5);
            case Main.COFFEE -> new ModifiableItem(Main.COFFEE, 2, 1.5, 2.25);
            case Main.MILKSHAKE -> new Item(Main.MILKSHAKE, 4);
            case Main.HORCHATA -> new Item(Main.HORCHATA, 3);
            default -> {
                System.out.println("Invalid Item type: ItemHandler.createItem()");
                yield null;
            }
        };
    }
}
