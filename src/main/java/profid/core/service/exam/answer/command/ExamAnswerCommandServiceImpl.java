package profid.core.service.exam.answer.command;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import profid.core.service.exam.answer.ExamAnswerEntity;
import profid.core.service.exam.answer.ExamAnswerRepository;
import profid.core.service.exam.question.ExamQuestionRepository;

import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class ExamAnswerCommandServiceImpl implements ExamAnswerCommandService {

    private final ExamQuestionRepository examQuestionRepository;
    private final ExamAnswerRepository examAnswerRepository;

    @Override
    public UUID create(CreateExamAnswerCommand command) {
        var question = examQuestionRepository.findById(command.getExamQuestionId())
                .orElseThrow(() -> new RuntimeException("!!!"));
        var examAnswerEntity = examAnswerRepository.save(
                new ExamAnswerEntity(
                        command.getText(),
                        command.isRight(),
                        question
                )
        );
        return examAnswerEntity.getId();
    }
}
