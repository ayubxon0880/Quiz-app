package uz.friendchallange.friendchallange.service;

import uz.friendchallange.friendchallange.dto.AccountDto;
import uz.friendchallange.friendchallange.model.Account;

public interface AccountService {
    AccountDto create(AccountDto accountDto);

    Account findByEmail(String username);
}
