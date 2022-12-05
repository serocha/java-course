public class StringMethods {

    public static void main(String[] args) {

        String birthDate = "11/25/1982";
        int startingIndex = birthDate.indexOf("1982"); // finds start index of substring
        System.out.println("Starting index = " + startingIndex); // print index
        System.out.println("Birth year = " + birthDate.substring(startingIndex)); // substring at index

        birthDate = "25/11/1982"; // change format to showcase other methods, month is index 3 and 4
        System.out.println("Birth month = " + birthDate.substring(3,5)); // includes start index, excludes end index

        String newDate = String.join("/", "25", "11", "1982");
        // creates a string from elements separated by a specified delimiter (good for comma delimited strings)
        System.out.println("New date = " + newDate);

        newDate = "25";
        newDate.concat("/");
        newDate.concat("11");
        newDate.concat("/");
        newDate.concat("1982"); // same as String.join(delimiter, elements...) above

        newDate = "25" + "/" + "11" + "/" + "1982"; // same, still inefficient

        newDate = "25".concat("/").concat("11").concat("/").concat("1982");
        // see why .join is better, or the StringBuilder class

        System.out.println(newDate.replace('/', '-')); // simple replace character literals
        System.out.println(newDate.replace("2", "00")); // replace with string (multiple chars)

        System.out.println(newDate.replaceFirst("/", "-")); // note that these use regex, not char/string
        System.out.println(newDate.replaceAll("/", "---"));

        // repeat a string for a number of iterations
        System.out.println("ABC\n".repeat(3).indent(4)); // chain with added indent
        System.out.println("-".repeat(20));

        System.out.println("    ABC\n".repeat(3).indent(-2)); // chain with added indent
        System.out.println("-".repeat(20));
    }
}
