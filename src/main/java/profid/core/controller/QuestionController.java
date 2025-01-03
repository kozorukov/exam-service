package profid.core.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import profid.core.service.exam.question.command.CreateExamQuestionCommand;
import profid.core.service.exam.question.ExamQuestionDto;
import profid.core.service.exam.question.command.ExamQuestionCommandService;
import profid.core.service.exam.question.query.ExamQuestionQueryService;
import profid.core.service.request.MathRandomQuestionService;

import java.util.UUID;

@RestController
@RequestMapping("/questions")
@RequiredArgsConstructor
public class QuestionController {

    private final ExamQuestionQueryService examQuestionQueryService;
    private final ExamQuestionCommandService examQuestionCommandService;
    private final MathRandomQuestionService mathRandomQuestionService;

    @GetMapping("/{id}")
    public ExamQuestionDto get(@PathVariable UUID id) {
        return examQuestionQueryService.get(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) {
        examQuestionCommandService.deleteById(id);
    }

    @PostMapping
    public ExamQuestionDto create(@RequestBody CreateExamQuestionCommand command) {
        var entityId = examQuestionCommandService.create(command);
        return examQuestionQueryService.get(entityId);
    }

    @PutMapping
    public ExamQuestionDto update(@RequestBody ExamQuestionDto examQuestion) {
        examQuestionCommandService.update(examQuestion);
        return examQuestionQueryService.get(examQuestion.getId());
    }

    @PostMapping("/request-new")
    public ExamQuestionDto requestNew() {
        var questionId = mathRandomQuestionService.request();
        return examQuestionQueryService.get(questionId);
    }
}
