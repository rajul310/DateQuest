package com.app.service;

import com.app.dto.AdminDTO;
import com.app.dto.AuthRequestDTO;
import com.app.entities.Admin;
import com.app.entities.Vendor;

public interface IadminsService {

	Admin addAdmin(AdminDTO transientAdmin);

	Admin getAdminById(Long id);

	Admin updateAdmin(Long id, AdminDTO admin);
	
	public Admin authenticateAdmin(AuthRequestDTO request);

}
