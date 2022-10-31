package com.til.autocommit.controller;

import com.til.autocommit.dto.TistoryReqDto;
import com.til.autocommit.dto.TistoryResDto;
import com.til.autocommit.service.TistoryApi;
import com.til.autocommit.service.TistoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@Controller
@RequiredArgsConstructor
public class TistoryController {

    private final TistoryService tistoryService;
    private final TistoryApi tistoryApi;


    @GetMapping(value = "/tistory")
    @ResponseBody
    public TistoryResDto tistory() throws IOException {
        TistoryResDto tistoryResDtoHttpEntity = tistoryApi.tistoryApiResult();
        return tistoryResDtoHttpEntity;
    }

    @GetMapping("/tistorys")
    public ResponseEntity<?> searchTistoryList(@RequestParam(value = "name", required = false,defaultValue = "jiwon709") String name){

        return tistoryService.searchTistoryList(name);
    }

    @PostMapping("/tistory/tistorys")
    public ResponseEntity<?> saveTistory(@RequestBody TistoryReqDto tistoryReqDto){
        return tistoryApi.tistorySaveResult(tistoryReqDto);
    }
}
