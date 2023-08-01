# *`RequestMapping`*

## 1. `RequestMapping`

### 1.1. `RequestMapping`란?

- 클라이언트의 요청을 어떤 메서드가 처리할지 매핑해주는 어노테이션
- `@RequestMapping`은 클래스, 메서드에 적용할 수 있다.
- 클래스에 붙이는 경우, 해당 클래스의 모든 메서드에 `prefix`로 붙는다.
- 축약 표현으로 `GetMapping`, `PostMapping`, `PutMapping`, `PatchMapping`, `DeleteMapping`이 있다.
- `@RequestMapping`은 `value`와 `method`를 속성으로 가진다.
    - `value`는 `path`를 의미한다.
    - `method`는 `HTTP Method`를 의미한다. 지정하지 않은 경우, 모든 `HTTP Method`에 대응한다.
    - `method`와 `path`는 배열로 여러개를 지정할 수 있다.
- `Spring`은 `/hello-basic`과 `/hello-basic/`을 구분하지 않는다.

최근 `HTTP API`는 리소스 경로에 식별자를 넣는 스타일을 선호한다. 그래서 `@PathVariable`을 사용하는 것이 좋다.

`@RequestMapping`은 `URL` 경로를 템플릿화 할 수 있는데, 이때 `@PathVariable`을 사용한다. `@PathVariable`은 `@RequestMapping`의 `path`에 있는 `{}`
에 매칭된다. 객체의 이름과 `@PathVariable`의 이름이 같으면 생략할 수 있다.
