package movierental.strategy;

import movierental.model.MovieRental;

/**
 * Strategy for regular movies pricing and points calculation.
 */
public class RegularMovieStrategy implements RentalStrategy {
    /** Base price for the first period. */
    private static final double BASE_PRICE = 2.0;

    /** Price for each additional day beyond the standard period. */
    private static final double EXTRA_PRICE = 1.5;

    /** Number of days covered by the base price. */
    private static final int EXTRA_DAYS = 2;

    /**
     * {@inheritDoc}
     * 
     * @param rental The movie rental to calculate amount for
     * @return Base price for the first period plus extra charges for additional
     *         days
     */
    @Override
    public double calculateAmount(MovieRental rental) {
        double amount = BASE_PRICE;
        if (rental.getDays() > EXTRA_DAYS) {
            amount += (rental.getDays() - EXTRA_DAYS) * EXTRA_PRICE;
        }
        return amount;
    }

    /**
     * {@inheritDoc}
     * 
     * @param rental The movie rental to calculate points for
     * @return Always returns 1 point for regular movie rentals
     */
    @Override
    public int calculatePoints(MovieRental rental) {
        return 1;
    }
}
