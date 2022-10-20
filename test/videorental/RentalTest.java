package videorental;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RentalTest {

    @Test
    void testGetDaysRented() {
        Movie regularMovie = new Movie ("Jurassic Park", Movie.REGULAR);

        Rental rental = new Rental(regularMovie, 5);

        assertEquals(rental.getDaysRented(), 5);

    }

    @Test
    void testGetMovieFromRental() {
        Movie regularMovie = new Movie ("Jurassic Park", Movie.REGULAR);

        Rental rental = new Rental(regularMovie, 5);

        assertEquals(rental.getMovie(), regularMovie);

    }
}