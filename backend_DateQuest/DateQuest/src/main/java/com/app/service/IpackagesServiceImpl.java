package com.app.service;
import java.util.List;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.customException.NotFoundException;
import com.app.dto.PackagesDTO;
import com.app.entities.Packages;
import com.app.enums.PackagesType;
import com.app.repository.IpackagesRepo;


@Service
@Transactional
public class IpackagesServiceImpl implements IpackagesService {

	@Autowired
    private IpackagesRepo packagesRepo;
	
	@Autowired
	private ModelMapper mapperPkg;


    @Override
    public List<Packages> getAllPackages() {
        return packagesRepo.findAll();
    }

    @Override
    public Packages addPackages(PackagesDTO transientPackage) {
        Packages packages = mapperPkg.map(transientPackage, Packages.class);
        return packagesRepo.save(packages);
    }

    @Override
    public String deletePackages(Long id) throws NotFoundException {
        if (packagesRepo.existsById(id)) {
            packagesRepo.deleteById(id);
            return "Package with ID " + id + " deleted successfully.";
        } else {
        	 throw new NotFoundException("Package with ID " + id + " not found.");
        }
    }

    @Override
    public Packages getPackagesById(Long id) throws NotFoundException {
        return packagesRepo.findById(id).orElseThrow(() -> new NotFoundException("Package with ID " + id + " not found."));
    }

    @Override
    public Packages updatePackages(Long id, PackagesDTO pack) throws NotFoundException {
        if (packagesRepo.existsById(id)) {
            Packages packages = mapperPkg.map(pack, Packages.class);
            packages.setId(id);
            return packagesRepo.save(packages);
        } else {
            throw new NotFoundException("Package with ID " + id + " not found.");
        }
    }

	@Override
	public List<Packages> getPackagesByActivities(PackagesType activities) {
		return packagesRepo.findByActivities(activities);
	}

	

	
}
