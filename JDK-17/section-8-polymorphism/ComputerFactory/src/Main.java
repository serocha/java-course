public class Main {
    public static void main(String[] args) {

        ComputerCase theCase = new ComputerCase("2208", "Dell", "240W");
        Monitor theMonitor = new Monitor("27in Beast", "Acer",
                120, 27, "2540 x 1440");
        Motherboard theMotherboard = new Motherboard("B-550F", "Asus",
                4, 6, "v2.44");

        PersonalComputer thePC = new PersonalComputer("2208", "Dell",
                theMonitor, theMotherboard, theCase);

        /*thePC.getComputerCase().pressPowerButton(); //retrieve component to call method from
        thePC.getMonitor().drawPixel(40, 30, "blue");
        thePC.getMotherboard().loadProgram("Window OS");*/

        thePC.power(); // didn't have to know anything about components to perform method

    }
}