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
        double totalAmount = 0;
        int frequentRenterPoints = 0;
        String result = "Rental Record for " + getName() + "\n";

        for (Rental rental : rentals) {
            double currentRentalFee = getRentalFee(rental);

            // add frequent renter points
            frequentRenterPoints++;
            // add bonus for a two day new release rental

            if ((rental.getMovie().getPriceCode() == Movie.NEW_RELEASE) && rental.getDaysRented() > 1)
                frequentRenterPoints++;
            // show figures
            result += "\t" + currentRentalFee + "(" + rental.getMovie().getTitle() + ")" + "\n";

            totalAmount += currentRentalFee;
        }

        result += "Amount owed is " + totalAmount + "\n";
        result += "You earned " + frequentRenterPoints + " frequent renter pointers";

        return result;
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