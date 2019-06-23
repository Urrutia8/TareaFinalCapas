package com.rdr.capas.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rdr.capas.domain.User;


public interface UserRepository extends JpaRepository<User, Integer>{
	public List<User> findByUsernameAndPassword(String username, String password);
}
