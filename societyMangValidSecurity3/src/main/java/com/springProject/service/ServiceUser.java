package com.springProject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springProject.entity.User;
import com.springProject.repository.UserRepository;
@Service
public class ServiceUser implements InterfaceUser{
@Autowired 
UserRepository userRepo;
	@Override
	public User getUserByid(Long id) {
		// TODO Auto-generated method stub
		return userRepo.findById(id).orElse(null);
	}

	@Override
	public void updateUser(User user) {
		userRepo.save(user);
		
	}

}
