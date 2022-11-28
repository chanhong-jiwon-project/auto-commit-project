package com.til.autocommit.domain;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Builder
//@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
// 잔소리 안 하겠다. 레벨에 따라서 다른데 생성자를 통해서만 이 클래스를 이용할 수 있게 만들겠다.
public class Tistory {

    @Id
    @GeneratedValue
    // 이 아이디를 디비에 인서트 될 때 자동생성 하겠다.
    private Long id;
<<<<<<< HEAD
    @Column(name = "POST_TITLE")
=======

    private String name;
>>>>>>> cf9b1c2775fe61866ffbd3a07940b4b0e64783e2
    private String title;

    @Column(name = "POST_DATE")
    private String date;

    @NotNull
    @Column(name = "POST_URL")
    private String postUrl;

    @Builder
    public Tistory(Long id, String name, String title, String date, String postUrl) {
        //test 용
        this.id = id;
        this.name = name;
        this.title = title;
        this.date = date;
        this.postUrl = postUrl;
    }
}
