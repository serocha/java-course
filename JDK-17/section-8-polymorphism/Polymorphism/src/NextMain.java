public class NextMain {

    public static void main(String[] args) {
        // calling code with Movie type
        Movie movie = Movie.getMovie("A", "Jaws");
        movie.watchMovie();

        // Adventure type returns compiler error unless you cast to type (Adventure can't handle all Movie subclasses)
        Adventure jaws = (Adventure) Movie.getMovie("A", "Jaws");
        movie.watchMovie();

        Object comedy = Movie.getMovie("C", "Airplane");
        // Movie comedyMovie = (Comedy) comedy -> won't work
        Comedy comedyMovie = (Comedy) comedy;  // casting must be specific
        comedyMovie.watchComedy();

        // var is a contextual keyword that takes advantage of Local Variable Type Inference
        var airplane = Movie.getMovie("C", "Airplane");
        airplane.watchMovie(); // note Java expects type Movie, not Comedy, because of the signature

        var plane = new Comedy("Airplane");
        plane.watchComedy(); // the compiler can see that it's a Comedy class
        System.out.println("***************************");

        // testing runtime type
        Object unknownObject = Movie.getMovie("S", "Alien");
        if (unknownObject.getClass().getSimpleName() == "Comedy") {
            // getClass() with methods
            Comedy c = (Comedy) unknownObject;
            c.watchComedy();
        } else if (unknownObject instanceof Adventure) {
            // instanceof condition -> cast to type without needing local var
            ((Adventure) unknownObject).watchAdventure();
        } else if (unknownObject instanceof ScienceFiction syfy) {
            // instanceof -> auto assign to binding variable using pattern matching
            syfy.watchScienceFiction();
        }
    }
}
