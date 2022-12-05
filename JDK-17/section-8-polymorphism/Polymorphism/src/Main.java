import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        /*
        // call a factory method from the base class
        Movie theMovie = Movie.getMovie("Thriller", "Fight Club");
        theMovie.watchMovie(); // expect Movie instance

        Movie adventureMovie = Movie.getMovie("Adventure", "Treasure Planet");
        adventureMovie.watchMovie();

        Movie comedyMovie = Movie.getMovie("Comedy", "Dumb & Dumber");
        comedyMovie.watchMovie();

        Movie sfMovie = Movie.getMovie("Science Fiction", "Star Wars");
        sfMovie.watchMovie();*/

        // the object is different at runtime than the type declared in the code
        // Java determines which method to use on the runtime instance, not at compile time

        Scanner s = new Scanner(System.in);

        while (true) {
            System.out.print("Enter Movie Genre (A for Adventure, C for Comedy," +
                    "S for Sci-Fi, or Q to quit): ");
            String type = s.nextLine(); // take next input
            if ("Qq".contains(type)) {
                s.close();
                break; // check if Q or q matches user input (I like the logic used)
            }

            System.out.print("Enter Movie Title: ");
            String title = s.nextLine();
            Movie movie = Movie.getMovie(type, title);
            movie.watchMovie();

        }
    }
}