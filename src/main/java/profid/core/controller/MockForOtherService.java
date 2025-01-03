package profid.core.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ThreadLocalRandom;

// Заглушка для имитации внешнего сервиса
@RestController
@RequestMapping("/other-service")
public class MockForOtherService {

    @GetMapping("/random-math-question")
    public String get() {
        var first = ThreadLocalRandom.current().nextInt();
        var second = ThreadLocalRandom.current().nextInt();
        return String.format("%s + %s", first, second);
    }
}
