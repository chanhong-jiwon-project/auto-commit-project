package com.til.autocommit.domain;

import com.til.autocommit.dto.RecommentReqDto;
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
public class Recomment {
    @Id
    @GeneratedValue()
    private Long idx;

    @Column(name = "COMMENT_ID")
    private Integer comment_id;

    @Column(name = "TEXT")
    private String text;

    @Column(name = "CREATE_DATE")
    private String date;

    @ManyToOne
    @JoinColumn(name = "comment_idx")
    private Comment comment;

    public void setComment(Comment comment) {
        this.comment = comment;
    }

    public void update(RecommentReqDto recommentReqDto){
        this.comment_id = recommentReqDto.getCommentId();
        this.text = recommentReqDto.getText();
        this.date = recommentReqDto.getDate();
    }
}
