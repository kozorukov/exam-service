package profid.core.service.exam.question;

import profid.core.service.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface ExamQuestionRepository extends JpaRepository<ExamQuestionEntity> {
    Optional<ExamQuestionEntity> findExamQuestionEntityById(UUID id);
}
