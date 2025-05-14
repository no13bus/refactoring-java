package movierental.strategy;
import movierental.MovieRental;

public class ChildrenMovieStrategy implements RentalStrategy {
    private static final double BASE_PRICE = 1.5;
    private static final double EXTRA_PRICE = 1.5;
    private static final int EXTRA_DAYS = 3;

    @Override
    public double calculateAmount(MovieRental rental) {
        double amount = BASE_PRICE;
        if (rental.getDays() > EXTRA_DAYS) {
            amount += (rental.getDays() - EXTRA_DAYS) * EXTRA_PRICE;
        }
        return amount;
    }

    @Override
    public int calculatePoints(MovieRental rental) {
        return 1;
    }
}