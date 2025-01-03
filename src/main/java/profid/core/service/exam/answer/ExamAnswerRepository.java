package profid.core.service.exam.answer;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import profid.core.service.JpaRepository;
import profid.core.service.exam.question.ExamQuestionEntity;

import java.util.Set;
import java.util.UUID;

public interface ExamAnswerRepository extends JpaRepository<ExamAnswerEntity> {
    Set<ExamAnswerEntity> findAllByQuestion(ExamQuestionEntity question);

    @Modifying
    @Query("delete from ExamAnswerEntity a where a.question.id = :id")
    void deleteAllByExamQuestionId(UUID id);
}
