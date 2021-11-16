package africa.semicolon.bankApplication.data.repositories;

import africa.semicolon.bankApplication.data.models.Account;
import africa.semicolon.bankApplication.data.models.AccountType;
import africa.semicolon.bankApplication.data.models.Customer;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class AccountRepositoryImplTest {
    AccountRepository accountRepository;
    @BeforeEach
    void setUp() {
        accountRepository = new AccountRepositoryImpl();
    }

    @AfterEach
    void tearDown() {
    }


    @Test
    void save() {
        //given
        Account account = new Account();
        Customer customer = new Customer();
        customer.setBvn("345453O3I");
        account.setCustomerId(customer.getBvn());
        account.setNumber("0072343768");
        account.setType(AccountType.KIDDIES);
        account.setBalance(BigDecimal.valueOf(30_00));
        Account savedAccount = accountRepository.save(account);
        //assert
        assertEquals(account, savedAccount);
    }

    @Test
    void findByCustomerId() {
        //when
        Account account = new Account();
        Customer customer = new Customer();
        customer.setBvn("345453O3I");
        account.setCustomerId(customer.getBvn());
        account.setNumber("0072343768");
        account.setType(AccountType.KIDDIES);
        account.setBalance(BigDecimal.valueOf(30_000));
        accountRepository.save(account);
        Account foundAccount = accountRepository.findByCustomerId(customer.getBvn());
        assertEquals(account, foundAccount);
    }

    @Test
    void delete() {
        //when
        Account account = new Account();
        Customer customer = new Customer();
        customer.setBvn("345453O3I");
        account.setCustomerId(customer.getBvn());
        account.setNumber("0072343768");
        account.setType(AccountType.KIDDIES);
        account.setBalance(BigDecimal.valueOf(30_000));
        accountRepository.save(account);
        assertNotNull(accountRepository.findByCustomerId("345453O3I"));
        //when
        accountRepository.delete("0072343768");
        //assert
        assertNull(accountRepository.findByCustomerId("0072343768"));
    }

    @Test
    void testDelete() {
        //when
        Account account = new Account();
        Customer customer = new Customer();
        customer.setBvn("345453O3I");
        account.setCustomerId(customer.getBvn());
        account.setNumber("0072343768");
        account.setType(AccountType.KIDDIES);
        account.setBalance(BigDecimal.valueOf(30_000));
        accountRepository.save(account);
        assertNotNull(accountRepository.findByCustomerId("345453O3I"));
        //when
        accountRepository.delete("345453O3I");
        //assert
        assertNull(accountRepository.findByCustomerId("345453O3I"));

    }

    @Test
    void findAll() {
        //when
        Account account = new Account();
        Customer customer = new Customer();
        customer.setBvn("345453O3I");
        account.setCustomerId(customer.getBvn());
        account.setNumber("0072343768");
        account.setType(AccountType.KIDDIES);
        account.setBalance(BigDecimal.valueOf(30_000));
        accountRepository.save(account);
        accountRepository.save(account);
        accountRepository.save(account);
        accountRepository.save(account);
        assertEquals(4, accountRepository.findAll().size() );
    }
}