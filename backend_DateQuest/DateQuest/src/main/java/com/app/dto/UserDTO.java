package com.app.dto;

import java.time.LocalDate;

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
import javax.validation.constraints.Size;

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

public class UserDTO {
	@JsonProperty(access = Access.READ_ONLY)
	private Long id;

	@NotBlank(message = "User email is required")
	@Email(message = "Invalid email format")
	private String userEmail;

	@NotBlank(message = "User password is required")
	@Pattern(regexp = "((?=.*\\d)(?=.*[a-z])(?=.*[#@$*]).{5,20})", message = "Invalid password!!!,Password must be Atleast 6 characters long")
	@JsonProperty(access = Access.WRITE_ONLY)
	private String userPassword;

	@NotBlank(message = "User name is required")
	@Size(max = 100, message = "Name cannot exceed 100 characters")
	private String userName;

	@NotNull(message = "User mobile number is required")
	@Digits(integer = 10, fraction = 0, message = "Invalid mobile number")
	private Long userMobileNo;

	@NotNull(message = "User date of birth is required")
	@Past(message = "Date of birth must be in the past")
	@JsonFormat(pattern = "yyyy-MM-dd")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate userDob;

	@Min(value = 18, message = "User must be at least 18 years old")
	@Max(value = 120, message = "User age cannot be more than 120")
	private int userAge;

	@NotNull(message = "User gender is required")
	@Enumerated(EnumType.STRING)
	private Gender userGender;

	@NotBlank(message = "User address is required")
	@Size(max = 255, message = "Address cannot exceed 255 characters")
	private String userAddress;

	@NotBlank(message = "User city is required")
	@Size(max = 100, message = "City name cannot exceed 100 characters")
	private String userCity;

	@NotNull(message = "User government ID is required")
	private Long userGovtId;

}
