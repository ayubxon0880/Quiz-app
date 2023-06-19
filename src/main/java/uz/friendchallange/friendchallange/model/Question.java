package uz.friendchallange.friendchallange.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String uuid;
    @NotBlank
    private String quiz;
    @NotBlank
    private String answerA;
    @NotBlank
    private String answerB;
    @NotBlank
    private String answerC;
    @NotBlank
    private String answerD;
    @NotBlank
    private String correctId;
    @NotBlank
    private String subject;
    @ManyToOne
    @JoinColumn(name = "account_id", nullable = false)
    private Account account;
}
