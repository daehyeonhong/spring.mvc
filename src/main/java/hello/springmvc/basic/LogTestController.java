package hello.springmvc.basic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LogTestController {
    private final Logger log = LoggerFactory.getLogger(getClass());

    @GetMapping("/log-test")
    public String logTest() {
        System.out.println("name = " + getName());
        if (log.isTraceEnabled())
            log.trace("trace log = {}", getName());
        if (log.isDebugEnabled())
            log.debug("debug log = {}", getName());
        log.info("info log = {}", getName());
        log.warn("warn log={}", getName());
        log.error("error log={}", getName());

        return "ok";
    }

    private String getName() {
        System.out.println("LogTestController.getName");
        return "Spring";
    }
}
