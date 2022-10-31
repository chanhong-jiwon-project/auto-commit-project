package com.til.autocommit.service;

import com.til.autocommit.domain.Tistory;
import com.til.autocommit.dto.TistoryReqDto;
import com.til.autocommit.dto.TistoryResDto;
import com.til.autocommit.repository.TistoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.IOException;

//서비스 어노테이션 안에 컴포넌트 어노테이션이 포함되어 있는데,
//컴포넌트 어노테이션 안에 컴포넌트 스캐너 어노테이션으로 빈 등록이 된다.
//스프링 어플리케이션 실행시 스프링부트 어노테이션 안에 컴포넌트 어노테이션, 스캐너 어노테이션도 같이 종속되어 있다.
//서비스 로직 안에서는 실제 실행되는 로직이 들어있으면 안되고, 인터페이스 공유되는 로직만 들어있어야 함. -> 이건 나중에 구현 끝나고 리팩토링 하는걸 추천
@Service
@RequiredArgsConstructor
public class TistoryApi {

    private final TistoryRepository tistoryRepository;

    //Vault
    //db
    @Value("${tistory.token}")
    private String ACCESS_TOKEN;
    private static final String TISTORY_URL = "https://www.tistory.com/apis/post/list?";
    private static final String OUTPUT = "json";
    private static final String BLOG_NAME = "jiwon709";
    private static final int PAGE = 1;

    //api 호출
    public TistoryResDto tistoryApiResult () throws IOException {
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
        //꿀꿀꿀꿀꿀꿀꿀꿀 -oo-
        TistoryResDto response = restTemplate.getForObject(
            builder.toUriString(),
            TistoryResDto.class);

        //위에서 받은 posts를 아래의 티스토리 엔티티에 매핑한다.
        //방법은 정하기 나름. 스트림맵 or 포문
        Tistory tistory = Tistory.builder()
                .name("jiwon709")
                .build();
        //위에서 만든 리스트형태 or 단일객체형태의 티스토리 엔티리를
        //리포.save() or 리포.saveAll()을 통해 저장한다.

        //저장 잘 했다라는 정도의 응답.
        return response;
    }

    public ResponseEntity<?> tistorySaveResult(TistoryReqDto tistoryReqDto) {
        Tistory tistory = Tistory.builder()
                .name(tistoryReqDto.getName())
                .title(tistoryReqDto.getTitle())
                .date(tistoryReqDto.getDate())
                .build();

        return ResponseEntity.ok(tistoryRepository.save(tistory));
    }
}
