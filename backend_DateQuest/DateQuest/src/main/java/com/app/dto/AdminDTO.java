package com.app.dto;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;

import org.springframework.format.annotation.DateTimeFormat;

import com.app.enums.Gender;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor

public class AdminDTO {
	
	@JsonProperty(access = Access.READ_ONLY)
	private Long id;

	@NotBlank(message = "Vendor email is required")
	@Email(message = "Invalid email format")
	@Column(length = 100, nullable = false)
	private String adminEmail;

	@NotBlank(message = "Vendor password is required")
	@Pattern(regexp = "((?=.*\\d)(?=.*[a-z])(?=.*[#@$*]).{5,20})", message = "Invalid password!!!,Password must be Atleast 6 characters long")
	@JsonProperty(access = Access.WRITE_ONLY)
	private String adminPassword;

	@NotBlank(message = "Vendor name is required")
	private String adminName;

	@NotNull(message = "Vendor mobile number is required")
	@Digits(integer = 10, fraction = 0, message = "Invalid mobile number")
	private int adminMobileNo;

	@NotNull(message = "Vendor date of birth is required")
	@Past(message = "Date of birth must be in the past")
	@JsonFormat(pattern = "yyyy-MM-dd")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate vDob;

	@Min(value = 18, message = "Vendor must be at least 18 years old")
	@Max(value = 120, message = "Vendor age cannot be more than 120")
	private int adminAge;

	@NotNull(message = "Vendor gender is required")
	@Enumerated(EnumType.STRING)
	private Gender adminGender;

	@NotBlank(message = "Vendor address is required")
	private String adminAddress;

	@NotBlank(message = "Vendor city is required")
	private String adminCity;

	@NotBlank(message = "Vendor government ID is required")
	private String adminGovtId;

}
