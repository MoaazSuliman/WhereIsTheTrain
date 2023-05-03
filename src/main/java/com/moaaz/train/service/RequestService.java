package com.moaaz.train.service;

import com.moaaz.train.model.Request;
import com.moaaz.train.repository.RequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RequestService {
    @Autowired
    RequestRepository requestRepo;


    public Request addRequest(Request request) {
        return requestRepo.save(request);
    }

    public void updateRequest(Request request) {
        requestRepo.save(request);
    }

    public void deleteRequest(int id) {
        requestRepo.deleteById(id);
    }

    public List<Request> getAllRequests() {
        return requestRepo.findAll();
    }

}
