package com.til.autocommit.dto;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class CommentResDto {
    Integer title_id;
    String text;
    String date;
}
