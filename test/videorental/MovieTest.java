package videorental;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MovieTest {

    @Test
    void testGetMoviePriceCode() {
        Movie movie = new Movie ("Star Wars V : The empire strikes back", Movie.NEW_RELEASE);

        assertEquals(Movie.NEW_RELEASE, movie.getPriceCode());
    }

    @Test
    void testGetMovieTitle() {
        Movie movie = new Movie ("Star Wars V : The empire strikes back", Movie.NEW_RELEASE);

        assertEquals("Star Wars V : The empire strikes back", movie.getTitle());
    }

    @Test
    void testChangeMoviePriceCode() {
        Movie movie = new Movie ("Star Wars V : The empire strikes back", Movie.NEW_RELEASE);

        movie.setPriceCode(Movie.REGULAR);
        assertNotEquals(Movie.NEW_RELEASE, movie.getPriceCode());
        assertEquals(Movie.REGULAR, movie.getPriceCode());
    }

}