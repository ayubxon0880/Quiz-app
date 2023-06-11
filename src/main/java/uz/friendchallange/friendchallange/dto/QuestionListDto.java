package uz.friendchallange.friendchallange.dto;

import uz.friendchallange.friendchallange.model.Question;

import java.util.List;

public class QuestionListDto {
    private List<Question> questions;

    public QuestionListDto(List<Question> questions) {
        this.questions = questions;
    }

    public QuestionListDto() {
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }
}
