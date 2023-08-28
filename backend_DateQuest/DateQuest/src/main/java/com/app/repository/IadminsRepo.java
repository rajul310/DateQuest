package com.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.entities.Admin;
import com.app.entities.Vendor;

@Repository
public interface IadminsRepo extends JpaRepository<Admin, Long> {
	Optional<Admin> findByAdminEmailAndAdminPassword(String email, String password);


}
