package com.til.autocommit.repository;

import com.til.autocommit.domain.Recomment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecommentRepository extends JpaRepository<Recomment, Long> {

}
