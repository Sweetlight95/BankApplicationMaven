package africa.semicolon.bankApplication.services;

import africa.semicolon.bankApplication.data.models.Customer;
import africa.semicolon.bankApplication.dtos.response.CustomerResponse;

import java.util.List;

public interface CustomerService {
    List<CustomerResponse> findAll();

    void addNew(Customer customer);
}
