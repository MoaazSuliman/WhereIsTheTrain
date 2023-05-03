package com.moaaz.train.service;

import com.moaaz.train.model.Admin;
import com.moaaz.train.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BaseService {

    @Autowired
    UserService userService;
    @Autowired
    AdminService adminService;

    public Object login(String email, String password) {
        User user = userService.getUserByEmailAndPassword(email, password);

        Admin admin = adminService.getAdminByEmailAndPassword(email, password);
        if (user != null)
            return user;
        else if (admin != null)
            return admin;
        return null;
    }

    public boolean forgetPassword(String email, String phone, String newPassword) {
        System.out.println(email + " " + newPassword);
        Admin admin = adminService.getAdminByEmailAndPhone(email, phone);
        User user = userService.getUserByEmailAndPhone(email, phone);
        if (admin != null) {
            admin.setPassword(newPassword);
            adminService.updateAdmin(admin);
            return true;
        } else if (user != null) {
            user.setPassword(newPassword);
            userService.updateUser(user);
            return true;
        }
        return false;
    }

}
