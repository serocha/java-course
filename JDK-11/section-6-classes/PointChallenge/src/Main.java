public class Main {
    public static void main(String[] args) {
        Point pointA = new Point(6, 5);
        Point pointB = new Point(3, 1);

        System.out.println(pointA.distance());
        System.out.println(pointA.distance(pointB));
        System.out.println(pointA.distance(2, 2));
        Point pointC = new Point();
        System.out.println(pointC.distance());
    }
}