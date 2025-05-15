package movierental.strategy;

import movierental.model.MovieRental;

/**
 * Strategy for pricing and points calculation of newly released movies.
 */
public class NewReleaseStrategy implements RentalStrategy {
    /** Daily price for new release rentals. */
    private static final double PRICE_PER_DAY = 3.0;

    /** Minimum rental days required to earn bonus points. */
    private static final int BONUS_POINTS_THRESHOLD = 2;

    /**
     * {@inheritDoc}
     * 
     * @param rental The movie rental to calculate amount for
     * @return Amount calculated as daily rate multiplied by number of days
     */
    @Override
    public double calculateAmount(MovieRental rental) {
        return rental.getDays() * PRICE_PER_DAY;
    }

    /**
     * {@inheritDoc}
     * 
     * @param rental The movie rental to calculate points for
     * @return 2 points for rentals more than 2 days, otherwise 1 point
     */
    @Override
    public int calculatePoints(MovieRental rental) {
        return rental.getDays() > BONUS_POINTS_THRESHOLD ? 2 : 1;
    }
}
