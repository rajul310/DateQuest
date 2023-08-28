package com.app.service;

import java.util.List;

import javax.validation.Valid;

import com.app.dto.AuthRequestDTO;
import com.app.dto.VendorDTO;
import com.app.entities.Vendor;

public interface IvendorService {

	List<Vendor> getAllVendors();

	Vendor addVendor(VendorDTO transientVendor);

	String deleteVendor(Long id);

	Vendor getVendorById(Long id);

	Vendor updateVendor(Long id, VendorDTO vendor);

//	public Vendor authenticateVendor(AuthRequestDTO request);

}
