package uz.friendchallange.friendchallange.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.friendchallange.friendchallange.model.Question;

import java.util.List;
import java.util.Optional;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Integer> {
    Optional<List<Question>> findByAccountId(Integer accountId);
    Question findByUuid(String uuid);


}
