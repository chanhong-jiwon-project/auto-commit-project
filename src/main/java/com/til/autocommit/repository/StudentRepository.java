package com.til.autocommit.repository;

import com.til.autocommit.domain.Student;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {
    //TODO JPA 쿼리 작성  예시 -> 회사 코드
    List<Student> findByNameContainingAndGrade(String name, Integer grade, Sort sort);
}
