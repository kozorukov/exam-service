package profid.core.service.exam.answer.command;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;
import profid.core.service.exam.question.ExamQuestionDto;

import java.util.UUID;

@Data
@Builder
public class CreateExamAnswerCommand {

    @NotBlank
    private final String text;

    private final boolean right;

    @NotNull
    private final UUID examQuestionId;
}
