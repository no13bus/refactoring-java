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

    /**
     * Calculates the rental amount for this rental.
     * Uses an exhaustive switch expression to ensure all MovieType cases are
     * handled.
     * If a new MovieType is added, the compiler will enforce handling it here.
     *
     * @return the calculated rental amount
     */
    public double calculateAmount() {
        return switch (movie.getType()) {
            case REGULAR -> {
                // Regular movies: 2 for first 2 days, then 1.5 per extra day
                double amount = 2;
                if (days > 2)
                    amount += (days - 2) * 1.5;
                yield amount;
            }
            case NEW_RELEASE ->
                // New releases: 3 per day
                days * 3;
            case CHILDREN -> {
                // Children's movies: 1.5 for first 3 days, then 1.5 per extra day
                double amount = 1.5;
                if (days > 3)
                    amount += (days - 3) * 1.5;
                yield amount;
            }
        };
    }

    /**
     * Calculates the frequent renter points for this rental.
     * 
     * @return the frequent renter points earned for this rental
     */
    public int calculateFrequentEnterPoints() {
        int points = 1;
        if (movie.getType() == MovieType.NEW_RELEASE && days > 2) {
            points++;
        }
        return points;
    }
}
