package com.til.autocommit.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class TistoryToGithubReqDto {

    private String title;

    @Builder
    public TistoryToGithubReqDto(String title) {
        this.title = title;
    }
}
