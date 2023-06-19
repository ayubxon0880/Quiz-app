package uz.friendchallange.friendchallange.dto;


import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.friendchallange.friendchallange.model.Account;

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
