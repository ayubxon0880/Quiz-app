package uz.friendchallange.friendchallange.dto;

import lombok.Data;
import uz.friendchallange.friendchallange.model.Question;

import java.util.ArrayList;
import java.util.List;

@Data
public class QuestionsCreationDto {
    List<Question> questions = new ArrayList<>();
    String subject;
    public void addQuestion(Question question){
        this.questions.add(question);
    }
}
