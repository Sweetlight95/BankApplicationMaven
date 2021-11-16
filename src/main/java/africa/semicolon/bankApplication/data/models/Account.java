package africa.semicolon.bankApplication.data.models;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Account {
    private String customerId;
    private BigDecimal balance = BigDecimal.ZERO;
    private String number;
    private AccountType type;
}
