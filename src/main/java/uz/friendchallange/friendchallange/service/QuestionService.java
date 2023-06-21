package uz.friendchallange.friendchallange.service;

import uz.friendchallange.friendchallange.dto.QuestionDto;
import uz.friendchallange.friendchallange.dto.QuestionsCreationDto;
import uz.friendchallange.friendchallange.dto.SubjectUuidDto;

import java.util.HashMap;
import java.util.List;

public interface QuestionService {
    List<QuestionDto> create(QuestionsCreationDto form, String username);

    List<QuestionDto> getByUuid(String uuid);

    List<SubjectUuidDto> findSubjects(Integer id);
}
