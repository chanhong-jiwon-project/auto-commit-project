package com.til.autocommit.domain;

import com.sun.istack.NotNull;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
// 잔소리 안 하겠다. 레벨에 따라서 다른데 생성자를 통해서만 이 클래스를 이용할 수 있게 만들겠다.
public class Tistory {

    @Id
    @GeneratedValue
    // 이 아이디를 디비에 인서트 될 때 자동생성 하겠다.
    private Long id;

    private String title;
    private String date;

    @NotNull
    private String postUrl;

    @Builder
    public Tistory(Long id, String title, String date, String postUrl) {
        //test 용
        this.id = id;
        this.title = title;
        this.date = date;
        this.postUrl = postUrl;
    }
}
