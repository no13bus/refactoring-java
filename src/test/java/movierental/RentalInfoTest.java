package movierental;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class RentalInfoTest {

    @Test
    void shouldReturnExpectedStatementForRegularAndRegularMovies() {
        Movie youveGotMail = new Movie("id_ygm", "You've Got Mail", MovieType.REGULAR);
        Movie matrix = new Movie("id_matrix", "Matrix", MovieType.REGULAR);
        String expected = """
                Rental Record for C. U. Stomer
                	You've Got Mail	3.5
                	Matrix	2.0
                Amount owed is 5.5
                You earned 2 frequent points
                """;
        String result = new RentalInfo().statement(
                new Customer(
                        "C. U. Stomer",
                        Arrays.asList(
                                new MovieRental(youveGotMail, 3),
                                new MovieRental(matrix, 1))));
        assertEquals(expected, result);
    }

    @Test
    void shouldReturnStatementForRegularMovieOneTwoThreeDays() {
        Movie youveGotMail = new Movie("id_ygm", "You've Got Mail", MovieType.REGULAR);
        String regularOneDayExpected = """
                Rental Record for User
                	You've Got Mail	2.0
                Amount owed is 2.0
                You earned 1 frequent points
                """;
        String regularOneDayResult = new RentalInfo().statement(
                new Customer("User", Arrays.asList(new MovieRental(youveGotMail, 1))));
        assertEquals(regularOneDayExpected, regularOneDayResult);

        String regularTwoDaysExpected = """
                Rental Record for User
                	You've Got Mail	2.0
                Amount owed is 2.0
                You earned 1 frequent points
                """;
        String regularTwoDaysResult = new RentalInfo().statement(
                new Customer("User", Arrays.asList(new MovieRental(youveGotMail, 2))));
        assertEquals(regularTwoDaysExpected, regularTwoDaysResult);

        String regularThreeDaysExpected = """
                Rental Record for User
                	You've Got Mail	3.5
                Amount owed is 3.5
                You earned 1 frequent points
                """;
        String regularThreeDaysResult = new RentalInfo().statement(
                new Customer("User", Arrays.asList(new MovieRental(youveGotMail, 3))));
        assertEquals(regularThreeDaysExpected, regularThreeDaysResult);
    }

    @Test
    void shouldReturnStatementForNewReleaseMovieOneAndThreeDays() {
        Movie fastAndFuriousX = new Movie("id_ffx", "Fast & Furious X", MovieType.NEW_RELEASE);
        String newReleaseOneDayExpected = """
                Rental Record for User
                	Fast & Furious X	3.0
                Amount owed is 3.0
                You earned 1 frequent points
                """;
        String newReleaseOneDayResult = new RentalInfo().statement(
                new Customer("User", Arrays.asList(new MovieRental(fastAndFuriousX, 1))));
        assertEquals(newReleaseOneDayExpected, newReleaseOneDayResult);

        String newReleaseThreeDaysExpected = """
                Rental Record for User
                	Fast & Furious X	9.0
                Amount owed is 9.0
                You earned 2 frequent points
                """;
        String newReleaseThreeDaysResult = new RentalInfo().statement(
                new Customer("User", Arrays.asList(new MovieRental(fastAndFuriousX, 3))));
        assertEquals(newReleaseThreeDaysExpected, newReleaseThreeDaysResult);
    }

    @Test
    void shouldReturnStatementForChildrensMovieOneThreeFourDays() {
        Movie cars = new Movie("id_cars", "Cars", MovieType.CHILDRENS);
        String childrensOneDayExpected = """
                Rental Record for User
                	Cars	1.5
                Amount owed is 1.5
                You earned 1 frequent points
                """;
        String childrensOneDayResult = new RentalInfo().statement(
                new Customer("User", Arrays.asList(new MovieRental(cars, 1))));
        assertEquals(childrensOneDayExpected, childrensOneDayResult);

        String childrensThreeDaysExpected = """
                Rental Record for User
                	Cars	1.5
                Amount owed is 1.5
                You earned 1 frequent points
                """;
        String childrensThreeDaysResult = new RentalInfo().statement(
                new Customer("User", Arrays.asList(new MovieRental(cars, 3))));
        assertEquals(childrensThreeDaysExpected, childrensThreeDaysResult);

        String childrensFourDaysExpected = """
                Rental Record for User
                	Cars	3.0
                Amount owed is 3.0
                You earned 1 frequent points
                """;
        String childrensFourDaysResult = new RentalInfo().statement(
                new Customer("User", Arrays.asList(new MovieRental(cars, 4))));
        assertEquals(childrensFourDaysExpected, childrensFourDaysResult);
    }

    @Test
    void shouldReturnStatementForMixedMovieTypes() {
        Movie youveGotMail = new Movie("id_ygm", "You've Got Mail", MovieType.REGULAR);
        Movie fastAndFuriousX = new Movie("id_ffx", "Fast & Furious X", MovieType.NEW_RELEASE);
        Movie cars = new Movie("id_cars", "Cars", MovieType.CHILDRENS);
        String mixedTypesExpected = """
                Rental Record for User
                	You've Got Mail	2.0
                	Fast & Furious X	6.0
                	Cars	1.5
                Amount owed is 9.5
                You earned 3 frequent points
                """;
        String mixedTypesResult = new RentalInfo().statement(
                new Customer("User", Arrays.asList(
                        new MovieRental(youveGotMail, 2),
                        new MovieRental(fastAndFuriousX, 2),
                        new MovieRental(cars, 3))));
        assertEquals(mixedTypesExpected, mixedTypesResult);
    }

    @Test
    void shouldReturnStatementForEmptyRentalList() {
        String emptyRentalsExpected = """
                Rental Record for User
                Amount owed is 0.0
                You earned 0 frequent points
                """;
        String emptyRentalsResult = new RentalInfo().statement(
                new Customer("User", Arrays.asList()));
        assertEquals(emptyRentalsExpected, emptyRentalsResult);
    }

    @Test
    void shouldReturnStatementForZeroAndNegativeDays() {
        Movie youveGotMail = new Movie("id_ygm", "You've Got Mail", MovieType.REGULAR);
        String zeroDaysExpected = """
                Rental Record for User
                	You've Got Mail	2.0
                Amount owed is 2.0
                You earned 1 frequent points
                """;
        String zeroDaysResult = new RentalInfo().statement(
                new Customer("User", Arrays.asList(new MovieRental(youveGotMail, 0))));
        assertEquals(zeroDaysExpected, zeroDaysResult);

        String negativeDaysExpected = """
                Rental Record for User
                	You've Got Mail	2.0
                Amount owed is 2.0
                You earned 1 frequent points
                """;
        String negativeDaysResult = new RentalInfo().statement(
                new Customer("User", Arrays.asList(new MovieRental(youveGotMail, -5))));
        assertEquals(negativeDaysExpected, negativeDaysResult);
    }
}