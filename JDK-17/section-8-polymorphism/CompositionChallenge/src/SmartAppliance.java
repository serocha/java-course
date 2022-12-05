public class SmartAppliance {

    private boolean hasWorkToDo;

    public SmartAppliance() {
        this(false);
    }

    public SmartAppliance(boolean hasWorkToDo) {
        this.hasWorkToDo = hasWorkToDo;
    }

    public boolean getHasWorkToDo() {
        return hasWorkToDo;
    }

    public void setHasWorkToDo(boolean hasWorkToDo) {
        this.hasWorkToDo = hasWorkToDo;
    }
}
