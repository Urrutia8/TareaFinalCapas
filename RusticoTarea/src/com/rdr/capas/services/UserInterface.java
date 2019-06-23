package com.rdr.capas.services;

import java.util.List;

import com.rdr.capas.domain.User;

public interface UserInterface {
	public List<User> findByUsernameAndPassword(String username, String password);
	public User findOne(Integer id);
}
