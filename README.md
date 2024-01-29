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