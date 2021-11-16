package africa.semicolon.bankApplication.services;

import africa.semicolon.bankApplication.data.models.Customer;
import africa.semicolon.bankApplication.data.repositories.CustomerRepository;
import africa.semicolon.bankApplication.data.repositories.CustomerRepositoryImpl;
import africa.semicolon.bankApplication.dtos.response.CustomerResponse;

import java.util.ArrayList;
import java.util.List;

public class CustomerServiceImpl implements CustomerService{
    private final CustomerRepository customerRepository = new CustomerRepositoryImpl();

    @Override
    public List<CustomerResponse> findAll() {
        List<CustomerResponse> responses = new ArrayList<>();
        List<Customer> ourRealCustomers = customerRepository.findAll();

        for (Customer customer: ourRealCustomers){
            responses.add(new CustomerResponse(customer));
//            ourRealCustomers.forEach(customer -> responses.add(new CustomerResponse(customer)));
        }
        return responses;
    }

    @Override
    public void addNew(Customer customer) {
        customerRepository.save(customer);
    }

}
