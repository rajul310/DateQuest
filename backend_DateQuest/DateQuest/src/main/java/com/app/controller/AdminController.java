package com.app.controller;

import com.app.dto.ApiResponseDTO;
import com.app.dto.UserDTO;
import com.app.dto.VendorDTO;
import com.app.entities.User;
import com.app.entities.Vendor;
import com.app.service.IbookingService;
import com.app.service.IuserService;
import com.app.service.IvendorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import javax.validation.Valid;

@RestController
@RequestMapping("/admin")
public class AdminController {

	private final IuserService userServ;
	private final IbookingService bookServ;
	private final IvendorService vendorServ;

	@Autowired
	public AdminController(IuserService userServ, IbookingService bookServ, IvendorService vendorServ) {
		this.userServ = userServ;
		this.bookServ = bookServ;
		this.vendorServ = vendorServ;

	}

	@GetMapping("/users")
	public ResponseEntity<?> getAllUsers() {
		try {
			List<User> users = userServ.getAllUsers();
			if (!users.isEmpty()) {
				return ResponseEntity.status(HttpStatus.OK).body(users);
			} else {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponseDTO("No users found"));
			}

		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(new ApiResponseDTO("An error occurred while fetching Users."));
		}
	}

	// get user by user id

	@GetMapping("/users/{userId}")
	public ResponseEntity<?> getUserById(@PathVariable Long userId) {
		User user = userServ.getUserById(userId);
		if (user != null) {
			return ResponseEntity.status(HttpStatus.OK).body(user);
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponseDTO("User not found"));
		}
	}

	// get users by booking id

	@GetMapping("/users/booking/{bookingId}")
	public ResponseEntity<?> getUsersByBookingId(@PathVariable Long bookingId) {
		try {
			List<User> users = bookServ.getUsersByBookingId(bookingId);
			if (!users.isEmpty()) {
				return ResponseEntity.status(HttpStatus.OK).body(users);
			} else {
				return ResponseEntity.status(HttpStatus.NOT_FOUND)
						.body(new ApiResponseDTO("No users found for the given booking ID"));
			}
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(new ApiResponseDTO("An error occurred while fetching users by booking ID."));
		}
	}

	// get all vendors

	@GetMapping("/vendors")
	public ResponseEntity<?> getAllVendors() {
		try {
			List<Vendor> vendors = vendorServ.getAllVendors();
			if (!vendors.isEmpty()) {
				return ResponseEntity.status(HttpStatus.OK).body(vendors);
			} else {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponseDTO("No vendors found"));
			}
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(new ApiResponseDTO("An error occurred while fetching vendors."));
		}
	}
	// get vendors by vendor id

	@GetMapping("/vendors/{vendorId}")
	public ResponseEntity<?> getVendorById(@PathVariable Long vendorId) {
		try {
			Vendor vendor = vendorServ.getVendorById(vendorId);
			if (vendor != null) {
				return ResponseEntity.status(HttpStatus.OK).body(vendor);
			} else {
				return ResponseEntity.status(HttpStatus.NOT_FOUND)
						.body(new ApiResponseDTO("Vendor not found with Vendor Id: " + vendorId));
			}
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(new ApiResponseDTO("An error occurred while fetching the vendor."));
		}
	}

	// delete vendor by id

	@DeleteMapping("/vendors/{vendorId}")
	public ResponseEntity<?> deleteVendorById(@PathVariable Long vendorId) {
		try {
			String result = vendorServ.deleteVendor(vendorId);
			return ResponseEntity.status(HttpStatus.OK).body(new ApiResponseDTO(result));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(new ApiResponseDTO("An error occurred while deleting the vendor."));
		}
	}
	// delete user by id

	@DeleteMapping("/users/{userId}")
	public ResponseEntity<?> deleteUserById(@PathVariable Long userId) {
		try {
			String result = userServ.deleteUser(userId);
			return ResponseEntity.status(HttpStatus.OK).body(new ApiResponseDTO(result));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(new ApiResponseDTO("An error occurred while deleting the user."));
		}
	}

	// update vendor by id

	@PutMapping("/vendors/{vendorId}")
	public ResponseEntity<?> updateVendorById(@PathVariable Long vendorId,
			@RequestBody @Valid VendorDTO updatedVendor) {
		try {
			Vendor vendor = vendorServ.updateVendor(vendorId, updatedVendor);
			if (vendor != null) {
				return ResponseEntity.status(HttpStatus.OK).body(vendor);
			} else {
				return ResponseEntity.status(HttpStatus.NOT_FOUND)
						.body(new ApiResponseDTO("Vendor not found with id: " + vendorId));
			}
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(new ApiResponseDTO("An error occurred while updating the vendor."));
		}
	}

	// update booking by id

	// update user by id
	@PutMapping("/users/{userId}")
	public ResponseEntity<?> updateUserById(@PathVariable Long userId, @RequestBody @Valid UserDTO updatedUser) {
		try {
			User user = userServ.updateUser(userId, updatedUser);
			if (user != null) {
				return ResponseEntity.status(HttpStatus.OK).body(user);
			} else {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponseDTO("User not found"));
			}
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(new ApiResponseDTO("An error occurred while updating the user."));
		}
	}

	// add user
	@PostMapping("/users")
	public ResponseEntity<?> addUser(@RequestBody @Valid UserDTO newUser) {
		try {
			User addedUser = userServ.addUser(newUser);
			return ResponseEntity.status(HttpStatus.CREATED).body(addedUser);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(new ApiResponseDTO("An error occurred while adding the user."));
		}
	}
	// add vendor

	@PostMapping("/vendors")
	public ResponseEntity<?> addVendor(@RequestBody @Valid VendorDTO newVendor) {
		try {
			Vendor addedVendor = vendorServ.addVendor(newVendor);
			return ResponseEntity.status(HttpStatus.CREATED).body(addedVendor);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(new ApiResponseDTO("An error occurred while adding the vendor."));
		}
	}

}
