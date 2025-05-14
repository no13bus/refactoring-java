package movierental.strategy;

import movierental.model.MovieType;

public class RentalStrategyFactory {
    public static RentalStrategy getStrategy(MovieType type) {
        return switch (type) {
            case REGULAR -> new RegularMovieStrategy();
            case NEW_RELEASE -> new NewReleaseStrategy();
            case CHILDREN -> new ChildrenMovieStrategy();
        };
    }
}