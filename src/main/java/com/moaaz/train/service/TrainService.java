package com.moaaz.train.service;

import com.moaaz.train.model.Train;
import com.moaaz.train.repository.TrainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TrainService {
    @Autowired
    TrainRepository trainRepo;

    public Train addTrain(Train train) {
        return trainRepo.save(train);
    }

    public Train updateTrain(Train train) {
        return trainRepo.save(train);
    }

    public Train getTrainById(int id) {
        return trainRepo.findById(id).orElse(null);
    }

    public Train getTrainByTrainNumber(int numberOfTrain) {
        return trainRepo.findByNumberOfTrain(numberOfTrain).orElse(null);
    }

}
