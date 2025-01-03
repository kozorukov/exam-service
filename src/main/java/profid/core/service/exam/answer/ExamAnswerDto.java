package profid.core.service.exam.answer;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class ExamAnswerDto {

    private final UUID id;

    @NotBlank
    private final String text;

    private final boolean right;
}
