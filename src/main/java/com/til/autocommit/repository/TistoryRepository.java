package com.til.autocommit.repository;

import com.til.autocommit.domain.Tistory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TistoryRepository extends JpaRepository<Tistory, Long> {
    List<Tistory> findAllByName(String name);

}
