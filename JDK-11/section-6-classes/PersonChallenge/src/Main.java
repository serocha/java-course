public class Main {
    public static void main(String[] args) {
        Person tim = new Person();

        tim.setFirstName("tiM");
        tim.setLastName("bAker");
        System.out.println(tim.getFullName());

        tim.setFirstName("");
        System.out.println(tim.getFullName());
        tim.setLastName("");
        System.out.println(tim.getFullName());

        tim.setAge(12);
        System.out.println(tim.isTeen());
        tim.setAge(15);
        System.out.println(tim.isTeen());
        tim.setAge(101);
        System.out.println(tim.getAge());
        tim.setAge(100);
        System.out.println(tim.getAge());
    }
}