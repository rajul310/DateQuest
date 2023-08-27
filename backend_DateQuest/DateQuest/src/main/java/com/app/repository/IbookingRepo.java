package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.entities.Booking;

@Repository
public interface IbookingRepo extends JpaRepository<Booking, Long> {

}
