package uz.friendchallange.friendchallange.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import uz.friendchallange.friendchallange.dto.QuestionDto;
import uz.friendchallange.friendchallange.model.Question;

public class QuestionMapping {
    public Question toEntity(QuestionDto questionDto){
        return questionDto == null ? null : new Question(
                questionDto.getId(),
                questionDto.getUuid(),
                questionDto.getQuestion(),
                questionDto.getCorrectAnswer(),
                questionDto.getWrong1(),
                questionDto.getWrong2(),
                questionDto.getWrong3(),
                null
        );
    }

    public QuestionDto toDto(Question question) {
        return question == null ? null : new QuestionDto(
                question.getId(),
                question.getUuid(),
                question.getUserQuiz(),
                question.getCorrectAnswer(),
                question.getWrong1(),
                question.getWrong2(),
                question.getWrong3(),
                question.getAccount().getId()
        );
    }
}
