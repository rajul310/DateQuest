package com.app.entities;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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
@Table(name = "Users")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString(exclude = "userPassword")

public class User extends BaseEntity {

	@Column(name = "user_email", length = 100, nullable = false)
	private String userEmail;

	@Column(name = "user_password", length = 300, nullable = false)
	private String userPassword;

	@Column(name = "user_name")
	private String userName;

	@Column(name = "user_mobile_no", unique = true)
	private int userMobileNo;

	@Column(name = "user_dob")
	@JsonFormat(pattern = "yyyy-MM-dd")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate userDob;

	@Column(name = "user_age")
	private int userAge;

	@Enumerated(EnumType.STRING)
	@Column(name = "user_gender")
	private Gender userGender;

	@Column(name = "user_address")
	private String userAddress;

	@Column(name = "user_city")
	private String userCity;

	@Column(name = "user_govt_id")
	private Long userGovtId;

	@OneToOne
	@JoinColumn(name = "feedback_Id")
	private Feedback feedbackId;

	@OneToMany(mappedBy = "userId", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
	private List<Booking> bookings;

	@ManyToOne
	@JoinColumn(name = "booking_id")
	private Booking booking;

}
