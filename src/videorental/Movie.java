package videorental;

public abstract class Movie {
	public static final int CHILDRENS = 2;
	public static final int REGULAR = 0;
	public static final int NEW_RELEASE = 1;
	
	private String title;
	private int priceCode;

	public Movie(String title, int priceCode) {
		this.title = title;
		this.priceCode = priceCode;
	}

	public int getPriceCode() {
		return priceCode;
	}

	public void setPriceCode(int arg) {
		priceCode = arg;
	}

	abstract public double getRentalFee(int daysRented);


	public String getTitle() {
		return title;
	};

	boolean isRentalNewReleaseMovie(int daysRented) {
		return false;
	}
}