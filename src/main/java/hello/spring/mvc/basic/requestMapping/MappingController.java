package hello.spring.mvc.basic.requestMapping;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MappingController {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @RequestMapping(value = "/hello-basic")
    public String helloBasic() {
        logger.info("helloBasic");
        return "ok";
    }

    @RequestMapping(value = "/mapping-get-v1", method = RequestMethod.GET)
    public String mappingGetV1() {
        logger.info("mappingGetV1");
        return "ok";
    }

    /**
     * 편리한 축약 Annotation (Code 보기)
     * @GetMapping
     * @PostMapping
     * @PutMapping
     * @DeleteMapping
     * @PatchMapping
     */
    @GetMapping(value = "/mapping-get-v2")
    public String mappingGetV2() {
        System.out.println("MappingController.mappingGetV2");
        return "ok";
    }

    /**
     * PathVariable 사용
     * 변수명이 같으면 생략 가능
     * @PathVariable("userId") String userId -> @PathVariable userId
     */
    @GetMapping(value = "/mapping/{userId}")
    public String mappingPath(@PathVariable String userId) {
        logger.info("{}", userId);
        return userId;
    }

    /**
     * PathVariable 사용 다중
     */
    @GetMapping(value = "/mapping/users/{userId}/orders/{orderId}")
    public String mappingPath(@PathVariable String userId, @PathVariable Long orderId) {
        logger.info("{}{}", userId, userId);
        return userId + orderId;
    }

    /**
     * 파라미터로 추가 매핑
     * params="mode"
     * params="!mode"
     * params="mode=debug"
     * params="mode!=debug"
     * params={"mode=debug","data=good"}
     */
    @GetMapping(value = "mapping-param", params = "mode=debug")
    public String mappingParam() {
        logger.info("{}");
        return "ok";
    }

    /**
     * 특정 헤더로 추가 매핑
     * headers="mode",
     * headers="!mode",
     * headers="mode=debug"
     * headers="mode!=debug"
     */
    @GetMapping(value = "mapping-header", headers = "mode=debug")
    public String mappingHeader() {
        return "ok";
    }

    /**
     * Content-Type Header 기반 추가 Mapping Media Type
     * consumes="application/json"
     * consumes!="application/json"
     * consumes="application/*"
     * consumes="*\/*"
     * MediaType.APPLICATION_JSON_VALUE
     */
    @PostMapping(value = "/mapping-consume", consumes = MediaType.APPLICATION_JSON_VALUE)
    public String mappingConsumes() {
        return "ok";
    }

    /**
     * Accept Header 기반 Media Type
     * produces="text/html"
     * produces!="text/html"
     * produces="text/*"
     * produces="*\/*"
     * MediaType.TEXT_HTML_VALUE
     */
    @PostMapping(value = "/mapping-produce", produces = MediaType.TEXT_HTML_VALUE)
    public String mappingProduces() {
        return "ok";
    }
}
