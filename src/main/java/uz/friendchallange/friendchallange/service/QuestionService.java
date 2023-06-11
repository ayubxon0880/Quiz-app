package uz.friendchallange.friendchallange.service;

import uz.friendchallange.friendchallange.dto.QuestionDto;
import uz.friendchallange.friendchallange.dto.QuestionListDto;
import uz.friendchallange.friendchallange.model.Question;

import java.util.List;

public interface QuestionService {
    String create(Question question, String email);
    List<QuestionDto> readAll(Integer accountId);
    QuestionDto read(String id);
    QuestionDto update(QuestionDto questionDto);
    boolean delete(Integer id);
    String create(QuestionListDto questionListDto, String username);
}
