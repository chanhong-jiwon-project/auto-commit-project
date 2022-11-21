package com.til.autocommit.controller;

import com.til.autocommit.dto.BoardReqDto;
import com.til.autocommit.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;
    @GetMapping(value = "/board")
    public String board(){
        System.out.println("index 호출성공");
        return "/";
    }

    //게시판 리스트 전체 가져오기
    @GetMapping(value = "/board/list")
    public ResponseEntity<?> boardList(){
        System.out.println("list controller start");
        return boardService.searchBoard();
    }

    //게시판 데이터 넣기
    @PostMapping(value = "/board/save")
    public ResponseEntity<?> saveBoard(@RequestBody BoardReqDto boardReqDto){
        System.out.println("board write start");
        return boardService.saveBoard(boardReqDto);
    }


}
