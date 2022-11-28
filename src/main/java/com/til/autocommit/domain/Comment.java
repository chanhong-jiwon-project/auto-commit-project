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
@NoArgsConstructor
@AllArgsConstructor
public class Comment {
    @Id
    @GeneratedValue()
    private Long idx;

    @Column(name = "TITLE_ID")
    private Integer title_id;

    @Column(name = "TEXT")
    private String text;

    @Column(name = "CREATE_DATE")
    private String date;
}
