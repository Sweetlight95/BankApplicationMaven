package africa.semicolon.bankApplication.data.repositories;

import africa.semicolon.bankApplication.data.models.Customer;

import java.util.List;

public interface CustomerRepository {

    Customer save(Customer customer);

    Customer findByCustomerId(String id);

    void delete(Customer customer);

    void delete(String id);

    List<Customer> findAll();
}
