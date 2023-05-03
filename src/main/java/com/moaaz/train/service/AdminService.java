package com.moaaz.train.service;

import com.moaaz.train.model.Admin;
import com.moaaz.train.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    @Autowired
    AdminRepository adminRepo;

    public Admin getAdminByEmailAndPassword(String email, String password) {
        return adminRepo.findByEmailAndPassword(email, password);
    }

    public void updateAdmin(Admin admin) {
        adminRepo.save(admin);
    }

    public Admin getAdminByEmailAndPhone(String email, String phone) {
        return adminRepo.findByEmailAndPhone(email, phone);
    }

    public Admin addAdmin(Admin admin) {
        return adminRepo.save(admin);
    }

    public Admin getAdminById(int admin_id) {
        return adminRepo.findById(admin_id).orElse(null);
    }
}
