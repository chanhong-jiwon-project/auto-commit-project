package com.til.autocommit.service;

import com.til.autocommit.domain.Comment;
import com.til.autocommit.dto.CommentReqDto;
import com.til.autocommit.dto.CommentResDto;
import com.til.autocommit.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;

    public ResponseEntity<?> searchComment(){
        List<CommentResDto> commentDtos = new ArrayList<>();
        List<Comment> comments = commentRepository.findAll();

        for(Comment comment : comments){
            commentDtos.add(CommentResDto.builder()
                    .title_id(comment.getTitle_id())
                    .text(comment.getText())
                    .date(comment.getDate())
                    .build());
        }

        return ResponseEntity.ok(commentDtos);
    }

    public ResponseEntity<?> saveComment(CommentReqDto commentReqDto){
        Comment comment = Comment.builder()
                .title_id(commentReqDto.getTitleId())
                .text(commentReqDto.getText())
                .date(commentReqDto.getDate())
                .build();

        return ResponseEntity.ok(commentRepository.save(comment));
    }
}
