package uz.friendchallange.friendchallange.service.Impl;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import uz.friendchallange.friendchallange.dto.AccountDto;
import uz.friendchallange.friendchallange.dto.QuestionDto;
import uz.friendchallange.friendchallange.mapper.AccountMapping;
import uz.friendchallange.friendchallange.mapper.QuestionMapping;
import uz.friendchallange.friendchallange.model.Account;
import uz.friendchallange.friendchallange.repository.AccountRepository;
import uz.friendchallange.friendchallange.repository.QuestionRepository;
import uz.friendchallange.friendchallange.service.AccountService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService, UserDetailsService {
    private final AccountRepository accountRepository;
    private final QuestionRepository questionRepository;
    private final QuestionMapping questionMapping;
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

    @Override
    public List<QuestionDto> findQuiz(Integer id) {
        return questionRepository.findByAccountId(id).map(questions -> questions.stream().map(questionMapping::toDto).toList()).orElse(Collections.emptyList());
    }

    @Override
    public List<Book> findAll() {
        return null;
    }
}
