package com.rdr.capas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rdr.capas.domain.User;
import com.rdr.capas.repositories.UserRepository;

@Service
public class UserService implements UserInterface {
	
	@Autowired
	private UserRepository uRepo;
	
	public List<User> findByUsernameAndPassword(String username, String password) {
		// TODO Auto-generated method stub
		
		return uRepo.findByUsernameAndPassword(username, password);
	}

	@Override
	public User findOne(Integer id) {
		// TODO Auto-generated method stub
		return uRepo.getOne(id);
	}
	

}
