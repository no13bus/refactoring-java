package movierental.strategy;

import movierental.model.MovieRental;

/**
 * Strategy interface for different movie rental pricing and points calculation.
 */
public interface RentalStrategy {
    /**
     * Calculates rental amount based on movie type and rental duration.
     *
     * @param rental The movie rental to calculate amount for
     * @return The calculated rental amount
     */
    double calculateAmount(MovieRental rental);

    /**
     * Calculates loyalty points earned for a rental.
     *
     * @param rental The movie rental to calculate points for
     * @return The number of loyalty points earned
     */
    int calculatePoints(MovieRental rental);
}
