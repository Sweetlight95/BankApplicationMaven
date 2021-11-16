package africa.semicolon.bankApplication.data.models;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Customer {
    private String bvn;
    private String firstName;
    private String lastName;
    private final List<Account> accounts = new ArrayList<>();
}
