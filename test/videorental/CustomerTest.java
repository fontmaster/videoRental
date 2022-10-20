package videorental;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomerTest {

    @Test
    void testCreateCustomer() {
        Customer customer = new Customer("Martin Pauler");

        assertNull(customer);
    }

    @Test
    void testGetName() {
        Customer customer = new Customer("Martin Pauler");

        assertEquals("Martin Pauler", customer.getName());
    }

    @Test
    void testStatement() {
        Customer customer = new Customer("Martin Pauler");
        Movie movie = new Movie ("Star Wars V : The empire strikes back", Movie.NEW_RELEASE);
        Rental rental = new Rental(movie, 5);

        customer.addRental(rental);

        // ....?

    }
}