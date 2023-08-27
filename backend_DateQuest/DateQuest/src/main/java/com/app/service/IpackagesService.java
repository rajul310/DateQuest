package com.app.service;

import java.util.List;

import com.app.dto.PackagesDTO;
import com.app.entities.Packages;
import com.app.enums.PackagesType;

public interface IpackagesService {
	
    List<Packages> getAllPackages();

    Packages addPackages(PackagesDTO transientPackage);

    String deletePackages(Long id);

    Packages getPackagesById(Long id);
    
    Packages updatePackages(Long id, PackagesDTO pack);
    
    List<Packages> getPackagesByActivities(PackagesType activity);
}
