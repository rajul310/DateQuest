package com.app.service;

import java.util.List;
import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.customException.NotFoundException;
import com.app.dto.AuthRequestDTO;
import com.app.dto.UserDTO;
import com.app.entities.User;
import com.app.repository.IuserRepo;

@Service
@Transactional
public class IuserServiceImpl implements IuserService {

	@Autowired
	private IuserRepo userRepo;
	
	@Autowired
	private ModelMapper mapperUser;

	@Override
	public List<User> getAllUsers() {

		return userRepo.findAll();
	}

	  @Override
	    public User addUser(UserDTO transientUser) {
	        User user = mapperUser.map(transientUser, User.class);
	        return userRepo.save(user);
	    }

	@Override
	public String deleteUser(Long id) throws NotFoundException {
		if (userRepo.existsById(id)) {
			userRepo.deleteById(id);
			return "User with ID: " + id + " is deleted. Thank you!";
		} else {
			throw new NotFoundException("User not found with ID: " + id);
		}
	}

	@Override
	public User getUserById(Long id) {
		return userRepo.findById(id).orElseThrow(() -> new NotFoundException("User with ID " + id + " not found."));
	}

	 @Override
	    public User updateUser(Long id, UserDTO updatedUser) {
	        if (userRepo.existsById(id)) {
	            User user = mapperUser.map(updatedUser, User.class);
	            user.setId(id);
	            return userRepo.save(user);
	        } else {
	            throw new NotFoundException("User with ID " + id + " not found.");
	        }
	    }


	 @Override
		public User authenticateUser(AuthRequestDTO request) {
			User ur = userRepo.findByUserEmailAndUserPassword(request.getEmail(), request.getPassword())
					.orElseThrow(() -> new NotFoundException("Invalid Email or password"));
		//	AuthRequestDTO authRespDTO = mapper.map(ur, AuthRequestDTO.class);
			return ur;
			
		}
}
