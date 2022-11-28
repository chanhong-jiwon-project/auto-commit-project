package com.til.autocommit.controller;

import com.til.autocommit.dto.CommentReqDto;
import com.til.autocommit.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

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

}
