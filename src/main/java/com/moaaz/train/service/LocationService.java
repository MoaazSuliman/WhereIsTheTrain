package com.moaaz.train.service;

import com.moaaz.train.model.Location;
import com.moaaz.train.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LocationService {

    @Autowired
    LocationRepository locationRepo;
    public void addLocation(Location location) {
        locationRepo.save(location);
    }

}
