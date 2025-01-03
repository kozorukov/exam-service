package profid.core.service.request;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "other-service", url = "${other-service.url}")
public interface OtherServiceRequestService {

    @GetMapping("/other-service/random-math-question")
    String getRandomMathQuestion();
}
