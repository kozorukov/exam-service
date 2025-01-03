package profid.core.service.exam.question.command;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreateExamQuestionCommand {

    @NotBlank
    private final String question;

}
