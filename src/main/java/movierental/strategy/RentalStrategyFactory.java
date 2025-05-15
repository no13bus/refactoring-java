package movierental.strategy;

import movierental.model.MovieType;

/**
 * Factory class that creates appropriate rental strategy instances based on
 * movie type.
 * Implements the Factory Method pattern to encapsulate strategy object
 * creation.
 */
public class RentalStrategyFactory {
    /**
     * Creates and returns the appropriate rental strategy for the given movie type.
     *
     * @param type The movie type for which to create a strategy
     * @return The appropriate rental strategy implementation
     */
    public static RentalStrategy getStrategy(MovieType type) {
        return switch (type) {
            case REGULAR -> new RegularMovieStrategy();
            case NEW_RELEASE -> new NewReleaseStrategy();
            case CHILDREN -> new ChildrenMovieStrategy();
        };
    }
}