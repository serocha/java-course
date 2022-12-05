public class SmartKitchen {

    private Refrigerator refrigerator;
    private DishWasher dishWasher;
    private CoffeeMaker coffeeMaker;

    public SmartKitchen(Refrigerator refrigerator, DishWasher dishWasher, CoffeeMaker coffeeMaker) {
        this.refrigerator = refrigerator;
        this.dishWasher = dishWasher;
        this.coffeeMaker = coffeeMaker;
    }

    public SmartKitchen() {
        // also a valid way of doing it since the appliances don't have params
        refrigerator = new Refrigerator();
        dishWasher = new DishWasher();
        coffeeMaker = new CoffeeMaker();
    }

    public void setKitchenState (boolean fridgeFlag, boolean dishesFlag, boolean coffeeFlag) {
        refrigerator.setHasWorkToDo(fridgeFlag);
        dishWasher.setHasWorkToDo(dishesFlag);
        coffeeMaker.setHasWorkToDo(coffeeFlag);
    }

    public void doKitchenWork() {
        addWater();
        pourMilk();
        loadDishwasher();
    }

    private void addWater() {
        coffeeMaker.makeCoffee();
    }

    private void pourMilk() {
        refrigerator.orderFood();
    }

    private void loadDishwasher() {
        dishWasher.doDishes();
    }
}
