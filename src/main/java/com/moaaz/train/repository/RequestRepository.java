package com.moaaz.train.repository;

import com.moaaz.train.model.Request;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RequestRepository extends JpaRepository<Request , Integer> {

}
