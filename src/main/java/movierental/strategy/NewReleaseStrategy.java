package movierental.strategy;
import movierental.model.MovieRental;

public class NewReleaseStrategy implements RentalStrategy {
    private static final double PRICE_PER_DAY = 3.0;

    @Override
    public double calculateAmount(MovieRental rental) {
        return rental.getDays() * PRICE_PER_DAY;
    }

    @Override
    public int calculatePoints(MovieRental rental) {
        return rental.getDays() > 2 ? 2 : 1;
    }
}
