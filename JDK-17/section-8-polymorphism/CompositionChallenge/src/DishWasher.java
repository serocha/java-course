public class DishWasher extends SmartAppliance {

    public void doDishes() {
        if (getHasWorkToDo()) {
            System.out.println("Dishwasher washed the dishes");
            setHasWorkToDo(false);
        }
    }
}
