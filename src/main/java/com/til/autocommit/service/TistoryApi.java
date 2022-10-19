package com.til.autocommit.service;

import com.til.autocommit.domain.Tistory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.IOException;

//서비스 어노테이션 안에 컴포넌트 어노테이션이 포함되어 있는데,
//컴포넌트 어노테이션 안에 컴포넌트 스캐너 어노테이션으로 빈 등록이 된다.
//스프링 어플리케이션 실행시 스프링부트 어노테이션 안에 컴포넌트 어노테이션, 스캐너 어노테이션도 같이 종속되어 있다.
//서비스 로직 안에서는 실제 실행되는 로직이 들어있으면 안되고, 인터페이스 공유되는 로직만 들어있어야 함. -> 이건 나중에 구현 끝나고 리팩토링 하는걸 추천
@Service
public class TistoryApi {

    //Vault
    //db
    @Value("${tistory.token}")
    private String ACCESS_TOKEN;
    private static final String TISTORY_URL = "https://www.tistory.com/apis/post/list?";
    private static final String OUTPUT = "json";
    private static final String BLOG_NAME = "jiwon709";
    private static final int PAGE = 1;

    //빈등록하면서 설정 추가 가능
    //config 파일 따로 만들어서 컨피그레이션 어노테이션 걸고 빈 등록 하면 어플리케이션 실행 시 자동 컨피그 되니까 컨피그 파일 따로 만들기.
    @Bean
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

    //api 호출
    public String tistoryApiResult () throws IOException {
        StringBuilder result = new StringBuilder();

        String connectUrl = TISTORY_URL;
        String token = ACCESS_TOKEN;
        String outType = OUTPUT;
        String blog = BLOG_NAME;
        int pageNum = PAGE;

        //api 호출 RestTemplate 사용으로 변경
        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(connectUrl)
                .queryParam("access_token", token)
                .queryParam("output", outType)
                .queryParam("blogName", blog)
                .queryParam("page", pageNum);

        HttpEntity<?> entity = new HttpEntity<>(headers);
        RestTemplate restTemplate = new RestTemplate();

        HttpEntity<String> response = restTemplate.exchange(
                builder.toUriString(),
                HttpMethod.GET,
                entity,
                String.class);

        Tistory tistory = Tistory.builder()
                .postUrl("")
                .date("")
                .title("")
                .build();

        return response.toString();
    }
}
