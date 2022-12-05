public class Main {

    public static void main(String[] args) {

        Order order = new Order(CHEESEBURGER, FRIES, HORCHATA);
        order.addTopping(ADD_BACON);
        order.addTopping(ADD_AVO);
        order.addTopping("ADD TOMATO");
        order.checkout();

        order.addBurger(DELUXE);
        order.addSide(ONION_RINGS, REGULAR);
        order.addDrink(SWEET_TEA, LARGE);
        order.addTopping(EXTRA_CHEESE);
        order.addTopping(ADD_BACON);
        order.addTopping(ADD_EGG);
        order.addTopping(ADD_CHILE);
        order.addTopping(ADD_RING);
        order.removeTopping(EXTRA_CHEESE);
        order.addTopping(ADD_AVO);
        order.checkout();

        order = new Order(SOUTHWEST, FRIES, FOUNTAIN);
        order.addTopping(EXTRA_PATTY);
        order.checkout();
    }

    public static final String FRIES = "Fries";
    public static final String SWEET_POTATO = "Sweet Potato Fries";
    public static final String ONION_RINGS = "Onion Rings";
    public static final String SIDE_SALAD = "Side Salad";

    public static final String FOUNTAIN = "Fountain Drink";
    public static final String TEA = "Unsweetened Tea";
    public static final String SWEET_TEA = "Sweet Tea";
    public static final String COFFEE = "Coffee";
    public static final String MILKSHAKE = "Milkshake";
    public static final String HORCHATA = "Horchata";

    public static final String CHEESEBURGER = "Cheeseburger";
    public static final String DOUBLE_CHEESE = "Double Cheeseburger";
    public static final String SOUTHWEST = "Southwest Burger";
    public static final String CALI = "Cali Burger";
    public static final String DELUXE = "Deluxe Burger";

    public static final String EXTRA_CHEESE = "EXTRA CHEESE";
    public static final String ADD_CHILE = "ADD CHILE";
    public static final String ADD_EGG = "ADD EGG";
    public static final String ADD_AVO = "ADD AVOCADO";
    public static final String ADD_BACON = "ADD BACON";
    public static final String ADD_RING = "ADD ONION RING";
    public static final String GLUTEN_FREE = "GLUTEN FREE";
    public static final String EXTRA_PATTY = "EXTRA PATTY";

    public static final String SMALL = "Sm ";
    public static final String REGULAR = "Reg";
    public static final String LARGE = "Lg ";

    public static final String BURGER_FORMAT = "%-30s%5.2f%n";
    public static final String DELUXE_FORMAT = "%-30s%n";
    public static final String ITEM_FORMAT = "%-29s%5.2f%n";
    public static final String MODIFIED_FORMAT = "%-25s%5.2f%n";
    public static final String ADD_ON_FORMAT = "\t%-25s%5.2f%n";
    public static final String TOTAL_FORMAT = "%n%20s%15.2f%n";
}