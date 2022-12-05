public class Main {

    public static void main(String[] args) {

        Refrigerator yourFridge = new Refrigerator();
        DishWasher yourDishWasher = new DishWasher();
        CoffeeMaker yourCoffeeMaker = new CoffeeMaker();
        SmartKitchen kitchen = new SmartKitchen(yourFridge, yourDishWasher, yourCoffeeMaker);

        kitchen.setKitchenState(false, true, true);
        kitchen.doKitchenWork();
        System.out.println();

        kitchen = new SmartKitchen();
        kitchen.setKitchenState(true, true, true);
        kitchen.doKitchenWork();
    }
}