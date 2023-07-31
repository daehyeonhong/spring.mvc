# *`Logging`*

제품 환경에서는 로깅을 위해 `System.out.print()`와 같은 `SystemConsole`을 사용하지 않고, 별도의 로깅 라이브러리를 사용한다.

## 로깅 라이브러리

`SpringBoot`는 기본적으로 `spring-boot-starter-logging` 라이브러리를 제공한다. 이 라이브러리는 `SLF4J`와 `Logback`을 사용한다.

[SLF4J](https://www.slf4j.org/)는 로깅을 위한 인터페이스를 제공하는 라이브러리이다. `SLF4J`는 로깅을 위한 인터페이스를 제공하고, 실제 로깅을 위한 구현체는 `Logback`과 같은
다른 라이브러리를 사용한다.

[Logback](https://logback.qos.ch/)은 `SLF4J`의 구현체이다. `Logback`은 `SLF4J`의 인터페이스를 구현하고, 실제 로깅을 수행한다.

로그 레벨

| 로그 레벨 | 설명                |
|-------|-------------------|
| TRACE | 디버깅을 위한 로그 레벨     |
| DEBUG | 디버깅을 위한 로그 레벨     |
| INFO  | 정보를 제공하기 위한 로그 레벨 |
| WARN  | 경고를 제공하기 위한 로그 레벨 |
| ERROR | 에러를 제공하기 위한 로그 레벨 |

로그 레벨은 `TRACE`부터 `ERROR`까지 순서대로 중요도가 높아진다. 예를 들어, 로그 레벨을 `INFO`로 설정하면 `INFO`보다 중요도가 낮은 `DEBUG`와 `TRACE` 로그는 출력되지 않는다.
기본 로그 레벨은 `INFO`이다.

로그를 사용할 때는 치환자(placeholder)를 사용하는 것이 좋다. 치환자를 사용하면 로그를 출력할 때 문자열을 연결하는 연산을 수행하지 않기 때문에 성능이 향상된다.

```java

@RestController
public class LogTestController {
    private final Logger log = LoggerFactory.getLogger(getClass());
    @GetMapping("/log-test")
    public String logTest() {
        // 치환자를 사용하지 않은 경우
        log.info("logTest called. name: " + name + ", age: " + age);
        
        // 치환자를 사용한 경우
        log.info("logTest called. name: {}, age: {}", name, age);
        return "ok";
    }
}

```
