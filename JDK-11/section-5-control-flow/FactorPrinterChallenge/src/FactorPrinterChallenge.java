public class FactorPrinterChallenge {
    public static void main(String[] args) {
        printFactors(15);
    }

    public static void printFactors(int n) {
        if (n < 1) {
            System.out.println("Invalid Value");
        }

        String factors = "";
        for (int i=1; i<=n; i++){
            if (n%i == 0) {
                factors += i + " "; // using what course has taught so far
            }
        }
        System.out.println(factors);
    }
}
