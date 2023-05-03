package com.moaaz.train.service;

import com.moaaz.train.model.Line;
import com.moaaz.train.repository.LineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LineService {
    @Autowired
    LineRepository lineRepo;

    public Line addLine(Line line) {
        return lineRepo.save(line);
    }

    public Line updateLine(Line line) {
        return lineRepo.save(line);
    }

    public boolean deleteLineById(int id) {
        if (getLineById(id) != null) {
            lineRepo.deleteById(id);
            return true;
        }
        return false;
    }

    public Line getLineById(int id) {
        return lineRepo.findById(id).orElse(null);
    }

    public List<Line> getAllLines() {
        return lineRepo.findAll();
    }

}
