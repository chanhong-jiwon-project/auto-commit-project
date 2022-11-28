package com.til.autocommit.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class TistoryResDto {

    // 응답 item
    // https://tistory.github.io/document-tistory-apis/apis/v1/post/list.html
    private InnerTistory tistory;

    @Getter
    public static class InnerTistory{
        private String status;
        private TistoryItem item;
        @Getter
        public static class TistoryItem{
            private List<TistoryPost> posts;
            private String url;
            private int page;
            private int count;
            private int totalCount;

            @Getter
            public static class TistoryPost {
                String id;
                String title;
                String postUrl;
                int visibility;
                String categoryId;
                String date;
            }
        }
    }

    @Builder
    public TistoryResDto(InnerTistory tistory) {
        this.tistory = tistory;
    }
}
