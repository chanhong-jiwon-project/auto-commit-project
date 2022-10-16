package com.til.autocommit.dto;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class StudentResDto {
    String name;
    Integer grade;
}
