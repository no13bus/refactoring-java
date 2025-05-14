package movierental.strategy;

import movierental.model.MovieRental;

public interface RentalStrategy {
    double calculateAmount(MovieRental rental);
    int calculatePoints(MovieRental rental);
}
