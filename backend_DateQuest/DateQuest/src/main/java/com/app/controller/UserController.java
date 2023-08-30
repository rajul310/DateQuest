package com.app.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.ApiResponseDTO;
import com.app.dto.AuthRequestDTO;
import com.app.dto.PackagesDTO;
import com.app.dto.UserDTO;
import com.app.entities.Booking;
import com.app.entities.Packages;
import com.app.entities.User;
import com.app.enums.PackagesType;
import com.app.service.IbookingService;
import com.app.service.IpackagesService;
import com.app.service.IuserService;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {

	@Autowired
	private IuserService userServ;

	@Autowired
	private IpackagesService pkgServ;
	
	@Autowired
	private IbookingService bookServ;
	
	
	
	
	//sign in user
	
	@PostMapping("/login")
	public ResponseEntity<?> authenticateUser(@RequestBody @Valid AuthRequestDTO request) {
		System.out.println("in auth User " + request);
		return ResponseEntity.status(HttpStatus.OK)
				.body(userServ.authenticateUser(request));
		}

	// Get all Packages
	@GetMapping("/packages")
	public ResponseEntity<?> getAllPackages(Packages transientPackage) {
		return ResponseEntity.status(HttpStatus.OK).body(pkgServ.getAllPackages());
	}


	// Add User 
	@PostMapping("/signup")
	public ResponseEntity<?> saveUser(@RequestBody @Valid UserDTO transientUser) {
		try {
			User savedUser = userServ.addUser(transientUser);
			return ResponseEntity.status(HttpStatus.CREATED).body("User saved with ID: " + savedUser.getId());
		} catch (RuntimeException e) {

			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponseDTO(e.getMessage()));

		}
	}
	
	//get packages by activities
	
	@GetMapping("/packages/{activities}")
	public ResponseEntity<?> getPackagesByActivity(@PathVariable PackagesType activities) {
		
	    try {
	        List<PackagesDTO> packages = pkgServ.getPackagesByActivities(activities);
	        if (!packages.isEmpty()) {
	            return ResponseEntity.status(HttpStatus.OK).body(packages);
	        } else {
	            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponseDTO("No packages found for activity: " + activities));
	        }
	    } catch (RuntimeException e) {
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ApiResponseDTO("An error occurred while fetching packages."));
	    }
	}
	
	
	
	// get booking by  user id
	
	  @GetMapping("/bookings/{userId}")
	  public ResponseEntity<?> getAllBookingsByUserId(@PathVariable Long userId) {
	      try {
	          List<Booking> bookings = bookServ.getBookingsByUserId(userId);
	          if (!bookings.isEmpty()) {
	              return ResponseEntity.status(HttpStatus.OK).body(bookings);
	          } else {
	              return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponseDTO("No bookings found for user ID " + userId));
	          }
	      } catch (RuntimeException e) {
	          return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ApiResponseDTO("An error occurred while fetching bookings."));
	      }
	  }
	  
	  

}