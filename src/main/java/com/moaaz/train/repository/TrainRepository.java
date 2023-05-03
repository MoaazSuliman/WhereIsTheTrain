package com.moaaz.train.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.moaaz.train.model.Train;

import java.util.Optional;

public interface TrainRepository extends JpaRepository<Train, Integer> {

   public  Optional<Train> findByNumberOfTrain(int numberOfTrain);
}
