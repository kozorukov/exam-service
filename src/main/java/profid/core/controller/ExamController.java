package profid.core.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import profid.core.service.exam.ExamDto;
import profid.core.service.exam.query.ExamQueryService;

@RestController
@RequestMapping("/exam")
@RequiredArgsConstructor
public class ExamController {

    private final ExamQueryService examQueryService;

    @GetMapping
    public Page<ExamDto> get(Pageable pageable) {
        return examQueryService.getAll(pageable);
    }
}
