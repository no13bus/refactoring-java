package movierental;

public class RentalInfo {

    public String statement(Customer customer) {
        double totalAmount = 0;
        int frequentEnterPoints = 0;
        String result = "Rental Record for " + customer.getName() + "\n";
        for (MovieRental r : customer.getRentals()) {
            double thisAmount = r.calculateAmount();
            // add frequent bonus points
            frequentEnterPoints += r.calculateFrequentEnterPoints();
            result += "\t" + r.getMovie().getTitle() + "\t" + thisAmount + "\n";
            totalAmount += thisAmount;
        }
        // add footer lines
        result += "Amount owed is " + totalAmount + "\n";
        result += "You earned " + frequentEnterPoints + " frequent points\n";
        return result;
    }
}
