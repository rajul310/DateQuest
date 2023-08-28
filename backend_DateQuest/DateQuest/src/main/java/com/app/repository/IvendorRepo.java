package com.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.entities.Vendor;

@Repository
public interface IvendorRepo extends JpaRepository<Vendor,Long >  {

//	Optional<Vendor> findByVEmailAndVPassword(String email, String password);
}
