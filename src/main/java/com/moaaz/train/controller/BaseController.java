package com.moaaz.train.controller;

import com.moaaz.train.model.Admin;
import com.moaaz.train.model.User;
import com.moaaz.train.service.AdminService;
import com.moaaz.train.service.BaseService;
import com.moaaz.train.service.UserService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/base")
public class BaseController {

    @Autowired
    BaseService baseService;
    @Autowired
    UserService userService;
    @Autowired
    AdminService adminService;


    @GetMapping("/login")
    public ResponseEntity<Object> login(@RequestParam String email, @RequestParam String password, HttpSession session) {
        Object object = baseService.login(email, password);
        if (object instanceof User) {
            session.setAttribute("userId", ((User) object).getId());
            return new ResponseEntity<>((User) object, HttpStatus.OK);
        } else if (object instanceof Admin) {
            session.setAttribute("adminId", ((Admin) object).getId());
            return new ResponseEntity<>((Admin) object, HttpStatus.OK);
        }

        return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
    }


    /* if phone and password are in our database we will change password for him. */
    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/forgetPassword")
    public boolean forgetPassword(@RequestParam @Valid String email, @RequestParam @Valid String phone, @RequestParam @Valid String newPassword) throws ConstraintViolationException {
        return baseService.forgetPassword(email, phone, newPassword);
    }
}
