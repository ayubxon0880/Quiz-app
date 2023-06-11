package uz.friendchallange.friendchallange.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import uz.friendchallange.friendchallange.dto.AccountDto;
import uz.friendchallange.friendchallange.mapper.AccountMapping;
import uz.friendchallange.friendchallange.model.Account;
import uz.friendchallange.friendchallange.repository.AccountRepository;
import uz.friendchallange.friendchallange.service.AccountService;

import java.util.ArrayList;
import java.util.List;

@Service
public class AccountServiceImpl implements AccountService, UserDetailsService {
    @Autowired
    private AccountRepository accountRepository;

    private final AccountMapping accountMapping = new AccountMapping();


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Account account = accountRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
        return new User(account.getEmail(), account.getPassword(), new ArrayList<>(List.of(new SimpleGrantedAuthority("default"))));
    }

    @Override
    public AccountDto create(AccountDto accountDto) {
        Account save = accountRepository.save(accountMapping.toEntity(accountDto));
        return accountMapping.toDto(save);
    }

    @Override
    public Account findByEmail(String email) {
        return accountRepository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }
}
