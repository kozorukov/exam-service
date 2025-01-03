package profid.core.service.exam.answer;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import profid.core.service.JpaEntity;
import profid.core.service.exam.question.ExamQuestionEntity;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ExamAnswerEntity extends JpaEntity {

    @NotBlank
    private String answerText;

    @Column(name = "is_right")
    private boolean right;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    private ExamQuestionEntity question;
}
