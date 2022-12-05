public class Main extends Object {
    public static void main(String[] args) {
        Student max = new Student("Max", 16);
        System.out.println(max.toString()); // overridden Object.toString();
        System.out.println(max); // same result because toString() is implicit

        PrimaryStudent timmy = new PrimaryStudent("Timmy", 8, "John Rambo");
        System.out.println(timmy);

        UniversityStudent jenna = new UniversityStudent("Jenna", 20, "Geology");
        System.out.println(jenna);
    }
}
// note that only 1 class in a Java source file can be public
class Student {
    private String name;
    private int age;

    Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        // return super.toString();     this is the implicit call from Object super
        return name + " is " + age;
    }
}

class PrimaryStudent extends Student {
    private String parentName;

    PrimaryStudent(String name, int age, String parentName) {
        super(name, age); // call to Student constructor
        this.parentName = parentName;
    }

    @Override
    public String toString() {
        return super.toString() + ". Child of " + parentName; // call to Student super
    }
}

class UniversityStudent extends Student {
    private String major;

    UniversityStudent(String name, int age, String major) {
        super(name, age);
        this.major = major;
    }

    @Override
    public String toString() {
        return super.toString() + " and is majoring in " + major;
    }
}