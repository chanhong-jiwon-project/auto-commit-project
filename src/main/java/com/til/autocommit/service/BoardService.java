package com.til.autocommit.service;

import com.til.autocommit.domain.Board;
import com.til.autocommit.dto.BoardReqDto;
import com.til.autocommit.dto.BoardResDto;
import com.til.autocommit.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;

    public ResponseEntity<?> searchBoard(){
        List<BoardResDto> boardDtos = new ArrayList<>();
        List<Board> boards = boardRepository.findAll();

        for (Board board : boards){
            boardDtos.add(BoardResDto.builder()
                    .name(board.getName())
                    .id(board.getId())
                    .title(board.getTitle())
                    .date(board.getDate())
                    .build());
        }

        return ResponseEntity.ok(boardDtos);
    }

    public ResponseEntity<?> saveBoard(BoardReqDto boardReqDto){
        Board board = Board.builder()
                .name(boardReqDto.getName())
                .id(boardReqDto.getId())
                .title(boardReqDto.getTitle())
                .date(boardReqDto.getDate())
                .build();

        return ResponseEntity.ok(boardRepository.save(board));
    }

}
