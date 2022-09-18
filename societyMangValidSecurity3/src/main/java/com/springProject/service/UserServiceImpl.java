package com.springProject.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.springProject.DTO.UserDTO;
import com.springProject.entity.Role_user;
import com.springProject.entity.User;
import com.springProject.repository.Role_Repository;
import com.springProject.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{
	private UserRepository userRepo;
	private Role_Repository roleRepo;
	private PasswordEncoder passwordEncoder;
	public UserServiceImpl(UserRepository userRepo, Role_Repository roleRepo, PasswordEncoder passwordEncoder) {
		this.passwordEncoder=passwordEncoder;
		this.userRepo=userRepo;
		this.roleRepo=roleRepo;
	}
	@Override
	public void saveUser(UserDTO userDto) {
		User user = new User();
        user.setFirstname(userDto.getFirstname());
        user.setLastname(userDto.getLastname());
        user.setEmail(userDto.getEmail());
        // encrypt the password using spring security
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));

        Role_user role = roleRepo.findByName("ROLE_ADMIN");
        if(role == null){
            role = checkRoleExist();
        }
        user.setRoles(Arrays.asList(role));
        userRepo.save(user);
		
	}

	@Override
	public User findUserByEmail(String email) {
		// TODO Auto-generated method stub
		return userRepo.findByEmail(email);
	}

	@Override
	public List<UserDTO> findAllUsers() {
		List<User> users = userRepo.findAll();
        return users.stream()
                .map((user) -> mapToUserDto(user))
                .collect(Collectors.toList());
	}
	private UserDTO mapToUserDto(User user){
        UserDTO userDto = new UserDTO();
        String[] str = user.getFirstname().split(" ");
        userDto.setFirstname(str[0]);
        userDto.setLastname(str[0]);
        userDto.setEmail(user.getEmail());
        return userDto;
    }

    private Role_user checkRoleExist(){
        Role_user role = new Role_user();
        role.setName("ROLE_ADMIN");
        return roleRepo.save(role);
    }
	@Override
	public User findUserByid(Long id) {
		// TODO Auto-generated method stub
		return userRepo.findById(id).get();
	}
	@Override
	public void updateUser(User user) {
		userRepo.save(user);
		
	}
	@Override
	public void deleteUser(Long id) {
		userRepo.deleteById(id);
		
	}

}
