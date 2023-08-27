package com.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.app.entities.Packages;
import com.app.enums.PackagesType;


@Repository
public interface IpackagesRepo extends JpaRepository<Packages,Long>{
	
	  @Query("SELECT p FROM Packages p WHERE p.activities = :activities")
	    List<Packages> findByActivities(@Param("activities") PackagesType activities);

}
