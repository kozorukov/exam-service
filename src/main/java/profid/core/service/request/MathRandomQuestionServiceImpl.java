package profid.core.service.request;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import profid.core.service.exam.question.command.CreateExamQuestionCommand;
import profid.core.service.exam.question.command.ExamQuestionCommandService;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class MathRandomQuestionServiceImpl implements MathRandomQuestionService {

    private final OtherServiceRequestService otherServiceRequestService;
    private final ExamQuestionCommandService examQuestionCommandService;

    @Override
    public UUID request() {
        var question = otherServiceRequestService.getRandomMathQuestion();
        return examQuestionCommandService.create(
                CreateExamQuestionCommand.builder()
                        .question(question)
                        .build()
        );
    }
}
