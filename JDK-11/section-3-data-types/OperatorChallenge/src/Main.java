public class Main {
    public static void main(String[] args) {

        double firstDouble = 20.00d;
        double secondDouble = 80.00d;
        double result = 100.00d * (firstDouble + secondDouble); // add, then multiply by 100
        result %= 40.00d; // modulus
        System.out.println("The remainder is " + result);
        boolean isResultZero = (result == 0) ? true : false;
        System.out.println("isResultZero evaluates to " + isZero);

        if (!isResultZero) {
            System.out.println("Got some remainder.");
        }
    }
}