package com.moaaz.train.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.moaaz.train.model.Admin;
import com.moaaz.train.model.User;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer>{
	public Admin findByEmailAndPassword(String email, String password);
	public Admin findByEmailAndPhone(String email, String phone);

}
