package com.app.service;

import com.app.dto.AdminDTO;
import com.app.entities.Admin;

public interface IadminsService {

	Admin addAdmin(AdminDTO transientAdmin);

	Admin getAdminById(Long id);

	Admin updateAdmin(Long id, AdminDTO admin);

}
