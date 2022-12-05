public class SideItemHandler {

    // could make some price variables to make it easier to change prices
        public Item getSide(String type) {
        return switch (type.toUpperCase()) {
            case "FRIES" -> new ModifiableItem("Fries", 2.5, 1.5, 3);
            case "SWEET POTATO FRIES" -> new ModifiableItem("Sweet Potato Fries", 2.25, 1.75, 3.75);
            case "ONION RINGS" -> new ModifiableItem("Onion Rings", 3, 2, 3.5);
            case "SIDE SALAD" -> new Item("Side Salad", 3);
            default -> {
                System.out.println("Invalid value in SideItemHandler.getSide()");
                yield null;
            }
        };
    }
}
