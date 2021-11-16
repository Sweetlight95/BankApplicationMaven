package africa.semicolon.bankApplication.data.repositories;

import africa.semicolon.bankApplication.data.models.Customer;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomerRepositoryImplTest {
    private CustomerRepository customerRepository;

    @BeforeEach
    void setUp() {
        customerRepository = new CustomerRepositoryImpl();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void save() {
        //given
        Customer customer = new Customer();
        customer.setBvn("098726534");
        customer.setFirstName("Chibuzo");
        customer.setLastName("Ifeanyi");
        //when
        Customer savedCustomer = customerRepository.save(customer);
        //assert
        assertEquals(customer, savedCustomer);
    }

    @Test
    void findByCustomerId() {
        //given
        var customer = new Customer();
        customer.setBvn("098726534");
        customer.setFirstName("Chibuzo");
        customer.setLastName("Ifeanyi");
        customerRepository.save(customer);
        //when
        var foundCustomer = customerRepository.findByCustomerId("098726534");
        //assert
        assertEquals(customer, foundCustomer);
    }

    @Test
    void delete() {
        //given
        Customer customer = new Customer();
        customer.setBvn("098726534");
        customer.setFirstName("Chibuzo");
        customer.setLastName("Ifeanyi");
        customerRepository.save(customer);
        assertNotNull(customerRepository.findByCustomerId("098726534"));
        //when
        customerRepository.delete(customer);
        //assert
        assertNull(customerRepository.findByCustomerId("098726534"));
    }

    @Test
    void testDelete() {
        //given
        var customer = new Customer();
        customer.setBvn("098726534");
        customer.setFirstName("Chibuzo");
        customer.setLastName("Ifeanyi");
        customerRepository.save(customer);
        assertNotNull(customerRepository.findByCustomerId("098726534"));
        //when
        customerRepository.delete("098726534");
        //assert
        assertNull(customerRepository.findByCustomerId("098726534"));
    }

    @Test
    void findAll() {
        //given
        var customer = new Customer();
        customer.setBvn("098726534");
        customer.setFirstName("Chibuzo");
        customer.setLastName("Ifeanyi");
        //when
        customerRepository.save(customer);
        customerRepository.save(customer);
        customerRepository.save(customer);
        //assert
        assertEquals(3, customerRepository.findAll().size());
//        //when
//        customerRepository.delete("098726534");
//        //assert
//        assertNull(customerRepository.findByCustomerId("098726534"));

    }

}