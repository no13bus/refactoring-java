package movierental;

import java.util.HashMap;

public class RentalInfo {

  public String statement(Customer customer) {
    HashMap<String, Movie> movies = new HashMap<>();
    movies.put("F001", new Movie("You've Got Mail", MovieType.REGULAR));
    movies.put("F002", new Movie("Matrix", MovieType.REGULAR));
    movies.put("F003", new Movie("Cars", MovieType.CHILDRENS));
    movies.put("F004", new Movie("Fast & Furious X", MovieType.NEW_RELEASE));

    double totalAmount = 0;
    int frequentEnterPoints = 0;
    String result = "Rental Record for " + customer.getName() + "\n";
    for (MovieRental r : customer.getRentals()) {
      Movie movie = movies.get(r.getMovieId());
      double thisAmount = calculateAmount(movie, r.getDays());

      // add frequent bonus points
      frequentEnterPoints += calculateFrequentEnterPoints(movie, r.getDays());

      result += "\t" + movie.getTitle() + "\t" + thisAmount + "\n";
      totalAmount += thisAmount;
    }
    // add footer lines
    result += "Amount owed is " + totalAmount + "\n";
    result += "You earned " + frequentEnterPoints + " frequent points\n";

    return result;
  }

  /**
   * Calculates the rental amount for a given movie and rental days.
   *
   * @param movie the Movie being rented
   * @param days  the number of days the movie is rented
   * @return the calculated rental amount
   */
  private double calculateAmount(Movie movie, int days) {
    return switch (movie.getType()) {
      // Regular movies: 2 for first 2 days, then 1.5 per extra day
      case REGULAR -> {
        double amount = 2;
        if (days > 2)
          amount += (days - 2) * 1.5;
        yield amount;
      }
      case NEW_RELEASE ->
        // New releases: 3 per day
        days * 3;
      case CHILDRENS -> {
        // Children's movies: 1.5 for first 3 days, then 1.5 per extra day
        double amount = 1.5;
        if (days > 3)
          amount += (days - 3) * 1.5;
        yield amount;
      }
    };
  }

  /**
   * Calculates the frequent renter points for a given movie and rental days.
   *
   * @param movie the Movie being rented
   * @param days  the number of days the movie is rented
   * @return the frequent renter points earned for this rental
   */
  private int calculateFrequentEnterPoints(Movie movie, int days) {
    int points = 1;
    if (movie.getType() == MovieType.NEW_RELEASE && days > 2) {
      points++;
    }
    return points;
  }
}
