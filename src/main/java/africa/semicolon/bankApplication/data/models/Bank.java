package africa.semicolon.bankApplication.data.models;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Bank {
    private String name;
    private final String id;
    private final List<Account> accounts = new ArrayList<>();
}
