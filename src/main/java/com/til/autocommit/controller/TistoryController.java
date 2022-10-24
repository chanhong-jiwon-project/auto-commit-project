package com.til.autocommit.controller;

import com.til.autocommit.service.TistoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class TistoryController {

    private final TistoryService tistoryService;

    @GetMapping("/tistorys")
    public ResponseEntity<?> searchTistoryList(@RequestParam(value = "name", required = false,defaultValue = "jiwon709") String name){

        return tistoryService.searchTistoryList(name);
    }
}
