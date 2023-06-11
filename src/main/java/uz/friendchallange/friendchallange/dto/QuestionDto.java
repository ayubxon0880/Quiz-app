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
    private String question;
    private String correctAnswer;
    private String wrong1;
    private String wrong2;
    private String wrong3;
    private Integer account;
}
