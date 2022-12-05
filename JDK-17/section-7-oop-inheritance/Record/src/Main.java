public class Main {
    public static void main(String[] args) {
        // create some Student data using a Record
        for (int i=1; i<=5; i++) {
            UniversityStudent s = new UniversityStudent("A92300" + i,
                    switch (i) {
                        case 1 -> "Mary";
                        case 2 -> "James";
                        case 3 -> "Bill";
                        case 4 -> "Alice";
                        case 5 -> "Vanessa";
                        default -> "Jane Doe"; // required for switch expression
                    },
                    "05/11/1985",
                    "Java Masterclass");
            System.out.println(s); // note that you don't have to call the .toString() method. It's implicit
        }

        Student pojoStudent = new Student("A923006", "Tyler",
                "09/13/1990", "Basket Weaving");
        UniversityStudent recordStudent = new UniversityStudent("A923007", "Margaret",
                "11/01/1988", "Anthropology");

        System.out.println(pojoStudent);    // generated toString() is slightly different format
        System.out.println(recordStudent);  // record

        System.out.println(pojoStudent.getName() + " is taking "    // generated getters/setters auto prefix get/set
                + pojoStudent.getClassList());
        System.out.println(recordStudent.name() + " is taking "     // records drop the prefix, instead using attribute()
                + recordStudent.classList());

        pojoStudent.setClassList(pojoStudent.getClassList() + ", Psychology");  // no issues
        // recordStudent has no setters by design. The record is meant to be immutable.
    }
}