package com.moaaz.train.controller;

import com.moaaz.train.model.*;
import com.moaaz.train.service.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    RequestService requestService;
    @Autowired
    private AdminService adminService;
    @Autowired
    private UserService userService;
    @Autowired
    private LineService lineService;
    @Autowired
    private StationService stationService;
    @Autowired
    private LocationService locationService;
    @Autowired
    private TrainService trainService;

    @PostMapping("/addAdmin")
    public ResponseEntity<Admin> addAdmin(@RequestBody @Valid Admin admin) throws MethodArgumentNotValidException {
        return new ResponseEntity<>(adminService.addAdmin(admin), HttpStatus.CREATED);
    }

    @DeleteMapping("/deleteUser/{id}")
    public ResponseEntity<Object> deleteUserById(@PathVariable int id) {
        if (userService.deleteUserById(id)) {
            return new ResponseEntity<>("Deleted Success.", HttpStatus.ACCEPTED);
        }
        return new ResponseEntity<>("This User With Id + " + id + " Isn't In Our Database ", HttpStatus.NOT_FOUND);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/getAllUsers")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    /*Line*/
    @PostMapping("/addLine")
    public ResponseEntity<Line> addLine(@RequestBody @Valid Line line) {
        line.toString();
        return new ResponseEntity<>(lineService.addLine(line), HttpStatus.CREATED);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/getAllLines")
    public List<Line> getAllLines() {
        return lineService.getAllLines();
    }

//    @PutMapping("/updateLine/{id}")
//    public ResponseEntity<Line> updateLine(@PathVariable int id, @RequestParam @Valid String name) {
//
//    }

    /*Station*/

    @GetMapping("/getAllStations/{line_id}")
    public ResponseEntity<Object> getAllStationsForLine(@PathVariable int line_id) {
        Line line = lineService.getLineById(line_id);
        if (line != null) return new ResponseEntity<>(stationService.getAllStations(), HttpStatus.OK);
        return new ResponseEntity<>("There Is Not Line Has Id " + line_id, HttpStatus.NOT_FOUND);
    }

    @PostMapping("/addStation/{line_id}")
    public ResponseEntity<Object> addStationForLine(@PathVariable int line_id, @RequestBody @Valid Station station) throws MethodArgumentNotValidException {
        Line line = lineService.getLineById(line_id);
        System.out.println("This is the function");
        System.out.println(line.toString());
        System.out.println(station.toString());
        if (line != null) {
            // add location of station to database .
            locationService.addLocation(station.getLocation());
            System.out.println("Location Is Addedd Success.");
            // add station to database.
            station.setLine(line);
            stationService.addStation(station);
            System.out.println("Station Is Added Success.");
            // assign station for line and Update it.
            line.getStations().add(station);
            lineService.updateLine(line);
            return new ResponseEntity<>(true, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
    }
    /* End Of Stations */

    @GetMapping("/getAllTrains/{line_id}")
    public ResponseEntity<Object> getAllTrainForLine(@PathVariable int line_id) {
        Line line = lineService.getLineById(line_id);
        if (line != null) return new ResponseEntity<>(line.getTrains(), HttpStatus.OK);
        return new ResponseEntity<>("There Is Not Line Has Id " + line_id, HttpStatus.NOT_FOUND);
    }

    @PostMapping("/addTrainForLine/{line_id}")
    public ResponseEntity<Object> addTrainForLine(@RequestBody @Valid Train train, @PathVariable int line_id) {
        Line line = lineService.getLineById(line_id);
        if (line != null) {
            // assign line to train and add train.
            train.setLine(line);
            trainService.addTrain(train);
            // assign train to line and update line.
            line.getTrains().add(train);
            lineService.updateLine(line);
            return new ResponseEntity<>(true, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
    }

    /* Request */

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/getAllRequests")
    public List<Request> getAllRequests() {
        return requestService.getAllRequests();
    }
}
