package uz.friendchallange.friendchallange.service;

import uz.friendchallange.friendchallange.dto.QuestionDto;
import uz.friendchallange.friendchallange.dto.QuestionsCreationDto;

import java.util.List;

public interface QuestionService {
    List<QuestionDto> create(QuestionsCreationDto form, String username);

    List<QuestionDto> getByUuid(String uuid);
}
