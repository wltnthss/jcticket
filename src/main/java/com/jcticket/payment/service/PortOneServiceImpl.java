package com.jcticket.payment.service;

import com.jcticket.payment.dto.prepare.PrepareRequestDto;
import com.jcticket.payment.dto.prepare.PrepareResponseDto;
import com.jcticket.payment.dto.token.TokenRequestDto;
import com.jcticket.payment.dto.token.TokenResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Collections;
import java.util.Objects;

/**
 * packageName    : com.jcticket.payment.service
 * fileName       : PaymentServiceImpl
 * author         : 조영상
 * date           : 3/10/24
 * description    : 자동 주석 생성
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 3/10/24         조영상        최초 생성
 */
@Service
public class PortOneServiceImpl implements PortOneService {


    @Value("${PORTONE_API_KEY}")
    private String PORTONE_API_KEY;

    @Value("${PORTONE_API_SECRET}")
    private String PORTONE_API_SECRET;

    public String baseUrl = "https://api.iamport.kr";

    // 포트원 API 호출시 헤더에 필요한 인증토큰을 발급
    @Override
    public ResponseEntity<TokenResponseDto> getToken() throws Exception {
        URI uri = UriComponentsBuilder
                .fromUriString(baseUrl)
                .path("/users/getToken")
                .build()
                .toUri();
//        toUriHttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
//        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
//        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
//        map.add("imp_api", PORTONE_API_KEY);
//        map.add("imp_secret", PORTONE_API_SECRET);
//        HttpEntity<TokenRequestDto> request = new HttpEntity<>(request, headers);
//        System.out.println("map ===> "+map);
//        System.out.println(uri);
//        System.out.println("headers ===> "+ headers);
//        System.out.println("request ===> "+ request);

        // 테스트 성공...200 ok
        TokenRequestDto requestDto = TokenRequestDto.builder()
                .imp_key(PORTONE_API_KEY)
                .imp_secret(PORTONE_API_SECRET)
                .build();
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForEntity(uri, requestDto, TokenResponseDto.class);
    }

    public ResponseEntity<PrepareResponseDto> preparePayment(PrepareRequestDto dto, String token) {
        // IAMPORT API 호출
        URI uri = UriComponentsBuilder
                .fromUriString(baseUrl)
                .path("/payments/prepare")
                .build()
                .toUri();

        RequestEntity<PrepareRequestDto> requestEntity = RequestEntity
                .post(uri)
//                .header("Content-Type","application/json")
                .header("Authorization",token)
                .body(dto);

        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.exchange(requestEntity, PrepareResponseDto.class);
    }
}




//    @Autowired
//    public PortOneServiceImpl(WebClient.Builder webClientBuilder) {
//        this.webClient = webClientBuilder
//                .baseUrl("https://api.iamport.kr")
//                .build();
//    }
//MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
//        map.add("imp_api", PORTONE_API_KEY);
//        map.add("imp_secret", PORTONE_API_SECRET);
//String requestUrl = "/users/getToken";
//        return webClient.post()
//                .uri(requestUrl)
//                .body(BodyInserters.fromFormData(map))
//        .retrieve()
//                .toEntity(TokenResponseDto.class)
//                .doOnSuccess(res -> {
//        System.out.println("getToken() 요청 성공!");
//                    if(Objects.requireNonNull(res.getBody()).getCode() != 0){
//        throw new RuntimeException("PortOneService getToken() ERROR : " + res.getBody().getMessage());
//        }
//        })
//        .doOnError(e -> {
//        e.printStackTrace();
//                    throw  new RuntimeException(e);
//                })
//                        .block();
//MultiValueMap<String, String> map = new LinkedMultiValueMap<>();

//        map.add("merchant_uid", dto.getMerchant_uid());
//        map.add("amount", dto.getAmount().toString());
//String requestUrl = "/payments/prepare";
//        return webClient.post()
//                .uri(baseUrl + requestUrl)
//                .header("Authorization","Bearer " + token)
//                .body(BodyInserters.fromFormData(map))
//        .retrieve()
//                .toEntity(PrepareResponseDto.class)
//                .doOnSuccess(res -> {
//        System.out.println("preparePayment 요청 성공!");
//                    if(Objects.requireNonNull(res.getBody()).getCode() != 0){
//        throw new RuntimeException("PortOneService preparePayment() ERROR: " + res.getBody().getMessage());
//        }
//        })
//        .doOnError(e -> {
//        System.out.println(e.getMessage());
//        System.out.println(e.getStackTrace());
//        throw new RuntimeException(e);
//                })
//                        .block();
