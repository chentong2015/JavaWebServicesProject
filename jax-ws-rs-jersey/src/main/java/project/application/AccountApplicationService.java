package project.application;

import project.domain.account.Account;
import project.domain.account.AccountRepository;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import project.infrastructure.utils.Encryption;

@Named
public class AccountApplicationService {

    @Inject
    private AccountRepository repository;

    @Inject
    private Encryption encoder;

    public void createAccount(Account account) {
    }
}
