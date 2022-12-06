package com.til.autocommit.controller;

import com.til.autocommit.dto.CommentReqDto;
import com.til.autocommit.dto.RecommentReqDto;
import com.til.autocommit.service.CommentService;
import com.til.autocommit.service.RecommentService;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;
    private final RecommentService recommentService;

    @GetMapping(value = "/comment/list")
    public ResponseEntity<?> commentSearch(){
        System.out.println("comment 호출시도");
        return commentService.searchComment();
    }

    @PostMapping(value = "/comment/save")
    public ResponseEntity<?> commentSave(@RequestBody CommentReqDto commentReqDto){
        System.out.println("comment save 시도");
        return commentService.saveComment(commentReqDto);
    }

    @GetMapping(value = "/recomment/list")
    public ResponseEntity<?> recommentSearch(){
        System.out.println("recomment 호출시도");
        return recommentService.searchRecomment();
    }

    @PostMapping(value = "/recomment/save")
    public ResponseEntity<?> recommentSave(@RequestBody RecommentReqDto recommentReqDto){
        System.out.println("recomment save 시도");
        return recommentService.saveRecomment(recommentReqDto);
    }

    @PutMapping(value = "/recomment/{commentId}")
    public ResponseEntity<?> recommentUpdate(@PathVariable Long commentId, @RequestBody RecommentReqDto recommentReqDto){
        System.out.println("recomment update 시도");
        return recommentService.updateRecomment(commentId, recommentReqDto);
    }

}
