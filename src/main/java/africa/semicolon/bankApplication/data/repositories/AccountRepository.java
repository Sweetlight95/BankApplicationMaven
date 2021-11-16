package africa.semicolon.bankApplication.data.repositories;

import africa.semicolon.bankApplication.data.models.Account;

import java.util.List;

public interface AccountRepository {
    Account save(Account account);

    Account findByCustomerId(String id);

    void delete(Account account);

    void delete(String customerId);

    List<Account> findAll();
}
