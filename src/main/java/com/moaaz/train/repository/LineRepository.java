package com.moaaz.train.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.moaaz.train.model.Line;
import org.springframework.stereotype.Repository;

@Repository
public interface LineRepository extends JpaRepository<Line, Integer> {

}
