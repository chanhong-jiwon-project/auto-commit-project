package com.til.autocommit.repository;

import com.til.autocommit.domain.Board;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BoardRepository extends JpaRepository<Board, Long> {
    List<Board> findAll();
    //TODO name or id 로 검색 만들기
    List<Board> findBoardByNameOrId(String name, String id);
}
