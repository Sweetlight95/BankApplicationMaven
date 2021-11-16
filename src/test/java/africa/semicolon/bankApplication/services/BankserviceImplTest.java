package africa.semicolon.bankApplication.services;

import africa.semicolon.bankApplication.data.models.AccountType;
import africa.semicolon.bankApplication.dtos.request.CreateAccountRequest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BankServiceImplTest {
    BankService bankService;

    @BeforeEach
    void setUp() {
        bankService = new BankServiceImpl();
    }

    @AfterEach
    void tearDown() {
        bankService = null;
    }

    @Test
    void createBank(){
        //given
        String bankId = bankService.createBank("GTCO");
        //assert
        assertEquals("01", bankId);
    }
    @Test
    void createTwoBanksAndTheSecondBankIdWillBe02(){
        //when
        String gtCoId = bankService.createBank("GTCO");
        String firstBankId = bankService.createBank("First Bank");
        //assert
        assertEquals("01", gtCoId);
        assertEquals("02", firstBankId);
    }

    @Test
    void createTwoBanks_repositoryShouldHvaTwoBanks(){
        //when
        String gtCoId = bankService.createBank("GTCO");
        String firstBankId = bankService.createBank("First Bank");
        //assert
        assertEquals("01", gtCoId);
        assertEquals("02", firstBankId);
        assertEquals(2, bankService.findAllBanks().size());

    }

    @Test
    void bankCanCreateAccountForCustomersTest(){
        //given
        String gtCoId = bankService.createBank("GTCO");
        //when
        CreateAccountRequest createAccountRequest = new CreateAccountRequest();
        createAccountRequest.setAccountType(AccountType.CURRENT);
        createAccountRequest.setBankId("01");
        createAccountRequest.setFirstName("Agba");
        createAccountRequest.setLastName("Monsur");
        String accountNumber = bankService.createAccount(createAccountRequest);
        //assert
        assertEquals("0100000001", accountNumber);
    }

    @Test
    void createTwoAccountsForBankOne_SecondAccountNumberShouldBe02(){
        //given
        String gtCoId = bankService.createBank("GTCO");
        //when
        CreateAccountRequest agbasForm = new CreateAccountRequest();
        agbasForm.setAccountType(AccountType.SAVINGS);
        agbasForm.setBankId("01");
        agbasForm.setFirstName("Agba");
        agbasForm.setLastName("Monsur");
        String agbaAccountNumber = bankService.createAccount(agbasForm);
        CreateAccountRequest ajohnnesForm = new CreateAccountRequest();
        ajohnnesForm.setAccountType(AccountType.CURRENT);
        ajohnnesForm.setBankId("01");
        ajohnnesForm.setFirstName("John");
        ajohnnesForm.setLastName("Oladeji");
        String johnAccountNumber = bankService.createAccount(ajohnnesForm);
        //assert
        assertEquals("0100000001", agbaAccountNumber);
        assertEquals("0100000002", johnAccountNumber);
    }

    @Test
    void createTwoAccountsForBankOne_AndOneAccountForBankTwo(){
        //given
        String gtCoId = bankService.createBank("GTCO");
        String firstBankId = bankService.createBank("First Bank");
        //when
        CreateAccountRequest agbasForm = new CreateAccountRequest();
        agbasForm.setAccountType(AccountType.SAVINGS);
        agbasForm.setBankId("01");
        agbasForm.setFirstName("Agba");
        agbasForm.setLastName("Monsur");
        String agbasAccountNumber = bankService.createAccount(agbasForm);

        CreateAccountRequest ajohnnesForm = new CreateAccountRequest();
        ajohnnesForm.setAccountType(AccountType.TEENS);
        ajohnnesForm.setBankId("01");
        ajohnnesForm.setFirstName("John");
        ajohnnesForm.setLastName("Oladeji");
        String johnAccountNumber = bankService.createAccount(ajohnnesForm);

        CreateAccountRequest jerrysForm = new CreateAccountRequest();
        jerrysForm.setAccountType(AccountType.CURRENT);
        jerrysForm.setBankId("02");
        jerrysForm.setFirstName("Jerry");
        jerrysForm.setLastName("Chukwuma");
        String jerryAccountNumber = bankService.createAccount(jerrysForm);
        //assert
        assertEquals("0100000001", agbasAccountNumber);
        assertEquals("0100000002", johnAccountNumber);
        assertEquals("0200000001", jerryAccountNumber);
    }
    @Test
    void whenAccountIsCreated_CustomerIsCreatedToo(){
        String gtCoId = bankService.createBank("GTCO");
        //when
        CreateAccountRequest agbasForm = new CreateAccountRequest();
        agbasForm.setAccountType(AccountType.SAVINGS);
        agbasForm.setBankId("01");
        agbasForm.setFirstName("Agba");
        agbasForm.setLastName("Monsur");
        String agbasAccountNumber = bankService.createAccount(agbasForm);
        CustomerService customerService = new CustomerServiceImpl();
        assertEquals(1, customerService.findAll().size());
    }
}

