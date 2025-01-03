package profid.core.service.exam.question.converter;

import org.springframework.stereotype.Component;
import profid.core.service.EntityConverter;
import profid.core.service.exam.question.ExamQuestionDto;
import profid.core.service.exam.question.ExamQuestionEntity;

@Component
public class ExamQuestionConverter implements EntityConverter<ExamQuestionEntity, ExamQuestionDto> {

    @Override
    public ExamQuestionDto convert(ExamQuestionEntity entity) {
        return ExamQuestionDto.builder()
                .id(entity.getId())
                .text(entity.getQuestionText())
                .build();
    }
}
