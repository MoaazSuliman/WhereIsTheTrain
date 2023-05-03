package com.moaaz.train.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moaaz.train.model.User;
import com.moaaz.train.repository.UserRepository;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepo;

    public User getUserByEmailAndPassword(String email, String password) {
        return userRepo.findByEmailAndPassword(email, password);
    }

    public void updateUser(User user) {
        userRepo.save(user);
    }

    public User getUserByEmailAndPhone(String email, String phone) {
        return userRepo.findByEmailAndPhone(email, phone);
    }

    public User addUser(User user) {
        return userRepo.save(user);
    }

    public  User getUserById(int id ){
        return userRepo.findById(id).orElse(null);
    }
    public boolean deleteUserById(int id) {
        User user= getUserById(id);
        if(user!=null){
            userRepo.deleteById(id);
            return true;
        }
        return false;
    }
    public List<User>getAllUsers(){
        return userRepo.findAll();
    }
}
