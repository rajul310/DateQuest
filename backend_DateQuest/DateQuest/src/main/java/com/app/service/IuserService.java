package com.app.service;

import java.util.List;

import com.app.dto.UserDTO;
import com.app.entities.User;

public interface IuserService {

	List<User> getAllUsers();

	User addUser(UserDTO transientUser);

	String deleteUser(Long id);
	
	 User getUserById(Long id);
	 
	 public User updateUser(Long id, UserDTO updatedUser);
	
	
	

}
