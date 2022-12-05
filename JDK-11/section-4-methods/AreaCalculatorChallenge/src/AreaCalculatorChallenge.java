public class AreaCalculatorChallenge {
    private static final double PI = Math.PI; // just practice using constants
    public static void main(String[] args) {
        System.out.println("Area of a circle with r = 12 should be 452.39");
        System.out.println("Result: " + area(12));
        System.out.println("Area of a rectangle with l = 14 and w = 20 should be 280");
        System.out.println("Result: " + area(14, 20));
    }

    public static double area(double radius) {
        // area of a circle
        if (radius < 0) {
            return -1;
        }
        return PI*radius*radius;
    }

    public static double area(double length, double width) {
        // area of a rectangle
        if (length < 0 || width < 0) {
            return -1;
        }
        return length*width;
    }
}
