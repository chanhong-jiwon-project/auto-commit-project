package com.til.autocommit.dto;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class RecommentResDto {
    Integer comment_id;
    String text;
    String date;
}
