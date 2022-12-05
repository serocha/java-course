public class Main {
    public static void main(String[] args) {
        ComplexNumber first = new ComplexNumber(1.0, 1.0);
        ComplexNumber second = new ComplexNumber(2.5, -1.5);

        first.add(1,1);
        System.out.println("first.real= " + first.getReal());
        System.out.println("first.imaginary= " + first.getImaginary());

        first.subtract(second);
        System.out.println("first.real= " + first.getReal());
        System.out.println("first.imaginary= " + first.getImaginary());

        second.subtract(first);
        System.out.println("second.real= " + second.getReal());
        System.out.println("second.imaginary= " + second.getImaginary());
    }
}