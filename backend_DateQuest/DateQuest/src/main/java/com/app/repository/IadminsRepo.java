package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.entities.Admin;

@Repository
public interface IadminsRepo extends JpaRepository<Admin, Long> {

}
