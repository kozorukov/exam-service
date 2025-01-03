package profid.core.service.exam.question.command;

import jakarta.validation.Valid;
import org.springframework.validation.annotation.Validated;
import profid.core.service.exam.question.ExamQuestionDto;

import java.util.UUID;

@Validated
public interface ExamQuestionCommandService {

    void deleteById(UUID id);

    UUID create(@Valid CreateExamQuestionCommand command);

    void update(@Valid ExamQuestionDto examQuestion);
}
