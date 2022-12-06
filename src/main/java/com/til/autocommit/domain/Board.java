package com.til.autocommit.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Board {
    @Id
    @GeneratedValue()
    private Long idx;

    @Column(name = "NICK_NAME")
    private String name;

    @Column(name = "CREATE_ID")
    private String id;

    @Column(name = "CREATE_DATE")
    private String date;

    @Column(name = "TITLE")
    private String title;
}
