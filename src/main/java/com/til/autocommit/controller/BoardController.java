package com.til.autocommit.controller;

import com.til.autocommit.dto.TistoryResDto;
import com.til.autocommit.service.TistoryApi;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;

@Controller
@RequiredArgsConstructor
public class BoardController {

    @GetMapping(value = "/board")
    public String broad(){
        System.out.println("index 호출성공");
        return "/";
    }
}
