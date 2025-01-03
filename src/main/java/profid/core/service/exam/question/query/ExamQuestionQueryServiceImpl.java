package profid.core.service.exam.question.query;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import profid.core.service.EntityConverter;
import profid.core.service.exam.question.ExamQuestionDto;
import profid.core.service.exam.question.ExamQuestionEntity;
import profid.core.service.exam.question.ExamQuestionRepository;

import java.util.UUID;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ExamQuestionQueryServiceImpl implements ExamQuestionQueryService {

    private final ExamQuestionRepository examQuestionRepository;
    private final EntityConverter<ExamQuestionEntity, ExamQuestionDto> examQuestionConverter;

    @Override
    public ExamQuestionDto get(UUID id) {
        return examQuestionRepository.findExamQuestionEntityById(id)
                .map(examQuestionConverter::convert)
                .orElseThrow(() -> new RuntimeException("!!!"));
    }
}
