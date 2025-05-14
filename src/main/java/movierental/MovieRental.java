package movierental;

public class MovieRental {
    private Movie movie;
    private int days;

    public MovieRental(Movie movie, int days) {
        this.movie = movie;
        this.days = days;
    }

    public Movie getMovie() {
        return movie;
    }

    public int getDays() {
        return days;
    }
}
