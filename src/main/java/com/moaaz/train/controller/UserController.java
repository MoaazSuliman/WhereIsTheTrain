package com.moaaz.train.controller;

import com.moaaz.train.model.*;
import com.moaaz.train.service.*;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/users")
@Validated
public class UserController {

    @Autowired
    AdminService adminService;
    @Autowired
    private UserService userService;
    @Autowired
    private LineService lineService;
    @Autowired
    private RequestService requestService;
    @Autowired
    private TrainService trainService;
    @Autowired
    private LocationService locationService;

//    @PutMapping("/putRoleForUser/{user_id}")
//    @ResponseStatus(HttpStatus.OK)
//    public Role setRole(@RequestBody Role role) {
//        return roleService.addRole(role);
//    }


    @PostMapping("/signup")
    public ResponseEntity<User> signup(@RequestBody @Valid User user) throws MethodArgumentNotValidException {
        System.out.println(user);
        return new ResponseEntity<>(userService.addUser(user), HttpStatus.CREATED);

    }

    @GetMapping("/getLineForUser")
    public ResponseEntity<List<Line>> getLineForUser(HttpSession session) {
        int user_id = (int) session.getAttribute("user_id");
        System.out.println("User Id IS " + user_id);
        User user = userService.getUserById(user_id);
        return new ResponseEntity<>(user.getLines(), HttpStatus.OK);
    }

    @PostMapping("/addLineForUser/{line_id}")
    public ResponseEntity<Object> addLineForUser(@PathVariable int line_id, HttpSession session) {
        Line line = lineService.getLineById(line_id);
        User user = userService.getUserById((int) session.getAttribute("user_id"));
        System.out.println(user.toString());
        if (line != null && user != null) {
            user.addLine(line);
            line.getUsers().add(user);
            userService.updateUser(user);
            return new ResponseEntity<>(true, HttpStatus.ACCEPTED);
        }
        return new ResponseEntity<>(false, HttpStatus.BAD_REQUEST);
    }


    /*Request*/
    @PostMapping("/addRequest/{user_id}")
    public ResponseEntity<Object> addRequest(@PathVariable int user_id, @RequestBody @Valid Request request) {
        User user = userService.getUserById(user_id);
        if (user != null) {
            request.setUser(user);
            request.setTime(LocalDateTime.now());
            requestService.addRequest(request);

            return new ResponseEntity<>(request, HttpStatus.ACCEPTED);
        }
        return new ResponseEntity<>("You Are Not Here", HttpStatus.NOT_FOUND);
    }
    /*End Of Request*/

    @GetMapping("/setLocationForTrain/{user_id}")
    public ResponseEntity<Object> addLocationForTrain(@PathVariable int user_id, @RequestParam int nubmerOfTrain, @RequestBody Location newLocationForTrainInThisMoment) {
        User user = userService.getUserById(user_id);
        Train train = trainService.getTrainByTrainNumber(nubmerOfTrain);
        if (user == null) return new ResponseEntity<>("There Are No User With Id " + user_id, HttpStatus.BAD_REQUEST);
        if (train == null)
            return new ResponseEntity<>("There Are No Train With This Number " + nubmerOfTrain, HttpStatus.BAD_REQUEST);
        newLocationForTrainInThisMoment.setUser_id(user_id);
        locationService.addLocation(newLocationForTrainInThisMoment);
        train.addLocationForTrain(newLocationForTrainInThisMoment);
        return new ResponseEntity<>(trainService.updateTrain(train), HttpStatus.CREATED);
    }
}
