public class Main {
    public static void main(String[] args) {


        OrderHandler order = new OrderHandler();
        order.setSide("Side Salad");
        order.setDrink("Fountain", "Lg");

        order.viewTotal();

    }
}