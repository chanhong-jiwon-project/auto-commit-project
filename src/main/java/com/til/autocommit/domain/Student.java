package com.til.autocommit.domain;

import com.til.autocommit.dto.StudentReqDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/* TODO Domain에는 Setter를 사용하지 않음.
https://velog.io/@saint6839/%EB%8F%84%EB%A9%94%EC%9D%B8%EC%97%90%EC%84%9C-Setter-%EC%82%AC%EC%9A%A9%EC%9D%84-%EC%A7%80%EC%96%91%ED%95%98%EB%8A%94-%EC%9D%B4%EC%9C%A0
 */

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idx;

    @Column
    private String name;

    @Column
    private Integer grade;

    public void update(StudentReqDto studentReqDto){
        this.name = studentReqDto.getName();
        this.grade = studentReqDto.getGrade();
    }
}
