public class DiagonalStarChallenge {
    public static final String STAR = "*";
    public static void main(String[] args) {
        printSquareStar();
    }
    // prints asterisks these three rules:
    // if the position is at the start or end of a row/column
    // when the row position equals the column position
    // when the column number equals rowCount - currentRow + 1
    public static void printSquareStar(int number) {
        if (number < 5) {
            System.out.println("Invalid Value");
        }
        for (int row=1; row<=number; row++) {
            for (int column=1; column<=number; column++) {
                // rule 1
                if (row == 1 || row == number || column == 1 || column == number ||
                    // rules 2 & 3
                    row == column || column == (number - row + 1)) {
                    System.out.print(STAR);
                } else {
                    System.out.print(" ");
                }
            }
            System.out.print("\n"); // alternative System.out.println();
        }
    }
}
