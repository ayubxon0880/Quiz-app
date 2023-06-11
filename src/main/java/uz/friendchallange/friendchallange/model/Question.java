package uz.friendchallange.friendchallange.model;

import jakarta.persistence.*;
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
    private String userQuiz;
    private String correctAnswer;
    private String wrong1;
    private String wrong2;
    private String wrong3;
    @ManyToOne
    @JoinColumn(name = "account_id", nullable = false)
    private Account account;
}
