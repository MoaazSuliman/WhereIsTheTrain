package com.moaaz.train.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.moaaz.train.model.Station;

public interface StationRepository extends JpaRepository<Station, Integer> {

}
