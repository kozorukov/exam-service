package profid.core.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import profid.core.service.exam.answer.command.CreateExamAnswerCommand;
import profid.core.service.exam.answer.command.ExamAnswerCommandService;

@RestController
@RequestMapping("/answers")
@RequiredArgsConstructor
public class AnswerController {

    private final ExamAnswerCommandService examAnswerCommandService;

    @PostMapping
    public void create(@RequestBody CreateExamAnswerCommand command) {
        examAnswerCommandService.create(command);
    }
}
