package movierental;

public class RentalInfo {

    public String statement(Customer customer) {
        double totalAmount = 0;
        int frequentEnterPoints = 0;
        StringBuilder result = new StringBuilder("Rental Record for " + customer.getName() + "\n");
        for (MovieRental r : customer.getRentals()) {
            double thisAmount = r.calculateAmount();
            // add frequent bonus points
            frequentEnterPoints += r.calculateFrequentEnterPoints();
            result.append("\t").append(r.getMovie().getTitle()).append("\t").append(thisAmount).append("\n");
            totalAmount += thisAmount;
        }
        // add footer lines
        result.append("Amount owed is ").append(totalAmount).append("\n");
        result.append("You earned ").append(frequentEnterPoints).append(" frequent points\n");
        return result.toString();
    }
}
