package com.til.autocommit.service;

import com.til.autocommit.domain.Tistory;
import com.til.autocommit.dto.TistoryResDto;
import com.til.autocommit.repository.TistoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TistoryService {
    private final TistoryRepository tistoryRepository;

    public ResponseEntity<?> searchTistoryList(String name){
        List<TistoryResDto> tistoryDto = new ArrayList<>();
        List<Tistory> tistorys = tistoryRepository.findAllByName(name);

        for (Tistory tistory : tistorys){
//            tistoryDto.add(TistoryResDto.builder()
//                    .item(tistory.toString())
//                    .build());
        }

        return ResponseEntity.ok(tistoryDto);
    }
}
