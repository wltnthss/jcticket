# LiveTemplates 사용 (자동 주석)

* class 생성시 자동 주석 생성 설정입니다.

```
/**
 *packageName    : ${PACKAGE_NAME}
 * fileName       : ${NAME}
 * author         : ${USER}
 * date           : ${DATE}
 * description    : 자동 주석 생성
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * ${DATE}        ${USER}       최초 생성
 */
```

* window 기준 ctrl + shift + a -> code template 이동
* includes 이동 후 -> ${User} 부분 자신 이름 변경 ex) jisoo Son
* description ex) 클래스 파일 생성 용도 적어주시면 됩니다.

# lombok 세팅

* lombok 은 getter, setter, 생성자를 어노테이션을 통해 자동으로 설정해주는 라이브러리입니다.
* 설정은 아래와 같이 설정해주세요.

*https://inpa.tistory.com/entry/IntelliJ-%F0%9F%92%BD-Lombok-%EC%84%A4%EC%B9%98-%EB%B0%A9%EB%B2%95-%EC%98%A4%EB%A5%98-%ED%95%B4%EA%B2%B0