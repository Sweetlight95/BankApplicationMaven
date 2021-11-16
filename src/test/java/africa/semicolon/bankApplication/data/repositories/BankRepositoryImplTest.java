package africa.semicolon.bankApplication.data.repositories;

import africa.semicolon.bankApplication.data.models.Bank;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BankRepositoryImplTest {
    private BankRepository bankRepository;

    @BeforeEach
    void setUp() {
        bankRepository = new BankRepositoryImpl();
    }

    @AfterEach
    void tearDown() {

    }

    @Test
    void save() {
        //given
        Bank bank = new Bank("001");
        bank.setName("Wema Bank");
        //when
        Bank savedBank = bankRepository.save(bank);
        //assert
        assertEquals(bank, savedBank);

    }

    @Test
    void findByBankId() {
        //given
        Bank bank = new Bank("001");
        bank.setName("Wema Bank");
        bankRepository.save(bank);
        //when
        Bank foundBank = bankRepository.findByBankId("001");
        //assert
        assertEquals(bank, foundBank);
    }

    @Test
    void delete() {
        //given
        Bank bank = new Bank("001");
        bank.setName("Wema Bank");
        bankRepository.save(bank);
        assertNotNull(bankRepository.findByBankId("001"));
        //when
        bankRepository.delete(bank);
        //assert
        assertNull(bankRepository.findByBankId("001"));

    }

    @Test
    void testDelete() {
        //given
        Bank bank = new Bank("001");
        bank.setName("Wema Bank");
        bankRepository.save(bank);
        assertNotNull(bankRepository.findByBankId("001"));
        //when
        bankRepository.delete("001");
        //assert
        assertNull(bankRepository.findByBankId("001"));
    }

    @Test
    void findAll() {
        //given
        Bank bank = new Bank("001");
        bank.setName("Wema Bank");
        //when
        bankRepository.save(bank);
        bankRepository.save(bank);
        bankRepository.save(bank);
        bankRepository.save(bank);
        //assert
        assertEquals(4, bankRepository.findAll().size());
    }


}