package profid.core.service.exam.question.query;

import profid.core.service.exam.question.ExamQuestionDto;

import java.util.UUID;

public interface ExamQuestionQueryService {
    ExamQuestionDto get(UUID id);
}
