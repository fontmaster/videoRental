package videorental;

import org.approvaltests.Approvals;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomerTest {

    @Test
    void testCreateCustomer() {
        Customer customer = new Customer("Martin Pauler");

        assertNotNull(customer);
    }

    @Test
    void testGetName() {
        Customer customer = new Customer("Martin Pauler");

        assertEquals("Martin Pauler", customer.getName());
    }

    @Test
    void approvalTestStatement_01() {
        Customer customer = new Customer("Martin Pauler");
        Movie movie = new NewReleaseMovie ("Star Wars V : The empire strikes back");
        Rental rental = new Rental(movie, 5);

        customer.addRental(rental);

        Approvals.verify(customer.statement());
    }

    @Test
    void approvalTestStatement_02() {
        Customer customer = new Customer("Sangjeong Jo");
//        Movie regularMovie = new Movie ("Jurassic Park", Movie.REGULAR);
//        Movie childMovie = new Movie ("Pororo : The president of children", Movie.CHILDRENS);
//        Movie newMovie = new Movie ("Orange is the new black", Movie.NEW_RELEASE);
        Movie regularMovie = new RegularMovie ("Jurassic Park");
        Movie childMovie = new ChildMovie ("Pororo : The president of children");
        Movie newMovie = new NewReleaseMovie ("Orange is the new black");
        Rental rentalForRegularMovie = new Rental(regularMovie, 5);
        Rental rentalForChildrenMovie = new Rental(childMovie, 4);
        Rental rentalForNewMovie = new Rental(newMovie, 3);

        customer.addRental(rentalForRegularMovie);
        customer.addRental(rentalForChildrenMovie);
        customer.addRental(rentalForNewMovie);

        Approvals.verify(customer.statement());
    }
}