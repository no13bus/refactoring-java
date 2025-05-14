package movierental;

import movierental.strategy.RentalStrategy;
import movierental.strategy.RentalStrategyFactory;

public class RentalInfo {

    /**
     * Generates a rental statement for the given customer.
     * The statement includes details of each rental, total amount owed, and
     * frequent renter points earned.
     *
     * @param customer the customer for whom the statement is generated
     * @return a formatted string representing the rental statement
     */
    public String statement(Customer customer) {
        double totalAmount = 0;
        int frequentEnterPoints = 0;
        StringBuilder result = new StringBuilder("Rental Record for " + customer.getName() + "\n");
        for (MovieRental rental : customer.getRentals()) {
            RentalStrategy strategy = RentalStrategyFactory.getStrategy(rental.getMovie().getType());
            double thisAmount = strategy.calculateAmount(rental);
            // add frequent bonus points
            frequentEnterPoints += strategy.calculatePoints(rental);
            result.append("\t")
                    .append(rental.getMovie().getTitle())
                    .append("\t")
                    .append(thisAmount).append("\n");
            totalAmount += thisAmount;
        }
        // add footer lines
        result.append("Amount owed is ").append(totalAmount).append("\n");
        result.append("You earned ").append(frequentEnterPoints).append(" frequent points\n");
        return result.toString();
    }
}
