package uz.friendchallange.friendchallange.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class QuestionDto {
    private Integer id;
    private String uuid;
    private String quiz;
    private String answerA;
    private String answerB;
    private String answerC;
    private String answerD;
    private String correctId;
    private String subject;
    private Integer accountId;
}
