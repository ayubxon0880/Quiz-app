package uz.friendchallange.friendchallange.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import uz.friendchallange.friendchallange.dto.QuestionDto;
import uz.friendchallange.friendchallange.dto.QuestionListDto;
import uz.friendchallange.friendchallange.mapper.QuestionMapping;
import uz.friendchallange.friendchallange.model.Account;
import uz.friendchallange.friendchallange.model.Question;
import uz.friendchallange.friendchallange.repository.AccountRepository;
import uz.friendchallange.friendchallange.repository.QuestionRepository;
import uz.friendchallange.friendchallange.service.QuestionService;

import java.util.*;

@Service
public class QuestionServiceImpl implements QuestionService {
    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private AccountRepository accountRepository;

    private QuestionMapping questionMapping;


    @Override
    public String create(Question question, String email) {
        if (question != null) {
            Account account = accountRepository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException("User not found"));
            String uuid = UUID.randomUUID().toString();
            question.setAccount(account);
            question.setUuid(uuid);
            questionRepository.save(question);
            return uuid;
        }
        return"none";
    }

    @Override
    public List<QuestionDto> readAll(Integer accountId) {
        return questionRepository.findByAccountId(accountId).map(questions -> questions.stream().map(question -> questionMapping.toDto(question)).toList()).orElse(Collections.emptyList());
    }

    @Override
    public QuestionDto read(String id) {
        return questionMapping.toDto(questionRepository.findByUuid(id));
    }

    @Override
    public QuestionDto update(QuestionDto questionDto) {
        return null;
    }

    @Override
    public boolean delete(Integer id) {
        return false;
    }

    @Override
    public String create(QuestionListDto questionListDto, String username) {
        Optional<Account> byEmail = accountRepository.findByEmail(username);
        String uuid = UUID.randomUUID().toString();
        if (byEmail.isPresent()) {
            for (Question question : questionListDto.getQuestions()) {
                question.setAccount(byEmail.get());
                question.setUuid(uuid);
                System.out.println("Saqlandi");
                questionRepository.save(question);

            }

            return uuid;
        }
        return "none";
    }
}
