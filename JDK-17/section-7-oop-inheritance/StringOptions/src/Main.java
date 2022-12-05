public class Main {

    public static void main(String[] args) {

        String helloString = "Hello" + " World";
        helloString.concat(" and Goodbye");
        // the new string from concat isn't reassigned to a variable, and strings themselves are immutable

        StringBuilder helloBuilder = new StringBuilder("Hello" + " World");
        helloBuilder.append(" and Goodbye"); // the value has changed, but the object reference has not

        printInfo(helloString);
        printInfo(helloBuilder);

        StringBuilder emptyStart = new StringBuilder(); // default capacity of 16 char, must reallocate as it grows
        emptyStart.append("a".repeat(57));
        StringBuilder emptyStart32 = new StringBuilder(32); // starting capacity at 32 char
        emptyStart32.append("b".repeat(17));

        printInfo(emptyStart);
        printInfo(emptyStart32);

        StringBuilder builderPlus = new StringBuilder("Hello" + " World");
        builderPlus.append(" and Goodbye");

        builderPlus.deleteCharAt(16).insert(16, 'g'); // chaining
        System.out.println(builderPlus);
        builderPlus.replace(16, 17, "G"); // end index is exclusive; if start==end -> nothing removed, only added
        System.out.println(builderPlus);
        builderPlus.reverse().setLength(7); // setLength can be used to truncate
        System.out.println(builderPlus);
    }

    public static void printInfo(String string) {
        System.out.println("String = " + string);
        System.out.println("length = " + string.length());
    }

    public static void printInfo(StringBuilder stringBuilder) {
        System.out.println("String = " + stringBuilder);
        System.out.println("length = " + stringBuilder.length());
        System.out.println("capacity = " + stringBuilder.capacity());
    }
}