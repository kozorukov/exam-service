package profid.core.service.exam.query;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import profid.core.service.exam.ExamDto;

public interface ExamQueryService {
    Page<ExamDto> getAll(Pageable pageable);
}
