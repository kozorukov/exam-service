package profid.core.service.exam.answer.command;

import jakarta.validation.Valid;
import org.springframework.validation.annotation.Validated;

import java.util.UUID;

@Validated
public interface ExamAnswerCommandService {

    UUID create(@Valid CreateExamAnswerCommand command);
}
