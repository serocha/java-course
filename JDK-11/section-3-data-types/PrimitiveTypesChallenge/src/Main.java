public class Main {

    public static void main(String[] args) {

        byte byteValue = 127;
        short shortValue = -20000;
        int intValue = 300000;
        int total = byteValue + shortValue + intValue;
        System.out.println("The sum is: " + total);

        // you don't have to cast within a long because an int will always fit into a long
        long longTotal = 50000L + 10L * (byteValue + shortValue + intValue);
        System.out.println("The long sum is: " + longTotal);

        // you have to cast to a short because the value will overflow
        short shortTotal = (short) (1000 + 10 * (byteValue + shortValue + intValue));
        System.out.println("The short sum is: " + shortTotal);
    }
}