package profid.core.service.exam.question;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class ExamQuestionDto {
    @NotNull
    private final UUID id;

    @NotBlank
    private final String text;
}
