package com.moaaz.train.service;

import com.moaaz.train.model.Station;
import com.moaaz.train.repository.StationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.ClientInfoStatus;
import java.util.List;

@Service
public class StationService {
    @Autowired
    StationRepository stationRepo;

    public Station addStation(Station station) {
        return stationRepo.save(station);
    }

    public Station updateStation(Station station) {
        return stationRepo.save(station);
    }

    public boolean deleteStationById(int id) {
        if (stationRepo.findById(id) != null) {
            stationRepo.deleteById(id);
            return true;
        }
        return false;
    }
    public List<Station>getAllStations(){
        return stationRepo.findAll();
    }

}
