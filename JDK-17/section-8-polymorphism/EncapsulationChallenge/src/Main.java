public class Main {

    public static void main(String[] args) {

        Printer printer = new Printer(false);
        printer.printPages(80);
        printer.printPages(21);
        printer.refillToner();
        printer.printPages(15);
        printer.getTonerLevel();
        printer.getPagesPrinted();

        printer = new Printer(true);
        printer.printPages(80);
        printer.printPages(21);
        printer.refillToner();
        printer.printPages(15);
        printer.getTonerLevel();
        printer.getPagesPrinted();
    }
}