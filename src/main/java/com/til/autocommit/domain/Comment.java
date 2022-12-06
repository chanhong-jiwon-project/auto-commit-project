package com.til.autocommit.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

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


    @ManyToOne
    @JoinColumn(name = "board_idx")
    private Board board;

    public void setBoard(Board board) {
        this.board = board;
    }
}
