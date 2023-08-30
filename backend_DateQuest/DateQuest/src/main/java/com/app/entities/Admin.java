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
@ToString(exclude = "adminPassword")

public class Admin extends BaseEntity {

	@Column(name = "admin_email", length = 100, nullable = false)
	private String adminEmail;

	@Column(name = "admin_password", length = 300, nullable = false)
	private String adminPassword;

	@Column(name = "admin_name")
	private String adminName;

	@Column(name = "admin_mobile_no", unique = true)
	private int adminMobileNo;

	@Column(name = "admin_dob")
	@JsonFormat(pattern = "yyyy-MM-dd")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate adminDob;

	@Column(name = "admin_age")
	private int adminAge;

	@Enumerated(EnumType.STRING)
	@Column(name = "admin_gender")
	private Gender adminGender;

	@Column(name = "admin_address")
	private String adminAddress;

	@Column(name = "admin_city")
	private String adminCity;

	@Column(name = "admin_govt_id")
	private String adminGovtId;

}
