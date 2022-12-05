import java.util.Scanner;

public class Order {

    private Meal meal;

    public Order() {
        this.meal = new Meal();
    }

    public Order(String burger, String side, String drink) {
        this.meal = new Meal(burger, side, drink);
    }

    public void addBurger(String type) {
        meal.addBurger(type);
    }

    public void addTopping(String type) {
        meal.addTopping(type);
    }

    public void addSide(String type) {
        meal.addSide(type);
    }

    public void addSide(String type, String size) {
        meal.addSide(type, size);
    }

    public void addDrink(String type) {
        meal.removeDrink();
    }

    public void addDrink(String type, String size) {
        meal.addDrink(type, size);
    }

    public void removeBurger() {
        meal.removeBurger();
    }

    public void removeTopping(String type) {
        meal.removeTopping(type);
    }

    public void removeSide() {
        meal.removeSide();
    }

    public void removeDrink() {
        meal.removeDrink();
    }

    public void printTicket() {
        System.out.println(meal.printTicket());
    }

    public void cancelOrder() {
        Scanner confirmation = new Scanner(System.in);
        System.out.println();
        System.out.println("Are you sure you want to cancel the order? ");
        String input = confirmation.nextLine();
        if (input.toUpperCase().contains("Y")) {
            System.out.print("Order cancelled.");
            System.out.println();
            clearOrder();
        }
        confirmation.reset();
    }

    public void checkout() {
        if (meal.isReadyForCheckout()) {
            Scanner confirmation = new Scanner(System.in);
            printTicket();
            System.out.println("Confirm order? ");
            if (confirmation.nextLine().toUpperCase().contains("Y")) {
                System.out.println("Order placed. Thank you!");
                System.out.println();
                clearOrder();
            }
            confirmation.reset();
        }
    }

    private void clearOrder() {
        meal.removeBurger();
        meal.removeSide();
        meal.removeDrink();
    }
}
