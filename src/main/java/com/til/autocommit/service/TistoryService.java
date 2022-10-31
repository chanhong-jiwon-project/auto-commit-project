package com.til.autocommit.service;

import com.til.autocommit.domain.Tistory;
import com.til.autocommit.repository.TistoryRepository;
import com.til.autocommit.dto.TistoryToGithubReqDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TistoryService {
    private final TistoryRepository tistoryRepository;

    public ResponseEntity<?> searchTistoryList(String name) {
        List<Tistory> tistorys = tistoryRepository.findAllByName(name);

        List<TistoryToGithubReqDto> collect = tistorys.stream()
                .map(this::forMapping)
                .collect(Collectors.toList());

        return ResponseEntity.ok(collect);
    }

    private TistoryToGithubReqDto forMapping(Tistory x) {
        return TistoryToGithubReqDto.builder()
                .title(x.getTitle())
                .build();
    }

}
