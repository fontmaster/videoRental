package videorental;

import java.util.ArrayList;
import java.util.List;

class Customer {
    private String name;
    private List<Rental> rentals = new ArrayList<>();

    public Customer(String name) {
        this.name = name;
    }

    public void addRental(Rental rental) {
        rentals.add(rental);
    }

    public String getName() {
        return name;
    }

    public String statement() {
        return "Rental Record for " + getName() + "\n" +
                getTotalRentalResults() +
                "Amount owed is " + getTotalRentalFee() + "\n" +
                "You earned " + getTotalFrequentRenterPoints() + " frequent renter pointers";
    }

    private String getTotalRentalResults() {
        String result = "";
        for (Rental rental : rentals) {
            result += "\t" + rental.getRentalFee() + "(" + rental.getMovie().getTitle() + ")" + "\n";
        }
        return result;
    }

    private double getTotalRentalFee() {
        double totalRentalAmount = 0;
        for (Rental rental : rentals) {
            totalRentalAmount += rental.getRentalFee();
        }
        return totalRentalAmount;
    }

    private int getTotalFrequentRenterPoints() {
        int frequentRenterPoints = 0;
        for (Rental rental : rentals) {
            frequentRenterPoints += rental.getFrequentRenterPoints();
        }
        return frequentRenterPoints;
    }


}