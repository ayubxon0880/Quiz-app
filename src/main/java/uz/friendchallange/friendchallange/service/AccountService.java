package uz.friendchallange.friendchallange.service;

import uz.friendchallange.friendchallange.dto.AccountDto;
import uz.friendchallange.friendchallange.dto.Book;
import uz.friendchallange.friendchallange.dto.QuestionDto;
import uz.friendchallange.friendchallange.model.Account;

import java.util.List;

public interface AccountService {
    AccountDto create(AccountDto accountDto);

    Account findByEmail(String username);

    List<QuestionDto> findQuiz(Integer id);

    List<Book> findAll();
}
