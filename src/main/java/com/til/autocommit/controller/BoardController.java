package com.til.autocommit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BoardController {
    @GetMapping(value = "/board")
    public String board(){
        System.out.println("index 호출성공");
        return "/";
    }
}