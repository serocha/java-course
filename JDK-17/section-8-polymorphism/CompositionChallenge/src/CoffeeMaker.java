public class CoffeeMaker extends SmartAppliance {

    public void makeCoffee() {
        if (getHasWorkToDo()) {
            System.out.println("Coffee maker brewed coffee");
            setHasWorkToDo(false);
        }
    }

}
