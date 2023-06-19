package uz.friendchallange.friendchallange.mapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import uz.friendchallange.friendchallange.dto.QuestionDto;
import uz.friendchallange.friendchallange.exceptions.NotFoundException;
import uz.friendchallange.friendchallange.model.Question;
import uz.friendchallange.friendchallange.repository.AccountRepository;

@Component
@RequiredArgsConstructor
public class QuestionMapping {
    private final AccountRepository accountRepository;

    public Question toEntity(QuestionDto questionDto){
        return questionDto == null ? null : new Question(
                questionDto.getId(),
                questionDto.getUuid(),
                questionDto.getQuiz(),
                questionDto.getAnswerA(),
                questionDto.getAnswerB(),
                questionDto.getAnswerC(),
                questionDto.getAnswerD(),
                questionDto.getCorrectId(),
                questionDto.getSubject(),
                accountRepository.findById(questionDto.getAccountId()).orElseThrow(() -> new NotFoundException("User not found"))
        );
    }

    public QuestionDto toDto(Question question) {
        return question == null ? null : new QuestionDto(
                question.getId(),
                question.getUuid(),
                question.getQuiz(),
                question.getAnswerA(),
                question.getAnswerB(),
                question.getAnswerC(),
                question.getAnswerD(),
                question.getCorrectId(),
                question.getSubject(),
                question.getAccount().getId()
        );
    }
}
