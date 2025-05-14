package movierental.strategy;

import movierental.model.MovieRental;

public class RegularMovieStrategy implements RentalStrategy {
    private static final double BASE_PRICE = 2.0;
    private static final double EXTRA_PRICE = 1.5;
    private static final int EXTRA_DAYS = 2;

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
