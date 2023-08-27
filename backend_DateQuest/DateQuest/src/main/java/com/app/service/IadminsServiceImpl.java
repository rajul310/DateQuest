package com.app.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.app.customException.NotFoundException;
import com.app.dto.AdminDTO;
import com.app.entities.Admin;
import com.app.repository.IadminsRepo;

public class IadminsServiceImpl implements IadminsService {

	@Autowired
	private IadminsRepo adminRepo;

	@Autowired
	private ModelMapper mapperAdmin;

	@Override
	public Admin addAdmin(AdminDTO transientAdmin) {
		Admin admin = mapperAdmin.map(transientAdmin, Admin.class);
		return adminRepo.save(admin);
	}

	@Override
	public Admin getAdminById(Long id) throws NotFoundException {
		return adminRepo.findById(id).orElseThrow(() -> new NotFoundException("Admin with ID " + id + " not found."));
	}

	@Override
	public Admin updateAdmin(Long id, AdminDTO adminDTO) throws NotFoundException {
		if (adminRepo.existsById(id)) {
			Admin admin = mapperAdmin.map(adminDTO, Admin.class);
			admin.setId(id);
			return adminRepo.save(admin);
		} else {
			throw new NotFoundException("Admin with ID " + id + " not found.");
		}
	}

}
