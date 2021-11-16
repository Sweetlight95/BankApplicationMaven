package africa.semicolon.bankApplication.data.repositories;

import africa.semicolon.bankApplication.data.models.Customer;

import java.util.ArrayList;
import java.util.List;

public class CustomerRepositoryImpl implements CustomerRepository{
    List<Customer> customers = new ArrayList<>();

    @Override
    public Customer save(Customer customer) {
        customers.add(customer);
        return findByCustomerId(customer.getBvn());
    }

    @Override
    public Customer findByCustomerId(String id) {
        for (Customer customer: customers){
            if (customer.getBvn().equalsIgnoreCase(id)){
                return customer;
            }
        }
        return null;
    }

    @Override
    public void delete(Customer customer) {
        customers.remove(customer);
    }

    @Override
    public void delete(String id) {
        Customer customer = findByCustomerId(id);
        delete(customer);
    }

    @Override
    public List<Customer> findAll() {
        return customers;
    }
}
