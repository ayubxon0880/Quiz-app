package uz.friendchallange.friendchallange.mapper;

import uz.friendchallange.friendchallange.dto.AccountDto;
import uz.friendchallange.friendchallange.model.Account;

public class AccountMapping {
    public AccountDto toDto(Account account) {
        return account == null ? null : new AccountDto(
                account.getId(),
                account.getName(),
                account.getPassword(),
                account.getEmail()
        );
    }

    public Account toEntity(AccountDto accountDto) {
        return accountDto == null ? null : new Account(
                accountDto.getId(),
                accountDto.getName(),
                accountDto.getEmail(),
                accountDto.getPassword(),
                null
        );
    }

}
