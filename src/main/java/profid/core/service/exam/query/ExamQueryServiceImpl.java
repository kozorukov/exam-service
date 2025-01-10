package profid.core.service.exam.query;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import profid.core.service.EntityConverter;
import profid.core.service.exam.ExamDto;
import profid.core.service.exam.answer.ExamAnswerDto;
import profid.core.service.exam.answer.ExamAnswerEntity;
import profid.core.service.exam.answer.ExamAnswerRepository;
import profid.core.service.exam.question.ExamQuestionDto;
import profid.core.service.exam.question.ExamQuestionEntity;
import profid.core.service.exam.question.ExamQuestionRepository;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ExamQueryServiceImpl implements ExamQueryService {

    private final ExamQuestionRepository examQuestionRepository;
    private final ExamAnswerRepository examAnswerRepository;
    private final EntityConverter<ExamAnswerEntity, ExamAnswerDto> examAnswerConverter;
    private final EntityConverter<ExamQuestionEntity, ExamQuestionDto> examQuestionConverter;

    @Override
    public Page<ExamDto> getAll(Pageable pageable) {
        return examQuestionRepository.findAll(pageable)
                .map(this::createResultDto);
    }

    private ExamDto createResultDto(ExamQuestionEntity examQuestion) {
        return ExamDto.builder()
                .question(examQuestionConverter.convert(examQuestion))
                .answers(getAnswersDtoByQuestion(examQuestion))
                .build();
    }

    private List<ExamAnswerDto> getAnswersDtoByQuestion(ExamQuestionEntity examQuestion) {
        return examAnswerRepository.findAllByQuestion(examQuestion).stream()
                .map(examAnswerConverter::convert)
                .toList();
    }

}
