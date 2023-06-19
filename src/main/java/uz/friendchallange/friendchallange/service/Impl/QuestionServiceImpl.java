package uz.friendchallange.friendchallange.service.Impl;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import uz.friendchallange.friendchallange.dto.*;
import uz.friendchallange.friendchallange.exceptions.NotFoundException;
import uz.friendchallange.friendchallange.exceptions.SimpleException;
import uz.friendchallange.friendchallange.mapper.QuestionMapping;
import uz.friendchallange.friendchallange.model.Account;
import uz.friendchallange.friendchallange.model.Question;
import uz.friendchallange.friendchallange.repository.AccountRepository;
import uz.friendchallange.friendchallange.repository.QuestionRepository;
import uz.friendchallange.friendchallange.service.QuestionService;

import java.util.*;

@Service
@RequiredArgsConstructor
public class QuestionServiceImpl implements QuestionService {
    private final QuestionRepository questionRepository;
    private final AccountRepository accountRepository;
    private final QuestionMapping questionMapping;


    @Override
    public List<QuestionDto> create(QuestionsCreationDto form, String username) {
        String uuid = UUID.randomUUID().toString();
        Account account = accountRepository.findByEmail(username).orElseThrow(() -> new SimpleException("User not found"));
        List<Question> questions = new ArrayList<>();


        for (Question question : form.getQuestions()) {
            if (question != null){
                if (question.getAnswerA().length() == 0 &&
                        question.getAnswerB().length() == 0 &&
                        question.getAnswerC().length() == 0 &&
                        question.getAnswerD().length() == 0 &&
                        question.getCorrectId() == null &&
                        question.getQuiz().length() == 0){
                    return questions.stream().map(questionMapping::toDto).toList();
                }
                question.setUuid(uuid);
                question.setAccount(account);
                question.setSubject(form.getSubject());
                questions.add(questionRepository.save(question));
            }
        }

        return questions.stream().map(questionMapping::toDto).toList();
    }

    @Override
    public List<QuestionDto> getByUuid(String uuid) {
        Optional<List<Question>> questions = questionRepository.findByUuid(uuid);

        return questions.orElseThrow(() -> new NotFoundException("User not found"))
                .stream()
                .map(questionMapping::toDto)
                .toList();
    }
}
