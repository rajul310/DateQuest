package com.app.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.app.enums.Gender;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Entity
@Table(name = "Admins")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString(exclude = "adminPassword" )

public class Admin extends BaseEntity{
	
	@Column(length = 100, nullable = false) 
	private String adminEmail;
	
	@Column(length = 300, nullable = false)
	private String adminPassword;
	
	private String adminName;
	@Column(unique = true)
	private int adminMobileNo;
	
	@JsonFormat(pattern="yyyy-MM-dd")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate adminDob;
	
	private int adminAge ;
	
	@Enumerated(EnumType.STRING)
	private Gender adminGender;
	
	private String adminAddress;
	
	private String  adminCity;
	

	private String adminGovtId;


}
