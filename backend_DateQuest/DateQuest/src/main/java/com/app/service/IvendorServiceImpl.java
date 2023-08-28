package com.app.service;

import java.util.List;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.customException.NotFoundException;
import com.app.dto.AuthRequestDTO;
import com.app.dto.VendorDTO;
import com.app.entities.User;
import com.app.entities.Vendor;
import com.app.repository.IvendorRepo;

@Service
@Transactional
public class IvendorServiceImpl implements IvendorService {

	@Autowired
	private IvendorRepo vendorRepo;

	@Autowired
	private ModelMapper mapperVendor;

	@Override
	public List<Vendor> getAllVendors() {
		return vendorRepo.findAll();
	}

	@Override
	public Vendor addVendor(VendorDTO transientVendor) {
		Vendor vendor = mapperVendor.map(transientVendor, Vendor.class);
		return vendorRepo.save(vendor);
	}

	@Override
	public String deleteVendor(Long id) {
		if (vendorRepo.existsById(id)) {
			vendorRepo.deleteById(id);
			return "Vendor with ID " + id + " deleted successfully.";
		} else {
			throw new NotFoundException("Vendor with ID " + id + " not found.");
		}
	}

	@Override
	public Vendor getVendorById(Long id) {
		return vendorRepo.findById(id).orElseThrow(() -> new NotFoundException("Vendor with ID " + id + " not found."));

	}

	@Override
	public Vendor updateVendor(Long id, VendorDTO vendorDTO) throws NotFoundException {
		if (vendorRepo.existsById(id)) {
			Vendor vendor = mapperVendor.map(vendorDTO, Vendor.class);
			vendor.setId(id);
			return vendorRepo.save(vendor);
		} else {
			throw new NotFoundException("Vendor with ID " + id + " not found.");
		}
	}

//	@Override
//	public Vendor authenticateVendor(AuthRequestDTO request) {
////	Vendor vendor = vendorRepo.findByVEmailAndVPassword(request.getEmail(), request.getPassword())
////					.orElseThrow(() -> new NotFoundException("Invalid Email or password"));
////		//	AuthRequestDTO authRespDTO = mapper.map(vendor, AuthRequestDTO.class);
//	return vendor;
//			
//		}
	}


