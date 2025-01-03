package profid.core.service.exam;

import lombok.Builder;
import lombok.Data;
import profid.core.service.exam.answer.ExamAnswerDto;
import profid.core.service.exam.question.ExamQuestionDto;

import java.util.List;

@Data
@Builder
public class ExamDto {
    private final ExamQuestionDto question;
    private final List<ExamAnswerDto> answers;
}
