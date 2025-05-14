package movierental.model;

public class Movie {
    private final String movieId;
    private final String title;
    private final MovieType type;

    public Movie(String movieId, String title, MovieType type) {
        this.movieId = movieId;
        this.title = title;
        this.type = type;
    }

    public String getMovieId() {
        return movieId;
    }

    public String getTitle() {
        return title;
    }

    public MovieType getType() {
        return type;
    }
}
