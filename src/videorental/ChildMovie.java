package videorental;

public class ChildMovie extends Movie {
    public ChildMovie(String title, int priceCode) {
        super(title, priceCode);
    }

    public ChildMovie(String title) {
        super(title, Movie.CHILDRENS);
    }

    @Override
    public double getRentalFee(int daysRented) {
        double rentalFee = 1.5;
        if (daysRented > 3)
            rentalFee += (daysRented - 3) * 1.5;

        return rentalFee;
    }

}
