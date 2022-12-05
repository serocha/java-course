public class Printer {

    private int tonerLevel; // percentage of ink left
    private int pagesPrinted;
    private boolean isDuplex;

    public Printer(boolean isDuplex) {
        this(100, 0, isDuplex);
    }

    public Printer(int tonerLevel, int pagesPrinted, boolean isDuplex) {
        this.tonerLevel = tonerValidator(tonerLevel);
        this.pagesPrinted = pagesPrinted;
        this.isDuplex = isDuplex;
    }

    public void getTonerLevel() {
        System.out.println(tonerLevel + "% ink remaining");
    }

    public void getPagesPrinted() {
        System.out.println(pagesPrinted + " total pages printed");
    }

    public void refillToner() {
        tonerLevel = 100;
    }

    /* // method to fulfill requirement, but I think it's a strange way to handle it
    * public int addToner(int tonerAmount) {
    *   if ( (tonerLevel + tonerAmount) < 0 || (tonerLevel + tonerAmount) > 100) {
    *       return -1;
    *   }
    *   tonerLevel += tonerAmount;
    *   return tonerLevel;
    */

    private void useToner(int tonerAmount) {
        tonerLevel -= tonerValidator(tonerAmount);
    }

    public void printPages(int pages) {
        // little messy with the isDuplex calculations, possibly worth revisit
        if (pages < 1) {
            System.out.println("No pages printed");
            return;
        }
        int jobPages = duplexPages(pages);
        boolean isPartialJob = false;

        if (tonerLevel < pages) {
            System.out.print("Not enough ink to finish order, ");
            jobPages = duplexPages(tonerLevel);
            isPartialJob = true;
        }
        // assume each page takes 1% ink (0.25 - 0.5 would be more realistic)
        useToner(pages);

        System.out.println(jobPages + (isDuplex ? " duplex" : "") +
                " pages printed" + (isPartialJob ? (" out of " +
                duplexPages(pages) + " total pages") : ""));
        pagesPrinted += jobPages;
    }

    private int duplexPages(int pages) {
        return isDuplex ? (pages/2) + (pages%2) : pages;
    }

    private int tonerValidator(int value) {
        // alternative would be to return an error (-1) for fail states, then could use ternary operator
        if (value > 100) {
            return 100;
        } else if (value < 0) {
            return 0;
        } else {
            return value;
        }
    }
}
