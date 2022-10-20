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
            double currentRentalFee = getRentalFee(rental);
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

    private double getRentalFee(Rental rental) {
        double rentalFee = 0;
        switch (rental.getMovie().getPriceCode()) {
            case Movie.REGULAR:
                rentalFee = 2;
                if (rental.getDaysRented() > 2)
                    rentalFee += (rental.getDaysRented() - 2) * 1.5;
                break;

            case Movie.NEW_RELEASE:
                rentalFee = rental.getDaysRented() * 3;
                break;

            case Movie.CHILDRENS:
                rentalFee = 1.5;
                if (rental.getDaysRented() > 3)
                    rentalFee += (rental.getDaysRented() - 3) * 1.5;
                break;
        }
        return rentalFee;
    }
}