package com.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.entities.User;
@Repository
public interface IuserRepo extends JpaRepository<User,Long > {
	
	Optional<User> findByUserEmailAndUserPassword(String email, String password);

}
