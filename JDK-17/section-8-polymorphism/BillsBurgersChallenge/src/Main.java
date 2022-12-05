public class Main {

    public static void main(String[] args) {

        Hamburger burger = new Hamburger("Cheeseburger", "Beef", 9, "Brioche");
        System.out.println(burger.itemizeHamburger());
        burger.addHamburgerAddition1("Cheese", 1);
        burger.addHamburgerAddition2("Bacon", 1);
        System.out.println(burger.itemizeHamburger());

        DeluxeBurger burger2 = new DeluxeBurger();
        burger2.addHamburgerAddition1("Cheese", 1);
        System.out.println(burger2.itemizeHamburger());

    }
}