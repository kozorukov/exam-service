package profid.core.service.exam.question.command;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import profid.core.exception.EntityNotFoundException;
import profid.core.service.exam.answer.ExamAnswerRepository;
import profid.core.service.exam.question.ExamQuestionDto;
import profid.core.service.exam.question.ExamQuestionEntity;
import profid.core.service.exam.question.ExamQuestionRepository;

import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class ExamQuestionCommandServiceImpl implements ExamQuestionCommandService {

    private final ExamQuestionRepository examQuestionRepository;
    private final ExamAnswerRepository examAnswerRepository;

    @Override
    public void deleteById(UUID id) {
        examAnswerRepository.deleteAllByExamQuestionId(id);
        examQuestionRepository.deleteById(id);
    }

    @Override
    public UUID create(@Valid CreateExamQuestionCommand command) {
        var examQuestionEntity = examQuestionRepository.save(new ExamQuestionEntity(command.getQuestion()));
        return examQuestionEntity.getId();
    }

    @Override
    public void update(@Valid ExamQuestionDto examQuestion) {
        var examQuestionEntity = examQuestionRepository.findById(examQuestion.getId())
                .orElseThrow(() -> new EntityNotFoundException("Вопрос не найден"));
        examQuestionEntity.setQuestionText(examQuestion.getText());
    }
}
