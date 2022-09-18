package com.springProject.service;

import java.util.List;

import com.springProject.DTO.UserDTO;
import com.springProject.entity.User;

public interface UserService {
	void saveUser(UserDTO userDto);
	User findUserByid(Long id);
    User findUserByEmail(String email);
    List<UserDTO> findAllUsers();
	void updateUser(User user);
	void deleteUser(Long id);
}
