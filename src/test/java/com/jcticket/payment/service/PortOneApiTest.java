package com.jcticket.payment.service;

import com.jcticket.payment.dto.prepare.PrepareRequestDto;
import com.jcticket.payment.dto.prepare.PrepareResponseDto;
import com.jcticket.payment.dto.token.TokenResponseDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Objects;

/**
 * packageName    : com.jcticket.payment.service
 * fileName       : PortOneApiTest
 * author         : 조영상
 * date           : 3/13/24
 * description    : 자동 주석 생성
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 3/13/24         조영상        최초 생성
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class PortOneApiTest {
    @Autowired
    PortOneService portOneService;

    @Value("${PORTONE_API_KEY}")
    private String PORTONE_API_KEY;

    @Value("${PORTONE_API_SECRET}")
    private String PORTONE_API_SECRET;


    @Test
    public void keyTest()throws Exception{
        System.out.println("api key >> "+PORTONE_API_KEY);
        System.out.println("secret key >> "+PORTONE_API_SECRET);
    }

    @Test
    public void getTokenTest() throws Exception{
        ResponseEntity<TokenResponseDto> responseEntity = portOneService.getToken();
        System.out.println(responseEntity.getStatusCode());
        System.out.println(responseEntity.getBody());
        System.out.println("토큰 ===>>"+responseEntity.getBody().getResponse().getAccess_token());
        System.out.println(responseEntity.getBody().getCode());
        System.out.println(responseEntity.getBody().getResponse().toString());
    }

    @Test
    public void prepareTest() throws Exception{
        String test_token = "075b76833601ac9fb65aa80baba1542339600642";
        String test_uid = "test_ltjyrx32";
        String token = portOneService.getToken().getBody().getResponse().getAccess_token();
        PrepareRequestDto dto = PrepareRequestDto.builder()
                .merchant_uid(test_uid)
                .amount(35000)
                .build();

        ResponseEntity<PrepareResponseDto> responseEntity = portOneService.preparePayment(dto, token);
        System.out.println(responseEntity.getStatusCode());
        System.out.println(responseEntity.getBody());
        System.out.println(responseEntity.getBody().getCode());
        System.out.println(responseEntity.getBody().getMessage());
        System.out.println(responseEntity.getBody().getResponse());

    }
}
