package profid.core.service.exam.answer.converter;

import org.springframework.stereotype.Component;
import profid.core.service.EntityConverter;
import profid.core.service.exam.answer.ExamAnswerDto;
import profid.core.service.exam.answer.ExamAnswerEntity;

@Component
public class ExamAnswerConverter implements EntityConverter<ExamAnswerEntity, ExamAnswerDto> {

    @Override
    public ExamAnswerDto convert(ExamAnswerEntity entity) {
        return ExamAnswerDto.builder()
                .id(entity.getId())
                .text(entity.getAnswerText())
                .right(entity.isRight())
                .build();
    }
}
