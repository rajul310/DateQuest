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
@ToString(exclude = "userPassword" )

public class User extends BaseEntity {
	
	@Column(length = 100, nullable = false) 
	private String userEmail;
	
	@Column(length = 300, nullable = false)
	private String userPassword;

	private String userName;
	@Column(unique = true)
	private int userMobileNo;

	@JsonFormat(pattern = "yyyy-MM-dd")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate userDob;

	private int userAge;

	@Enumerated(EnumType.STRING)
	private Gender userGender;

	private String userAddress;

	private String userCity;

	private Long userGovtId;
	
	@OneToOne
	@JoinColumn(name = "feedback_Id")
	private Feedback feedbackId;
	
	@OneToMany(mappedBy = "userId",cascade = CascadeType.ALL, orphanRemoval = true,fetch = FetchType.EAGER)
	private List<Booking> bookings;
	
	@ManyToOne
	@JoinColumn(name = "booking_id")
	private Booking booking;

}
