package com.moaaz.train.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.moaaz.train.model.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	public User findByEmailAndPassword(String email, String password);

	public User findByEmailAndPhone(String email, String phone);
}
