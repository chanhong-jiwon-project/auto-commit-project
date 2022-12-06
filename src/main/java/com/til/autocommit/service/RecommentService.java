package com.til.autocommit.service;

import com.til.autocommit.domain.Recomment;
import com.til.autocommit.dto.RecommentReqDto;
import com.til.autocommit.dto.RecommentResDto;
import com.til.autocommit.repository.RecommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RecommentService {

    private final RecommentRepository recommentRepository;

    public ResponseEntity<?> searchRecomment(){
        List<RecommentResDto> recommentDtos = new ArrayList<>();
        List<Recomment> recomments = recommentRepository.findAll();

        for (Recomment recomment : recomments){
            recommentDtos.add(RecommentResDto.builder()
                    .comment_id(recomment.getComment_id())
                    .text(recomment.getText())
                    .date(recomment.getDate())
                    .build());
        }
        return ResponseEntity.ok(recommentDtos);
    }

    public ResponseEntity<?> saveRecomment(RecommentReqDto recommentReqDto){
        Recomment recomment = Recomment.builder()
                .comment_id(recommentReqDto.getCommentId())
                .text(recommentReqDto.getText())
                .date(recommentReqDto.getDate())
                .build();

        return ResponseEntity.ok(recommentRepository.save(recomment));
    }

    @Transactional
    public ResponseEntity<?> updateRecomment(Long idx,RecommentReqDto recommentReqDto){
        Recomment recomment = recommentRepository.findById(idx).orElseThrow(
                () -> new NullPointerException("해당 대댓글이 없습니다.")
        );

        recomment.update(recommentReqDto);

        return ResponseEntity.ok(recomment);
    }
}
