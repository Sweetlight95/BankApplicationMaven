package africa.semicolon.bankApplication.dtos.request;

import africa.semicolon.bankApplication.data.models.AccountType;
import lombok.Data;

@Data
public class CreateAccountRequest {
    private AccountType accountType;
    private String bankId;
    private String firstName;
    private String lastName;
    private String bvn;
}
