package videorental;

class Rental {
	private Movie movie;
	private int daysRented;

	public Rental(Movie movie, int daysRented) {
		this.movie = movie;
		this.daysRented = daysRented;
	}

	public int getDaysRented() {
		return daysRented;
	}

	public Movie getMovie() {
		return movie;
	}

	double getRentalFee() {
		double rentalFee = 0;
		switch (getMovie().getPriceCode()) {
			case Movie.REGULAR:
				rentalFee = 2;
				if (getDaysRented() > 2)
					rentalFee += (getDaysRented() - 2) * 1.5;
				break;

			case Movie.NEW_RELEASE:
				rentalFee = getDaysRented() * 3;
				break;

			case Movie.CHILDRENS:
				rentalFee = 1.5;
				if (getDaysRented() > 3)
					rentalFee += (getDaysRented() - 3) * 1.5;
				break;
		}
		return rentalFee;
	}
}