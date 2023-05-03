package com.moaaz.train.service;

import com.moaaz.train.model.Role;
import com.moaaz.train.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {
    @Autowired
    RoleRepository roleRepository;

    public Role addRole(Role role) {
        return roleRepository.save(role);
    }

    public Role getRoleById(int role_id) {
        return roleRepository.findById(role_id).orElse(null);
    }
}
