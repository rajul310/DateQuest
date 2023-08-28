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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.ApiResponseDTO;
import com.app.dto.AuthRequestDTO;
import com.app.dto.PackagesDTO;
import com.app.dto.VendorDTO;
import com.app.entities.Booking;
import com.app.entities.Packages;
import com.app.entities.User;
import com.app.entities.Vendor;
import com.app.service.IbookingService;
import com.app.service.IpackagesService;
import com.app.service.IvendorService;

@RestController
@RequestMapping("/vendors")
@CrossOrigin(origins = "http://localhost:3000/vendors")
public class VendorController {

	@Autowired
	private IpackagesService pkgServ;
	
	@Autowired
	private IbookingService bookServ;
	
	@Autowired
	private IvendorService vendorServ;
	
	
	

	//sign in vendor
	
//	@PostMapping("/signin")
//	public ResponseEntity<?> authenticateUser(@RequestBody @Valid AuthRequestDTO request) {
//		System.out.println("in auth Vendor " + request);
//		return ResponseEntity.status(HttpStatus.OK)
//				.body(vendorServ.authenticateVendor(request));
//		}
	
	//add vendor
	@PostMapping("/signup")
	public ResponseEntity<?> addVendor(@RequestBody @Valid VendorDTO newVendor) {
		try {
			Vendor addedVendor = vendorServ.addVendor(newVendor);
			return ResponseEntity.status(HttpStatus.CREATED).body(addedVendor);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(new ApiResponseDTO("An error occurred while adding the vendor."));
		}
	}
	

	
	//Add Packages
	@PostMapping("/add")
	public ResponseEntity<?> savePackages(@RequestBody @Valid PackagesDTO transientPackages) {
		try {
//			System.out.println("in " +transientPackages);
			Packages savedPackages = pkgServ.addPackages(transientPackages);
//			System.out.println("in" +transientPackages);
			return ResponseEntity.status(HttpStatus.CREATED).body("Packages saved with ID: " + savedPackages.getId());
		} catch (RuntimeException e) {

			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponseDTO(e.getMessage()));

		}
	}
	

	
	// Update Package by Id
	  @PutMapping("/{id}")
	    public ResponseEntity<?> updatePackageById(@PathVariable Long id, @RequestBody  @Valid PackagesDTO updatedPackage) {
	        try {
	            Packages updated = pkgServ.updatePackages(id, updatedPackage);
	            if (updated != null) {
	                return ResponseEntity.status(HttpStatus.OK).body("Package with ID " + id + " updated successfully.");
	            } else {
	                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponseDTO("Package with ID " + id + " not found."));
	            }
	        } catch (RuntimeException e) {
	            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ApiResponseDTO("An error occurred while updating the package."));
	        }
	    }
	
	
	// Get users by booking id
	  @GetMapping("/users/booking/{bookingId}")
	  public ResponseEntity<?> getUsersByBookingId(@PathVariable Long bookingId) {
	      try {
	          List<User> users = bookServ.getUsersByBookingId(bookingId);
	          if (!users.isEmpty()) {
	              return ResponseEntity.status(HttpStatus.OK).body(users);
	          } else {
	              return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponseDTO("No users found for booking ID " + bookingId));
	          }
	      } catch (RuntimeException e) {
	          return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ApiResponseDTO("An error occurred while fetching users."));
	      }
	  }

	  // Get all bookings by user id
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
