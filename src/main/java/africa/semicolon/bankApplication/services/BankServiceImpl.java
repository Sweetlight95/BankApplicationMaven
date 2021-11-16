package africa.semicolon.bankApplication.services;

import africa.semicolon.bankApplication.data.models.Account;
import africa.semicolon.bankApplication.data.models.Bank;
import africa.semicolon.bankApplication.data.models.Customer;
import africa.semicolon.bankApplication.data.repositories.BankRepository;
import africa.semicolon.bankApplication.data.repositories.BankRepositoryImpl;
import africa.semicolon.bankApplication.dtos.request.CreateAccountRequest;

import java.util.List;

public class BankServiceImpl implements BankService{
    private final BankRepository bankRepository = new BankRepositoryImpl();
    private final CustomerService customerService = new CustomerServiceImpl();

    @Override
    public String createBank(String bankName) {
        String bankId = generateBankId();
        Bank bank = new Bank(bankId);
        bank.setName(bankName);
        Bank savedBank = bankRepository.save(bank);
        return savedBank.getId();
    }

    private String generateBankId(){
        int lastBankIdCreated = findAllBanks().size();
        return String.format("%02d", ++lastBankIdCreated);
    }

    @Override
    public List<Bank> findAllBanks() {
        return bankRepository.findAll();
    }

    @Override
    public String createAccount(CreateAccountRequest createAccountRequest) {
        String bankId = createAccountRequest.getBankId();
        String accountNumber = generateSuffixFor(bankId);
        Customer customer = new Customer();

        Account account = new Account();
        account.setNumber(bankId + accountNumber);
        account.setType(createAccountRequest.getAccountType());

        customer.setFirstName(createAccountRequest.getFirstName());
        customer.setLastName(createAccountRequest.getLastName());
        customer.getAccounts().add(account);
        customer.setBvn("No bvn implemented");
        customerService.addNew(customer);

        Bank bank = bankRepository.findByBankId(bankId);
        bank.getAccounts().add(account);
        bankRepository.save(bank);
//        System.out.println(bankRepository.findAll());
        return account.getNumber();
    }

    private String generateSuffixFor(String bankId) {
        Bank bank = bankRepository.findByBankId(bankId);
        int lastNumber = bank.getAccounts().size();
        return String.format("%08d", ++lastNumber);
    }
}
