public class Main {

    public static void main(String[] args) {
        //byte
        //short
        //int
        //long
        //float
        //double
        //char
        //boolean
        String myString = "This is a string";
        System.out.println("myString = " + myString);
        myString = myString + ", and this is more."; //append to the end
        System.out.println("myString = " + myString);
        myString = myString + " \u00A9 2022";
        System.out.println("myString = " + myString);

        String numberString = "250.05"; //obviously a string is not a number
        numberString = numberString + "49.95";
        System.out.println("numberString = " + numberString);
        String lastString = "10";
        int myInt = 50;
        lastString = lastString + myInt;
        System.out.println("lastString = " + lastString);
        boolean myBool = false;
        lastString = lastString + myBool;
        System.out.println("lastString = " + lastString);
        // a quick final note: appending to a string in inefficient
        // there's a class called StringBuffer for that, covered later on
    }
}