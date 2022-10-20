package videorental;

public class NewReleaseMovie extends Movie {
    public NewReleaseMovie(String title, int priceCode) {
        super(title, priceCode);
    }

    public NewReleaseMovie(String title) {
        super(title, Movie.NEW_RELEASE);
    }

    @Override
    public double getRentalFee(int daysRented) {
        return daysRented * 3;
    }

    @Override
    boolean isRentalNewReleaseMovie(int daysRented) {
        return daysRented > 1;
    }
}
