package africa.semicolon.bankApplication.data.repositories;

import africa.semicolon.bankApplication.data.models.Bank;

import java.util.List;

public interface BankRepository {
    Bank save(Bank bank);

    Bank findByBankId(String id);

    void delete(Bank bank);

    void delete(String id);

    List<Bank> findAll();
}
