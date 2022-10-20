package videorental;

public class RegularMovie extends Movie {
    public RegularMovie(String title, int priceCode) {
        super(title, priceCode);
    }

    public RegularMovie(String title) {
        super(title, Movie.REGULAR);
    }

    @Override
    public double getRentalFee(int daysRented) {
        double rentalFee = 2;
        if (daysRented > 2)
            rentalFee += (daysRented - 2) * 1.5;

        return rentalFee;
    }
}
