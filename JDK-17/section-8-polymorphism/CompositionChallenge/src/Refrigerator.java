public class Refrigerator extends SmartAppliance {

    public void orderFood() {
        if (getHasWorkToDo()) {
            System.out.println("Fridge has ordered food");
            setHasWorkToDo(false);
        }
    }
}
