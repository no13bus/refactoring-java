package movierental.strategy;

import movierental.MovieRental;

public interface RentalStrategy {
    double calculateAmount(MovieRental rental);
    int calculatePoints(MovieRental rental);
}
