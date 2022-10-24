package com.til.autocommit.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@NoArgsConstructor
public class TistoryResDto {
    String status;
    TistoryItem item;

    @Getter
    public static class TistoryItem{
        List<TistoryPost> posts;

        public static class TistoryPost{
            String id;
        }
    }

}
