package africa.semicolon.bankApplication.services;

import africa.semicolon.bankApplication.data.models.Bank;
import africa.semicolon.bankApplication.dtos.request.CreateAccountRequest;

import java.util.List;

public interface BankService {
    String createBank(String bankName);

    List<Bank> findAllBanks();

    String createAccount(CreateAccountRequest createAccountRequest);
}
