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
        double totalRentalAmount = 0;
        int frequentRenterPoints = 0;
        StringBuilder result = new StringBuilder("Rental Record for " + getName() + "\n");

        for (Rental rental : rentals) {
            double currentRentalFee = rental.getRentalFee();
            frequentRenterPoints += getFrequentRenterPoints(rental);
            result.append(getRentalResult(rental, currentRentalFee));
            totalRentalAmount += currentRentalFee;
        }

        result.append("Amount owed is ").append(totalRentalAmount).append("\n");
        result.append("You earned ").append(frequentRenterPoints).append(" frequent renter pointers");

        return result.toString();
    }

    private String getRentalResult(Rental rental, double currentRentalFee) {
        return "\t" + currentRentalFee + "(" + rental.getMovie().getTitle() + ")" + "\n";
    }

    private int getFrequentRenterPoints(Rental rental) {
        return isRetnalNewReleaseMovie(rental)? 2 : 1;
    }

    private boolean isRetnalNewReleaseMovie(Rental rental) {
        return (rental.getMovie().getPriceCode() == Movie.NEW_RELEASE) && rental.getDaysRented() > 1;
    }

}