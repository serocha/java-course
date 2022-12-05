public class Movie {

    private String title;

    public Movie(String title) {
        this.title = title;
    }

    public void watchMovie() {
        // get class type information about the runtime instance (get name of class)
        String instanceType = this.getClass().getSimpleName();
        System.out.println(title + " is a " + instanceType + " film");
    }

    public static Movie getMovie(String type, String title) {
        return switch(type.toUpperCase().charAt(0)) {
            default -> new Movie(title);
            case 'A' -> new Adventure(title);
            case 'C' -> new Comedy(title);
            case 'S' -> new ScienceFiction(title);
        };
    }
}

class Adventure extends Movie {

    public Adventure(String title) {
        super(title);
    }

    @Override
    public void watchMovie() {
        super.watchMovie();
        // add synopsis
        System.out.printf(".. %s%n".repeat(3),
                "Pleasant Scene",
                "Scary Music",
                "Something Bad Happens"); // each substring will get its own line
    }

    public void watchAdventure() {
        System.out.println("Watching an Adventure!");
    }
}

class Comedy extends Movie {

    public Comedy(String title) {
        super(title);
    }

    @Override
    public void watchMovie() {
        super.watchMovie();
        // add synopsis
        System.out.printf(".. %s%n".repeat(3),
                "Something Funny Happens",
                "Hilarious Misunderstanding",
                "Slapstick Happy Ending"); // each substring will get its own line
    }

    public void watchComedy() {
        System.out.println("Watching a Comedy!");
    }
}

class ScienceFiction extends Movie {

    public ScienceFiction(String title) {
        super(title);
    }

    @Override
    public void watchMovie() {
        super.watchMovie();
        // add synopsis
        System.out.printf(".. %s%n".repeat(3),
                "Inciting Incident",
                "Hero Faces Setback",
                "Epic Space Battle"); // each substring will get its own line
    }

    public void watchScienceFiction() {
        System.out.println("Watching a Science Fiction Thriller!");
    }
}