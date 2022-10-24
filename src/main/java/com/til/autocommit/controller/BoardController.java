package com.til.autocommit.controller;

import com.til.autocommit.dto.TistoryResDto;
import com.til.autocommit.service.TistoryApi;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;

@Controller
@RequiredArgsConstructor
public class BoardController {

    private final TistoryApi tistoryApi;

    @GetMapping(value = "/board")
    public String broad(){
        System.out.println("index 호출성공");
        return "/";
    }

    @GetMapping(value = "/tistory")
    @ResponseBody
    public HttpEntity<TistoryResDto> tistory() throws IOException {
//        System.out.println(tistoryApi.tistoryApiResult());
        HttpEntity<TistoryResDto> tistoryResDtoHttpEntity = tistoryApi.tistoryApiResult();
        return tistoryResDtoHttpEntity;
    }
}
