package com.til.autocommit.dto;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class BoardResDto {
    String name;
    String id;
    String date;
    String title;
}
